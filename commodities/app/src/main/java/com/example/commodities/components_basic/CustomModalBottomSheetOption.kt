package com.example.commodities.components_basic

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomModalBottomSheetOption(text: String, showDivider: Boolean = false, onClick: () -> Unit) {
    ListItem(
        headlineContent = { Text(text) },
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(MaterialTheme.colorScheme.surface)
    )
    if (showDivider) {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), // 左右间距,
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.06f)
        )
    }
}
