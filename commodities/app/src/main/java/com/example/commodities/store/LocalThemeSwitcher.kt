package com.example.commodities.store

import androidx.compose.runtime.staticCompositionLocalOf

// 这里其实是各种全局状态  要到什么创建什么
// 不仅是主题，还有很多要用到全局状态的
data class ThemeSwitcher(
    var useDarkTheme: Boolean,
    val toggle: () -> Unit
)

val LocalThemeSwitcher = staticCompositionLocalOf<ThemeSwitcher> {
    error("No ThemeSwitcher provided")
}
