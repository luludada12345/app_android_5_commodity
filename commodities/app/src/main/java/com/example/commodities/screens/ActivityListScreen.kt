package com.example.commodities.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.commodities.components.ActivityListItem
import com.example.commodities.model.ActivityViewModel

@Composable
fun ActivityListScreen(
    navController: NavController,
    actViewModel: ActivityViewModel,
    isMyself: Boolean
) {
    val acts = if (isMyself) actViewModel.acts else actViewModel.acts2

    Column {
        Text(text = if (!isMyself) "显示默认的活动列表" else "显示自己的已经报名的活动列表")
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(acts) { act ->
                ActivityListItem(
                    act,
                    onClick = {
                        actViewModel.selectActivity(act) // 选中职位，写到 ViewModel
                        navController.navigate("activityDetail")
                    }
                )
            }
        }
    }
}