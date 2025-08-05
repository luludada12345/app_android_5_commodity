package com.example.commodities.ui.theme

import android.content.Context
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Typography
import androidx.compose.material3.Shapes
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.collectAsState
import androidx.datastore.preferences.core.edit

import com.example.commodities.store.LocalThemeSwitcher
import com.example.commodities.store.ThemeSwitcher
import com.example.commodities.store.dataStore
import com.example.commodities.store.IS_DARK_THEME
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

// 可根据需要定义自定义的颜色方案
private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun AppTheme(
    context: Context,
    content: @Composable () -> Unit
) {
    val dataStore = context.dataStore
    val isDarkThemeFlow = remember(context) {
        context.dataStore.data
            .map { prefs -> prefs[IS_DARK_THEME] ?: false }
            .distinctUntilChanged()
    }
    val isDarkTheme = isDarkThemeFlow.collectAsState(false)

    val coroutineScope = rememberCoroutineScope()

    val themeSwitcher = remember(isDarkTheme.value) {
        ThemeSwitcher(
            useDarkTheme = isDarkTheme.value,
            toggle = {
                coroutineScope.launch {
                    dataStore.edit { prefs ->
                        prefs[IS_DARK_THEME] = !isDarkTheme.value
                    }
                }
            }
        )
    }

    // 保证 themeSwitcher 每次主题变化后都能更新（防止只构造一次）
    val currentSwitcher = themeSwitcher.copy(useDarkTheme = isDarkTheme.value)

    CompositionLocalProvider(LocalThemeSwitcher provides currentSwitcher) {
        MaterialTheme(
            colorScheme = if (currentSwitcher.useDarkTheme) DarkColors else LightColors,
            typography = Typography(),
            shapes = Shapes(),
            content = content
        )
    }
}