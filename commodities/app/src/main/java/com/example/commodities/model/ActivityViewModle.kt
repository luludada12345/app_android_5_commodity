package com.example.commodities.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.commodities.modle_class.Activity
import com.example.commodities.modle_class.activityListInit

class ActivityViewModel : ViewModel() {
    // 用 Compose 的 mutableStateOf，使 Compose 页面能自动感知变化
    var currentActivity by mutableStateOf(Activity())
        private set

    fun selectActivity(act: Activity) {
        currentActivity = act
    }

    var acts by mutableStateOf(activityListInit)
        private set

    // 网络获取后调用此方法
    fun updateActs(newActs: List<Activity>) {
        acts = newActs
    }

    var acts2 by mutableStateOf(activityListInit)
        private set

    // 网络获取后调用此方法
    fun updateActs2(newActs: List<Activity>) {
        acts2 = newActs
    }
}
