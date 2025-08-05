package com.example.commodities.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.commodities.components.ChatListItem
import com.example.commodities.modle_class.ChatItem
import com.example.commodities.modle_class.chatItemListInit

@Composable
fun ChatListScreen(
    navController: NavController
) {
    var searchQuery by remember { mutableStateOf("") }

    val chatItemList: List<ChatItem> = chatItemListInit
    val onClick: (ChatItem) -> Unit = {
        navController.navigate("chatDetail")
    }
    val onDelete: (ChatItem) -> Unit = {}
    val onSearch: (String) -> Unit = {}

    Column(modifier = Modifier.fillMaxSize()) {
        // 搜索框
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it; onSearch(it) },
            label = { Text("搜索") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // 聊天列表
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(chatItemList.filter {
                it.nickname.contains(searchQuery, true) ||
                        it.lastMessage.contains(searchQuery, true)
            }) { chat ->
                ChatListItem(
                    chatItem = chat,
                    onClick = { onClick(chat) },
                    onLongPress = { onDelete(chat) }
                )
                Divider()
            }
        }
    }
}
