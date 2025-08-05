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
import com.example.commodities.components.JobListItem
import com.example.commodities.model.JobViewModel
import com.example.commodities.modle_class.Job

@Composable
fun JobListScreen(navController: NavController, jobViewModel: JobViewModel, isMyself: Boolean) {
    val jobs: List<Job> = if (isMyself) jobViewModel.jobs else jobViewModel.jobs2

    Column {
        Text(text = if (!isMyself) "显示默认的招聘列表" else "显示自己的已经投递的职位列表")
        // 其他内容...
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(jobs) { job ->
                JobListItem(
                    job = job,
                    onClick = {
                        jobViewModel.selectJob(job)
                        navController.navigate("jobDetail")
                    },
                    onApplyClick = { /* todo: 实现投递功能 */ },
                    onShareClick = { /* todo: 实现分享功能 */ },
                    onSaveClick = { /* todo: 实现收藏功能 */ }
                )
            }
        }
    }
}
