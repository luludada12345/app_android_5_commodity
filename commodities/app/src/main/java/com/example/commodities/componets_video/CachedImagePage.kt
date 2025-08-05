package com.example.commodities.componets_video

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

@Composable
fun CachedImagePage(context: Context, imageUrl: String) {
    var localPath by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    // 检查本地缓存
    LaunchedEffect(imageUrl) {
        val cacheFile = getImageCacheFile(context, imageUrl)
        if (cacheFile.exists()) {
            localPath = cacheFile.absolutePath
        } else {
            // 下载图片并缓存
            scope.launch(Dispatchers.IO) {
                val downloaded = downloadAndCacheFile(imageUrl, cacheFile)
                if (downloaded) {
                    withContext(Dispatchers.Main) { localPath = cacheFile.absolutePath }
                }
            }
        }
    }

    // 显示本地图片
    if (localPath != null) {
        AsyncImage(
            model = File(localPath!!),
            contentDescription = "本地缓存图片",
            modifier = Modifier.fillMaxSize()
        )
    } else {
        CircularProgressIndicator()
    }
}
