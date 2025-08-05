package com.example.commodities.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.commodities.model.ActivityViewModel

@Composable
fun ActivityDetailScreen(actViewModel: ActivityViewModel) {
    val context = LocalContext.current
    val act = actViewModel.currentActivity

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = act.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = act.date)
        Text(text = act.description, modifier = Modifier.padding(vertical = 8.dp))
        Button(onClick = {
            Toast.makeText(context, "Applied", Toast.LENGTH_SHORT).show()
        }) {
            Text("Apply Now")
        }
    }
}
