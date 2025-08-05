package com.example.commodities.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.commodities.components_basic.CustomTopBar

@Composable
fun RewardUploadPaymentProof(navController: NavHostController) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var paymentLink by remember { mutableStateOf("") }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    // 只要上传图片或填写了链接，按钮可用
    val canSubmit = imageUri != null || paymentLink.isNotBlank()

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), // 如需滚动
            verticalArrangement = Arrangement.Top
        ) {
            CustomTopBar(
                title = "上传付款凭证",
                backText = "返回",
                onBack = { navController.popBackStack() }
            )

            OutlinedButton(
                onClick = { imagePickerLauncher.launch("image/*") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.Photo, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(if (imageUri != null) "已选择图片" else "上传付款截图")
            }
            if (imageUri != null) {
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }

            Spacer(Modifier.height(24.dp))

            OutlinedTextField(
                value = paymentLink,
                onValueChange = { paymentLink = it },
                label = { Text("付款链接") },
                placeholder = { Text("请输入付款链接") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
        // 底部上传按钮（悬浮在底部，不随内容滚动）
        Button(
            onClick = {
                navController.popBackStack()
            },
            enabled = canSubmit,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("上传")
        }
    }
}