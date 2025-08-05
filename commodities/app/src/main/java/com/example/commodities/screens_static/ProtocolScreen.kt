package com.example.commodities.screens_static

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.navigation.NavController
import com.example.commodities.components_basic.CustomTopBar
import com.example.commodities.modle_class.protocolMapInit

@Composable
fun ProtocolScreen(
    navController: NavController,
    protocolType: String, context: Context,
    modifier: Modifier = Modifier
) {
    val protocol = protocolMapInit[protocolType] ?: return
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun onProtocolButtonClick() {
        when (protocolType) {
            "privacy" -> {
                prefs.edit { putBoolean("agreedPrivacy", true) }
                navController.navigate("login")
            }
            "reward" -> {
                navController.popBackStack()
            }
            else -> {
                navController.popBackStack()
            }
        }
    }

    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CustomTopBar(
            title = protocol.titleText,
            backText = protocol.backText,
            onBack = { navController.popBackStack() }
        )
        // 正文和按钮
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = protocol.contentText,
                modifier = Modifier.weight(1f)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onProtocolButtonClick() }
            ) {
                Text(protocol.buttonText)
            }
        }
    }
}