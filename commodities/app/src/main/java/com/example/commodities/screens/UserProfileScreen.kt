package com.example.commodities.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.commodities.components_basic.ProfileButtonListB
import com.example.commodities.components_basic.ProfileButtonListA
import com.example.commodities.components_basic.ProfileHeader
import com.example.commodities.components_basic.ProfileTabs
import com.example.commodities.componets_video.VideoGrid
import com.example.commodities.componets_video.VideoGridEmptyState
import com.example.commodities.model.UserProfileViewModel
import com.example.commodities.modle_class.UserProfile
import com.example.commodities.modle_class.VideoItem
import com.example.commodities.modle_class.VideoItemListInit
import com.example.commodities.store.LocalThemeSwitcher

@Composable
fun UserProfileScreen(
    navController: NavController,
    context: Context,
    userProfileViewModel: UserProfileViewModel,
    onShowModalBottomSheet: () -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val gridState = rememberLazyGridState()

    val userProfile: UserProfile = userProfileViewModel.userProfile
    val videos: List<VideoItem> = VideoItemListInit
    val onVideoClick: (VideoItem) -> Unit = {}
    val themeSwitcher = LocalThemeSwitcher.current
    val onRefresh: () -> Unit = {}
    val isRefreshing: Boolean = false

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 32.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 顶部区域
        ProfileHeader(userProfile, onSettings = {})
        Spacer(Modifier.height(12.dp))
        ProfileButtonListB(
            onEdit = { navController.navigate("profileEdit") },
            onChangeTheme = { themeSwitcher.toggle() },
            onShare = {},
        )
        Spacer(Modifier.height(12.dp))
        ProfileButtonListA(
            onShowModalBottomSheet,
            goVideoUpload = { navController.navigate("videoUpload") },
            goVideoSearch = { navController.navigate("videoSearch") },
        )
        // Tab区域
        ProfileTabs(selectedTab, onTabChange = { selectedTab = it })

        // 视频网格
        if (selectedTab == 0) {
            VideoGrid(
                videos = videos,
                onVideoClick = onVideoClick,
                gridState = gridState,
                loadMore = {},
                modifier = Modifier.weight(1f) // 重点，必须
            )
        } else {
            // 喜欢页/空态
            VideoGridEmptyState("还没有喜欢的视频")
        }
    }
}
