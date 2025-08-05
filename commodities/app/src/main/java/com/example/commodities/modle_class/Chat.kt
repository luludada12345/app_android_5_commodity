package com.example.commodities.modle_class

data class ChatItem(
    val id: String,
    val avatarUrl: String,
    val nickname: String,
    val lastMessage: String,
    val lastMsgTime: String,
    val unreadCount: Int,
)
data class ChatMessage(
    val id: String,
    val senderId: String,
    val senderAvatar: String,
    val content: String,
    val type: MessageType, // TEXT, IMAGE
    val time: String,
    val isMine: Boolean,
)

enum class MessageType { TEXT, IMAGE }

val chatItemListInit = listOf(
    ChatItem(
        id = "1",
        avatarUrl = "https://randomuser.me/api/portraits/men/1.jpg",
        nickname = "小明",
        lastMessage = "在吗？",
        lastMsgTime = "2025-07-12 17:45",
        unreadCount = 2
    ),
    ChatItem(
        id = "2",
        avatarUrl = "https://randomuser.me/api/portraits/women/2.jpg",
        nickname = "Lily",
        lastMessage = "收到，明天见！",
        lastMsgTime = "2025-07-12 15:22",
        unreadCount = 0
    ),
    ChatItem(
        id = "3",
        avatarUrl = "https://randomuser.me/api/portraits/men/3.jpg",
        nickname = "Tom",
        lastMessage = "图片已发，请查收",
        lastMsgTime = "2025-07-11 21:07",
        unreadCount = 5
    ),
    ChatItem(
        id = "4",
        avatarUrl = "https://randomuser.me/api/portraits/women/4.jpg",
        nickname = "琪琪",
        lastMessage = "晚安😴",
        lastMsgTime = "2025-07-10 23:59",
        unreadCount = 0
    ),
    ChatItem(
        id = "5",
        avatarUrl = "https://randomuser.me/api/portraits/men/5.jpg",
        nickname = "Jack",
        lastMessage = "ok",
        lastMsgTime = "2025-07-10 10:31",
        unreadCount = 1
    )
)


val ChatMessageListInit = listOf(
    ChatMessage(
        id = "msg001",
        senderId = "1",
        senderAvatar = "https://randomuser.me/api/portraits/men/1.jpg",
        content = "你好！",
        type = MessageType.TEXT,
        time = "2025-07-12 17:45",
        isMine = false
    ),
    ChatMessage(
        id = "msg002",
        senderId = "0",
        senderAvatar = "https://randomuser.me/api/portraits/men/0.jpg",
        content = "你好，小明！",
        type = MessageType.TEXT,
        time = "2025-07-12 17:45",
        isMine = true
    ),
    ChatMessage(
        id = "msg003",
        senderId = "1",
        senderAvatar = "https://randomuser.me/api/portraits/men/1.jpg",
        content = "你看下这张图片",
        type = MessageType.TEXT,
        time = "2025-07-12 17:46",
        isMine = false
    ),
    ChatMessage(
        id = "msg004",
        senderId = "1",
        senderAvatar = "https://randomuser.me/api/portraits/men/1.jpg",
        content = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=400",
        type = MessageType.IMAGE,
        time = "2025-07-12 17:46",
        isMine = false
    ),
    ChatMessage(
        id = "msg005",
        senderId = "0",
        senderAvatar = "https://randomuser.me/api/portraits/men/0.jpg",
        content = "很漂亮👍",
        type = MessageType.TEXT,
        time = "2025-07-12 17:47",
        isMine = true
    )
)
