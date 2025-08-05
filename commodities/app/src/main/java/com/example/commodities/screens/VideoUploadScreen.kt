package com.example.commodities.screens

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VideoUploadScreen(
) {
    var videoUri by remember { mutableStateOf<Uri?>(null) }
    var description by remember { mutableStateOf("") }
    var isPublic by remember { mutableStateOf(true) }
    var uploading by remember { mutableStateOf(false) }
    var uploadProgress by remember { mutableFloatStateOf(0f) }

    val onUploadSuccess: () -> Unit = {}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 视频选择或预览
        if (videoUri == null) {
            OutlinedButton(
                onClick = { /* 选择视频/拍摄逻辑 */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.VideoLibrary, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("选择视频")
            }
        } else {
            // 预览（用ExoPlayer等实现，略）
            Text("已选择视频: $videoUri", color = Color.Gray)
            // VideoPlayer(videoUri)
            Spacer(Modifier.height(12.dp))
        }

        // 描述/标题
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("描述/标题") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(12.dp))

        // 隐私设置
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("公开")
            Switch(checked = isPublic, onCheckedChange = { isPublic = it })
            Text("私密")
        }

        Spacer(Modifier.height(24.dp))
        // 上传按钮
        Button(
            onClick = {
                uploading = true
                // 伪造上传逻辑
                // 上传过程中更新uploadProgress, 上传成功调用onUploadSuccess
            },
            enabled = videoUri != null && !uploading,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (uploading) {
                CircularProgressIndicator(
                    progress = { uploadProgress },
                    modifier = Modifier.size(18.dp),
                    color = Color.White,
                    strokeWidth = ProgressIndicatorDefaults.CircularStrokeWidth,
                    trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
                    strokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
                )
                Spacer(Modifier.width(8.dp))
                Text("上传中...")
            } else {
                Text("上传")
            }
        }
    }
}
