package com.example.commodities.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.commodities.modle_class.Job
import com.example.commodities.modle_class.jobListInit

class JobViewModel : ViewModel() {
    // 用 Compose 的 mutableStateOf，使 Compose 页面能自动感知变化
    var currentJob by mutableStateOf(Job())
        private set

    fun selectJob(job: Job) {
        currentJob = job
    }

    var jobs by mutableStateOf(jobListInit)
        private set

    // 网络获取后调用此方法
    fun updateJobs(newJobs: List<Job>) {
        jobs = newJobs
    }

    var jobs2 by mutableStateOf(jobListInit)
        private set

    // 网络获取后调用此方法
    fun updateJobs2(newJobs: List<Job>) {
        jobs2 = newJobs
    }
}
