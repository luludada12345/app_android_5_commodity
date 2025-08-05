package com.example.commodities.screens

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.commodities.components.ChatMessageItem
import com.example.commodities.components_basic.CustomTopBarChat
import com.example.commodities.modle_class.ChatItem
import com.example.commodities.modle_class.ChatMessage
import com.example.commodities.modle_class.ChatMessageListInit
import kotlin.String

@Composable
fun ChatMessageScreen(
    navController: NavController
) {
    var inputText by remember { mutableStateOf("") }
    val chatWith = ChatItem(
        id = "",
        avatarUrl = "",
        nickname = "",
        lastMessage = "",
        lastMsgTime = "",
        unreadCount = 0
    )
    val chatMessageList: List<ChatMessage> = ChatMessageListInit
    val onSend: (String) -> Unit = {}
    val onSendImage: (Uri) -> Unit = {}
    val onLongPress: (ChatMessage) -> Unit = {}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
    ) {
        CustomTopBarChat(
            nickname = chatWith.nickname,
            avatarUrl = chatWith.avatarUrl,
            onBack = { /* 返回逻辑 */ },
            onMore = { /* 更多操作 */ }
        )
        // 聊天消息列表
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = true
        ) {
            items(chatMessageList.reversed()) { msg ->
                ChatMessageItem(
                    message = msg,
                    onLongPress = { onLongPress(msg) }
                )
            }
        }
        // 输入栏
        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White, RoundedCornerShape(24.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* 打开表情面板 */ }) {
                Icon(Icons.Default.EmojiEmotions, contentDescription = "表情")
            }
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("输入消息...") },
                maxLines = 4,
                singleLine = false,
                shape = RoundedCornerShape(16.dp)
            )
            IconButton(onClick = { /* 打开图片选择 */ }) {
                Icon(Icons.Default.Photo, contentDescription = "图片")
            }
            IconButton(
                onClick = {
                    if (inputText.isNotBlank()) {
                        onSend(inputText)
                        inputText = ""
                    }
                },
                enabled = inputText.isNotBlank()
            ) {
                Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "发送")
            }
        }
    }
}
