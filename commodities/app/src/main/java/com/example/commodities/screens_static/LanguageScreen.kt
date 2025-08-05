package com.example.commodities.screens_static

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.navigation.NavController

@Composable
fun LanguageScreen(navController: NavController, context: Context) {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    val onLanguageSelected: (String) -> Unit = { lang ->
        prefs.edit { putString("language", lang) }
        navController.navigate("login") {
            popUpTo("language") { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Choose a language")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onLanguageSelected("en") }) {
            Text("English")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onLanguageSelected("zh") }) {
            Text("中文")
        }
    }
}
