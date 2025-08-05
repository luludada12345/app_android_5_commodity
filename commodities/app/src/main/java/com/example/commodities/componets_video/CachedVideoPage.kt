package com.example.commodities.componets_video

import android.content.Context
import android.widget.VideoView
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
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun CachedVideoPage(context: Context, videoUrl: String) {
    var localPath by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(videoUrl) {
        val cacheFile = getVideoCacheFile(context, videoUrl)
        if (cacheFile.exists()) {
            localPath = cacheFile.absolutePath
        } else {
            scope.launch(Dispatchers.IO) {
                val downloaded = downloadAndCacheFile(videoUrl, cacheFile)
                if (downloaded) {
                    withContext(Dispatchers.Main) { localPath = cacheFile.absolutePath }
                }
            }
        }
    }

    if (localPath != null) {
        AndroidView(
            factory = {
                VideoView(it).apply {
                    setVideoPath(localPath)
                    start()
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    } else {
        CircularProgressIndicator()
    }
}

