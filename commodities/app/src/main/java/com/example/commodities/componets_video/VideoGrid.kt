package com.example.commodities.componets_video

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.commodities.modle_class.VideoItem
import androidx.compose.foundation.ExperimentalFoundationApi

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoGrid(
    videos: List<VideoItem>,
    onVideoClick: (VideoItem) -> Unit,
    gridState: LazyGridState,
    loadMore: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        state = gridState,
        modifier = modifier
    ) {
        items(videos.size) { idx ->
            val video = videos[idx]
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .aspectRatio(0.7f) // 封面比例
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { onVideoClick(video) }
            ) {
                AsyncImage(
                    model = video.coverUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            // 上拉触底自动加载
            if (idx == videos.lastIndex) {
                LaunchedEffect(Unit) { loadMore() }
            }
        }
    }
}
