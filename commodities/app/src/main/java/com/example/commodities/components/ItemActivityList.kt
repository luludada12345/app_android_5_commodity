package com.example.commodities.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.commodities.modle_class.Activity

@Composable
fun ActivityListItem(
    act: Activity,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick }
            .padding(16.dp)) {
        Text(text = act.title, fontWeight = FontWeight.Bold)
        Text(text = act.location)
    }
}