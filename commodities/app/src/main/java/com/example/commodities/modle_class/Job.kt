package com.example.commodities.modle_class

import java.io.Serializable

data class Job(
    val id: String = "loading...",
    val title: String= "loading...",
    val company: String= "loading...",
    val location: String= "loading...",
    val description: String= "loading..."
) : Serializable

val jobListInit = listOf(
    Job(
        id = "1",
        title = "Android 开发工程师",
        company = "字节跳动",
        location = "北京",
        description = "负责公司移动端应用的Kotlin开发与维护，参与架构优化与性能提升。"
    ),
    Job(
        id = "2",
        title = "后端工程师（Kotlin）",
        company = "阿里巴巴",
        location = "杭州",
        description = "基于Kotlin和Spring Boot，参与电商平台后端服务开发。"
    ),
    Job(
        id = "3",
        title = "移动端技术专家",
        company = "腾讯",
        location = "深圳",
        description = "主导公司重点项目的移动端技术方案设计及核心模块开发。"
    ),
    Job(
        id = "4",
        title = "Kotlin 全栈开发实习生",
        company = "美团",
        location = "上海",
        description = "协助开发团队完成前后端功能的开发和调试，熟悉Kotlin和现代Web技术。"
    ),
    Job(
        id = "5",
        title = "开源项目维护者",
        company = "JetBrains",
        location = "远程",
        description = "参与Kotlin相关开源项目的开发、文档编写与社区维护。"
    )
)
val myAppliedJobLit = jobListInit