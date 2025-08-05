package com.example.commodities.screens_static

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.core.content.edit
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController, context: Context) {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    var agreed by remember { mutableStateOf(prefs.getBoolean("agreedPrivacy", false)) }

    val onLogin: (String) -> Unit = { plat ->
        prefs.edit { putBoolean("loggedIn", true) }
        navController.navigate("videoFeed") {
            popUpTo("login") { inclusive = true }
        }
    }
    val onChangeAgree: (Boolean) -> Unit = { checked ->
        agreed = checked
        prefs.edit { putBoolean("agreedPrivacy", agreed) }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login Page")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onLogin("Google") }) {
            Text("Sign in (Google)")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onLogin("Apple") }) {
            Text("Sign in (Apple)")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = agreed, onCheckedChange = onChangeAgree)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "我已阅读并同意《隐私协议》",
                color = Color.Blue,
                modifier = Modifier.clickable {
                    navController.navigate("protocol/privacy")
                }
            )
        }
    }
}