package com.example.commodities.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.commodities.componets_video.VideoGrid
import com.example.commodities.modle_class.VideoItem
import kotlinx.coroutines.launch

@Composable
fun VideoSearchScreen(
    allSuggestions: List<String>,
    onSearch: suspend (String) -> List<VideoItem>,
    onVideoClick: (VideoItem) -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var videos by remember { mutableStateOf<List<VideoItem>>(emptyList()) }
    var hasMore by remember { mutableStateOf(false) }
    var suggestions by remember { mutableStateOf<List<String>>(emptyList()) }
    var showSuggestions by remember { mutableStateOf(false) }
    val gridState = rememberLazyGridState()
    val coroutineScope = rememberCoroutineScope()
    var currentPage by remember { mutableIntStateOf(1) }
    val pageSize = 30
    var totalResult by remember { mutableStateOf<List<VideoItem>>(emptyList()) } // 模拟后端分页

    // 搜索建议
    LaunchedEffect(query) {
        if (query.isBlank()) {
            showSuggestions = false
        } else {
            suggestions = allSuggestions.filter { it.contains(query, ignoreCase = true) }.take(6)
            showSuggestions = suggestions.isNotEmpty()
        }
    }

    // 搜索&分页
    fun triggerSearch() {
        coroutineScope.launch {
            isLoading = true
            showSuggestions = false
            currentPage = 1
            videos = emptyList()
            val all = onSearch(query)
            totalResult = all
            val pageData = all.take(pageSize)
            videos = pageData
            hasMore = all.size > pageSize
            isLoading = false
        }
    }

    fun loadMore() {
        if (isLoading || !hasMore) return
        coroutineScope.launch {
            isLoading = true
            currentPage += 1
            val from = (currentPage - 1) * pageSize
            val to = minOf(from + pageSize, totalResult.size)
            if (from < to) {
                videos = videos + totalResult.subList(from, to)
                hasMore = to < totalResult.size
            } else {
                hasMore = false
            }
            isLoading = false
        }
    }

    Column(modifier.fillMaxSize()) {
        // 搜索框
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            TextField(
                value = query,
                onValueChange = {
                    query = it
                    // 清空旧内容但不主动触发搜索
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                placeholder = { Text("搜索视频") },
                singleLine = true,
                trailingIcon = {
                    if (query.isNotBlank()) {
                        IconButton(onClick = {
                            query = ""
                            videos = emptyList()
                            showSuggestions = false
                        }) {
                            Icon(Icons.Default.Clear, contentDescription = "清除")
                        }
                    }
                },
                shape = RoundedCornerShape(20.dp),
            )
            // 搜索建议弹层
            DropdownMenu(
                expanded = showSuggestions,
                onDismissRequest = { showSuggestions = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                suggestions.forEach { suggestion ->
                    DropdownMenuItem(
                        text = { Text(suggestion) },
                        onClick = {
                            query = suggestion
                            showSuggestions = false
                            triggerSearch()
                        }
                    )
                }
            }
        }

        // 搜索按钮
        Button(
            onClick = { triggerSearch() },
            enabled = query.isNotBlank() && !isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .height(44.dp)
        ) {
            Text("搜索")
        }

        // 加载中
        if (isLoading && videos.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        // 空结果
        else if (videos.isEmpty() && query.isNotBlank() && !isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("没有找到相关视频")
            }
        }
        // 结果展示
        else {
            VideoGrid(
                videos = videos,
                onVideoClick = onVideoClick,
                gridState = gridState,
                loadMore = ::loadMore,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// 假数据演示
@Composable
fun PreviewVideoSearchScreen() {
    val fakeVideos = (1..150).map {
        VideoItem(
            id = "$it",
            coverUrl = "https://picsum.photos/seed/$it/400/600",
            authorAvatar = "https://randomuser.me/api/portraits/men/${it % 99}.jpg",
            authorName = "作者$it",
            description = "视频$it 描述",
            likeCount = it * 7,
            commentCount = it * 3,
            shareCount = it * 2,
            isLiked = false,
            isFollowed = false,
            url = "",
            videoUrl = ""
        )
    }
    val fakeSuggestions =
        listOf("搞笑", "健身", "编程", "英语学习", "旅行", "猫咪", "美食", "科技", "开箱", "生活")

    VideoSearchScreen(
        allSuggestions = fakeSuggestions,
        onSearch = { query -> fakeVideos.filter { it.description.contains(query) } },
        onVideoClick = {},
        modifier = Modifier
    )
}
