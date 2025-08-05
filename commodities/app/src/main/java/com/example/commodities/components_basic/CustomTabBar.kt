package com.example.commodities.components_basic

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlin.collections.contains

sealed class TabBarScreen(val route: String, val label: String, val icon: ImageVector) {
    object Home : TabBarScreen("videoFeed", "首页", Icons.Default.Home)
    object Activity : TabBarScreen("activityList/{isMyself}", "活动", Icons.Default.Menu)
    object Message : TabBarScreen("chatList", "消息", Icons.Default.Email)

    object Job : TabBarScreen("jobList/{isMyself}", "招聘", Icons.Default.Info)
    object Profile : TabBarScreen("profile", "我的", Icons.Default.Person)

    companion object {
        val items = listOf(Home, Activity, Message, Job, Profile)
    }
}

@Composable
fun CustomTabBar(navController: NavController) {
    println("TabBarScreen.items = ${TabBarScreen.items}")
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val showTabBar = currentRoute in listOf(
        "videoFeed",
        "activityList/{isMyself}",
        "chatList",
        "jobList/{isMyself}",
        "profile"
    )

    if (showTabBar) {
        NavigationBar {
            TabBarScreen.items.forEach { screen ->
                NavigationBarItem(
                    selected = currentRoute == screen.route,
                    onClick = {
                        if (currentRoute != screen.route) {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = true
                                    saveState = true    // 保存页面状态
                                }
                                restoreState = true
                            }
                        }
                    },
                    icon = { Icon(screen.icon, contentDescription = null) },
                    label = { Text(screen.label) },
                    alwaysShowLabel = true
                )
            }
        }
    }
}
