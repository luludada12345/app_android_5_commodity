package com.example.commodities.utils

import android.graphics.Bitmap
import android.graphics.Color
import androidx.core.graphics.createBitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

fun generateQrCodeBitmap(): Bitmap? {
    val content = "my_user_id"
    return try {
        val size = 512
        val bits = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, size, size)
        val bmp = createBitmap(size, size, Bitmap.Config.RGB_565)  // 用 KTX 的扩展函数
        val pixels = IntArray(size * size)
        for (y in 0 until size) {
            for (x in 0 until size) {
                val color = if (bits[x, y]) Color.BLACK else Color.WHITE
                pixels[y * size + x] = color
            }
        }
        bmp.setPixels(pixels, 0, size, 0, 0, size, size)
        bmp
    } catch (e: Exception) {
        null
    }
}
