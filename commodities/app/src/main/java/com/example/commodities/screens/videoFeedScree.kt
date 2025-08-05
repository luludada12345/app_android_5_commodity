package com.example.commodities.screens

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.commodities.componets_video.VideoActionSection
import com.example.commodities.componets_video.VideoInfoSection
import com.example.commodities.componets_video.VideoPlayer
import com.example.commodities.modle_class.VideoItem
import com.example.commodities.modle_class.VideoItemListInit

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoFeedScreen(
    navController: NavController,
    context: Context,
) {
    val videoList: List<VideoItem> = VideoItemListInit

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { videoList.size })
    val currentVideo = videoList.getOrNull(pagerState.currentPage)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        VerticalPager(state = pagerState) { page ->
            val video = videoList[page]
            VideoPlayer(
                context,
                url = video.videoUrl, // 假设你的 VideoItem 有 videoUrl 字段
                modifier = Modifier.fillMaxSize()
            )
        }

        currentVideo?.let { video ->
            VideoInfoSection(
                video = video,
                onFollowClick = { /* 关注逻辑 */ },
                modifier = Modifier.align(Alignment.BottomStart)
            )
            VideoActionSection(
                video = video,
                onLikeClick = { /* 点赞逻辑 */ },
                onCommentClick = { /* 评论逻辑 */ },
                onShareClick = { /* 分享逻辑 */ },
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}