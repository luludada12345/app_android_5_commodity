package com.example.commodities.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.commodities.modle_class.ChatMessage
import com.example.commodities.modle_class.MessageType

// 单条消息气泡
@Composable
fun ChatMessageItem(
    message: ChatMessage,
    onLongPress: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        horizontalArrangement = if (message.isMine) Arrangement.End else Arrangement.Start
    ) {
        if (!message.isMine) {
            Image(
                painter = rememberAsyncImagePainter(message.senderAvatar),
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(4.dp))
        }
        // 气泡
        Box(
            modifier = Modifier
                .background(
                    if (message.isMine) Color(0xFFB3E5FC) else Color.White,
                    RoundedCornerShape(12.dp)
                )
                .padding(8.dp)
                .combinedClickable(
                    onClick = {},
                    onLongClick = onLongPress
                )
        ) {
            when (message.type) {
                MessageType.TEXT -> Text(message.content)
                MessageType.IMAGE -> {
                    Image(
                        painter = rememberAsyncImagePainter(message.content),
                        contentDescription = null,
                        modifier = Modifier.size(120.dp)
                    )
                }
            }
        }
        if (message.isMine) {
            Spacer(Modifier.width(4.dp))
            Image(
                painter = rememberAsyncImagePainter(message.senderAvatar),
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
            )
        }
    }
}
