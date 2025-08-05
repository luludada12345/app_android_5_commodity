package com.example.commodities.screens_static

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.asImageBitmap
import androidx.navigation.NavController

import com.example.commodities.utils.generateQrCodeBitmap

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.core.content.ContextCompat
import android.content.Context
import android.util.Log
import com.example.commodities.components_basic.CustomTopBar
import com.example.commodities.utils.printLocation

@Composable
fun QrCodeScreen(navController: NavController, context: Context, modifier: Modifier = Modifier) {
    var hasLocationPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    // 申请权限
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasLocationPermission = isGranted
        if (isGranted) {
            // 用户授权后，打印位置
            printLocation(context)
        } else {
            Log.d("ProfileScreen", "用户拒绝了位置权限")
        }
    }

    // 首次进入页面判断权限并处理
    LaunchedEffect(Unit) {
        if (hasLocationPermission) {
            printLocation(context)
        } else {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        CustomTopBar(
            title = "我的二维码",
            backText = "返回",
            onBack = { navController.popBackStack() }
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            val qrBitmap = generateQrCodeBitmap()
            qrBitmap?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "二维码",
                    modifier = Modifier.size(240.dp)
                )
            } ?: Text("二维码生成失败")
        }
    }
}
