package com.example.commodities.componets_video

import android.content.Context
import java.io.File
import java.net.URL
import java.security.MessageDigest

// 工具：用url生成本地缓存文件对象
fun getImageCacheFile(context: Context, url: String): File {
    val fileName = url.md5() + ".img"
    return File(context.cacheDir, "image_cache/$fileName")
}
// 工具
fun getVideoCacheFile(context: Context, url: String): File {
    val fileName = url.md5() + ".mp4"
    return File(context.cacheDir, "video_cache/$fileName")
}
suspend fun downloadAndCacheFile(url: String, file: File): Boolean {
    try {
        file.parentFile?.mkdirs()
        val bytes = URL(url).openStream().use { it.readBytes() }
        file.writeBytes(bytes)
        return true
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }
}

// 简单md5函数
fun String.md5(): String = MessageDigest.getInstance("MD5")
    .digest(toByteArray()).joinToString("") { "%02x".format(it) }
