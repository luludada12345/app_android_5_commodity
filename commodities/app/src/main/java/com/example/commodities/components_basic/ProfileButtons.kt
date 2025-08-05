package com.example.commodities.components_basic

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileButtonListA(
    onShowModalBottomSheet: () -> Unit,
    goVideoUpload: () -> Unit,
    goVideoSearch: () -> Unit,
) {
    Row {
        Button(onClick = onShowModalBottomSheet, shape = RoundedCornerShape(12.dp)) {
            Text("选项卡B")
        }
        Spacer(Modifier.width(12.dp))
        Button(onClick = goVideoUpload, shape = RoundedCornerShape(12.dp)) {
            Icon(Icons.Default.Upload, contentDescription = "upload")
            Text("uploadV")
        }
        Spacer(Modifier.width(12.dp))
        OutlinedButton(onClick = goVideoSearch, shape = RoundedCornerShape(12.dp)) {
            Icon(Icons.Default.Search, contentDescription = "search")
            Text("searchV", fontSize = 15.sp)
        }
    }
}

@Composable
fun ProfileButtonListB(
    onEdit: () -> Unit,
    onChangeTheme: () -> Unit,
    onShare: () -> Unit,
) {
    Row {
        Button(onClick = onEdit, shape = RoundedCornerShape(12.dp)) {
            Text("编辑资料")
        }
        Spacer(Modifier.width(12.dp))
        Button(onClick = onChangeTheme, shape = RoundedCornerShape(12.dp)) {
            Text("切花主题")
        }
        Spacer(Modifier.width(12.dp))
        OutlinedButton(onClick = onShare, shape = RoundedCornerShape(12.dp)) {
            Icon(Icons.Default.Share, contentDescription = "分享")
            Text("分享", fontSize = 15.sp)
        }
    }
}