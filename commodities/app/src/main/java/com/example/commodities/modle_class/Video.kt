package com.example.commodities.modle_class

data class VideoItem(
    val url: String = "",
    val authorAvatar: String = "",
    val authorName: String = "",
    val description: String = "",
    val isLiked: Boolean = false,
    val isFollowed: Boolean = false,
    val likeCount: Int = 100,
    val commentCount: Int = 999,
    val shareCount: Int = 102,
    val id: String = "",
    val coverUrl: String = "",
    val videoUrl: String = ""
)

val VideoItemListInit = listOf(
    VideoItem(
        url = "https://cloudfront1.commodity-standards.com/videos/202407__/DLYP0643.MP4",
        authorAvatar = "https://randomuser.me/api/portraits/men/1.jpg",
        authorName = "张三",
        description = "一次精彩的旅程分享。",
        isLiked = true,
        isFollowed = false,
        likeCount = 152,
        commentCount = 87,
        shareCount = 33,
        id = "DLYP0643",
        coverUrl = "https://picsum.photos/seed/1/600/800",
        videoUrl = "https://cloudfront1.commodity-standards.com/videos/202407__/DLYP0643.MP4"
    ),
    VideoItem(
        url = "https://cloudfront1.commodity-standards.com/videos/202407__/IMG_8034.MOV",
        authorAvatar = "https://randomuser.me/api/portraits/women/2.jpg",
        authorName = "李四",
        description = "搞笑日常，笑到肚子疼。",
        isLiked = false,
        isFollowed = true,
        likeCount = 321,
        commentCount = 112,
        shareCount = 41,
        id = "IMG_8034",
        coverUrl = "https://picsum.photos/seed/2/600/800",
        videoUrl = "https://cloudfront1.commodity-standards.com/videos/202407__/IMG_8034.MOV"
    ),
    VideoItem(
        url = "https://cloudfront1.commodity-standards.com/videos/202407__/IMG_8080.MOV",
        authorAvatar = "https://randomuser.me/api/portraits/men/3.jpg",
        authorName = "王五",
        description = "萌宠日常，猫咪超可爱。",
        isLiked = true,
        isFollowed = true,
        likeCount = 278,
        commentCount = 66,
        shareCount = 22,
        id = "IMG_8080",
        coverUrl = "https://picsum.photos/seed/3/600/800",
        videoUrl = "https://cloudfront1.commodity-standards.com/videos/202407__/IMG_8080.MOV"
    ),
    VideoItem(
        url = "https://cloudfront1.commodity-standards.com/videos/202407__/IMG_8103.MOV",
        authorAvatar = "https://randomuser.me/api/portraits/women/4.jpg",
        authorName = "赵六",
        description = "旅行Vlog，带你看世界。",
        isLiked = false,
        isFollowed = false,
        likeCount = 199,
        commentCount = 54,
        shareCount = 13,
        id = "IMG_8103",
        coverUrl = "https://picsum.photos/seed/4/600/800",
        videoUrl = "https://cloudfront1.commodity-standards.com/videos/202407__/IMG_8103.MOV"
    ),
    VideoItem(
        url = "https://cloudfront1.commodity-standards.com/videos/202408__/AFFQ8689.MP4",
        authorAvatar = "https://randomuser.me/api/portraits/men/5.jpg",
        authorName = "孙七",
        description = "健身干货，每天进步一点点。",
        isLiked = true,
        isFollowed = true,
        likeCount = 405,
        commentCount = 129,
        shareCount = 56,
        id = "AFFQ8689",
        coverUrl = "https://picsum.photos/seed/5/600/800",
        videoUrl = "https://cloudfront1.commodity-standards.com/videos/202408__/AFFQ8689.MP4"
    )
)
