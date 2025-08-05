package com.example.commodities.modle_class

import java.io.Serializable

data class Activity(
    val id: String = "loading...",
    val title: String = "loading...",
    val date: String = "loading...",
    val location: String = "loading...",
    val description: String = "loading..."
) : Serializable

val activityListInit = listOf(
    Activity(
        id = "1",
        title = "Kotlin 开发者大会",
        date = "2025-08-10",
        location = "上海世博中心",
        description = "汇聚国内外Kotlin开发者，分享最新的开发趋势与实战经验。"
    ),
    Activity(
        id = "2",
        title = "技术沙龙：Compose UI 进阶",
        date = "2025-08-20",
        location = "北京中关村创业大街",
        description = "深入浅出讲解Compose UI在企业级项目中的最佳实践。"
    ),
    Activity(
        id = "3",
        title = "移动应用黑客松",
        date = "2025-09-05",
        location = "深圳腾讯滨海大厦",
        description = "36小时不停歇，组队开发创新移动App，丰厚奖品等你拿！"
    ),
    Activity(
        id = "4",
        title = "AI 未来趋势论坛",
        date = "2025-09-15",
        location = "杭州阿里巴巴西溪园区",
        description = "邀请行业专家探讨人工智能的未来发展与落地场景。"
    ),
    Activity(
        id = "5",
        title = "开源项目协作日",
        date = "2025-10-01",
        location = "广州天河智慧城",
        description = "携手开源爱好者，共同参与和维护Kotlin相关开源项目。"
    )
)

val myAttendActivity = activityListInit