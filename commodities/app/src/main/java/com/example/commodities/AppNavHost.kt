package com.example.commodities

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.commodities.components_basic.CustomModalBottomSheet
import com.example.commodities.components_basic.CustomTabBar
import com.example.commodities.model.ActivityViewModel
import com.example.commodities.model.JobViewModel
import com.example.commodities.model.UserProfileViewModel
import com.example.commodities.screens.*
import com.example.commodities.screens_static.*
import com.example.commodities.store.LocalThemeSwitcher
import com.example.commodities.ui.theme.AppTheme

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    var showModalBottomSheet by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val language = prefs.getString("language", null)
    val loggedIn = prefs.getBoolean("loggedIn", false)

    //  防止重建
    val startDestination by remember {
        mutableStateOf(
            when {
                language == null -> "language"
                !loggedIn -> "login"
                else -> "videoFeed"
            }
        )
    }

    AppTheme(context) {
        val themeSwitcher = LocalThemeSwitcher.current
        //    if (currentRoute == "videoFeed") {
        //        themeSwitcher.toggle()
        //    }
        Box(Modifier.fillMaxSize()) {
            Scaffold(bottomBar = { CustomTabBar(navController) }) { paddingValues ->
                // 动态处理 padding
                val finalPadding = if (currentRoute == "videoFeed") {
                    // 只保留 bottom（底部）安全区
                    PaddingValues(
                        start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                        top = 0.dp,
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = paddingValues.calculateBottomPadding()
                    )
                } else {
                    paddingValues // 原样保留
                }

                NavHost(
                    navController = navController,
                    startDestination = startDestination,
                    modifier = Modifier.padding(finalPadding)
                ) {
                    composable("language") { LanguageScreen(navController, context) }
                    composable("login") { LoginScreen(navController, context) }

                    composable("videoFeed") { VideoFeedScreen(navController, context) }
                    composable("activityList/{isMyself}") { backStackEntry ->
                        val isMyself = backStackEntry.arguments?.getString("isMyself") == "true"
                        val actViewModel: ActivityViewModel = viewModel()
                        ActivityListScreen(
                            navController, actViewModel, isMyself
                        )
                    }
                    composable("chatList") { ChatListScreen(navController) }
                    composable("jobList/{isMyself}") { backStackEntry ->
                        val isMyself = backStackEntry.arguments?.getString("isMyself") == "true"
                        val jobViewModel: JobViewModel = viewModel()
                        JobListScreen(navController, jobViewModel, isMyself)
                    }
                    composable("profile") {
                        val userProfileViewModel: UserProfileViewModel = viewModel()
                        UserProfileScreen(
                            navController,
                            context,
                            userProfileViewModel,
                            onShowModalBottomSheet = { showModalBottomSheet = true })
                    }
                    composable("profileEdit") {
                        val userProfileViewModel: UserProfileViewModel = viewModel()
                        UserProfileEditScreen(
                            navController,
                            userProfileViewModel,
                        )
                    }

                    composable("videoUpload") { VideoUploadScreen() }
                    composable("videoSearch") { PreviewVideoSearchScreen() }
                    composable("activityDetail") {
                        val actViewModel: ActivityViewModel = viewModel()
                        ActivityDetailScreen(actViewModel)
                    }
                    composable("chatDetail") { ChatMessageScreen(navController) }
                    composable("jobDetail") {
                        val jobViewModel: JobViewModel = viewModel()
                        JobDetailScreen(jobViewModel)
                    }
                    composable("jobUploadResume") { JobUploadResumeScreen(navController) }

                    composable("rewardList") { RewardListScreen(navController, context) }
                    composable("rewardUploadPaymentProof") { RewardUploadPaymentProof(navController) }
                    composable("protocol/{protocolType}") { backStackEntry ->
                        val protocolType =
                            backStackEntry.arguments?.getString("protocolType") ?: "privacy"
                        ProtocolScreen(
                            navController,
                            protocolType,
                            context,
                        )
                    }
                    composable("qrcode") {
                        QrCodeScreen(
                            navController,
                            context,
                        )
                    }
                }
            }

            CustomModalBottomSheet(
                navController,
                context,
                show = showModalBottomSheet,
                onDismiss = { showModalBottomSheet = false },
                onOptionClick = {
                    showModalBottomSheet = false
                })
        }
    }
}