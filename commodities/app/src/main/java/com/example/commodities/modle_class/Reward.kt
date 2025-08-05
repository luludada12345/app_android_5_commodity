package com.example.commodities.modle_class

data class RewardTicket(
    val id: String,                // 记录唯一ID
    val inviterUserId: String,     // 发起拉新用户ID
    val eventTimeClick: String,    // 点击时间
    val eventTimeLogin: String?,   // 登录时间（如有）
    val eventTimeDownload: String?,// 下载时间（如有）
    val rewardClick: Double,       // 点击奖励金额
    val rewardLogin: Double,       // 登录奖励金额
    val rewardDownload: Double,    // 下载奖励金额
    val referredId: String?,       // 被拉新用户ID/唯一标识
    val source: String?            // 来源渠道
)

data class RewardWeekly(
    val id: String,                 // 记录唯一ID
    val advertiserId: String,       // 广告主ID
    val userId: String,             // 用户ID
    val weekStartDate: String,      // 本周开始日期，格式如"2025-07-08"
    val rewardAmount: Double,       // 本周应付佣金
    val isPaid: Boolean,            // 是否已支付
    val paymentProofUrl: String?    // 支付凭证链接（未支付时为null）
)

val rewardTicketInit = listOf(
    // 仅有点击
    RewardTicket(
        id = "1",
        inviterUserId = "user_123",
        eventTimeClick = "2025-07-11T09:15:22Z",
        eventTimeLogin = null,
        eventTimeDownload = null,
        rewardClick = 0.01,
        rewardLogin = 0.0,
        rewardDownload = 0.0,
        referredId = null,
        source = "wechat_share"
    ),
    // 点击并登录
    RewardTicket(
        id = "2",
        inviterUserId = "user_123",
        eventTimeClick = "2025-07-11T09:20:00Z",
        eventTimeLogin = "2025-07-11T09:22:12Z",
        eventTimeDownload = null,
        rewardClick = 0.01,
        rewardLogin = 0.1,
        rewardDownload = 0.0,
        referredId = "user_888",
        source = "wechat_share"
    ),
    // 点击并登录并下载
    RewardTicket(
        id = "3",
        inviterUserId = "user_123",
        eventTimeClick = "2025-07-11T10:05:09Z",
        eventTimeLogin = "2025-07-11T10:06:25Z",
        eventTimeDownload = "2025-07-11T10:08:31Z",
        rewardClick = 0.01,
        rewardLogin = 0.1,
        rewardDownload = 2.0,
        referredId = "user_889",
        source = "wechat_share"
    ),
    // 仅有点击，其他都未发生
    RewardTicket(
        id = "4",
        inviterUserId = "user_234",
        eventTimeClick = "2025-07-11T11:31:55Z",
        eventTimeLogin = null,
        eventTimeDownload = null,
        rewardClick = 0.01,
        rewardLogin = 0.0,
        rewardDownload = 0.0,
        referredId = null,
        source = "sms"
    ),
    // 点击，随后下载（未登录，直接下载的场景）
    RewardTicket(
        id = "5",
        inviterUserId = "user_234",
        eventTimeClick = "2025-07-11T12:08:41Z",
        eventTimeLogin = null,
        eventTimeDownload = "2025-07-11T12:09:00Z",
        rewardClick = 0.01,
        rewardLogin = 0.0,
        rewardDownload = 2.0,
        referredId = "user_990",
        source = "sms"
    )
)

val rewardWeeklyInit = listOf(
    RewardWeekly(
        id = "rw-1",
        advertiserId = "ad_001",
        userId = "user_123",
        weekStartDate = "2025-07-08",
        rewardAmount = 23.45,
        isPaid = false,
        paymentProofUrl = null
    ),
    RewardWeekly(
        id = "rw-2",
        advertiserId = "ad_001",
        userId = "user_124",
        weekStartDate = "2025-07-08",
        rewardAmount = 11.20,
        isPaid = true,
        paymentProofUrl = "https://yourcdn.com/proof/rw-2.jpg"
    ),
    RewardWeekly(
        id = "rw-3",
        advertiserId = "ad_002",
        userId = "user_125",
        weekStartDate = "2025-07-08",
        rewardAmount = 9.80,
        isPaid = true,
        paymentProofUrl = "https://yourcdn.com/proof/rw-3.jpg"
    ),
    RewardWeekly(
        id = "rw-4",
        advertiserId = "ad_001",
        userId = "user_123",
        weekStartDate = "2025-07-15",
        rewardAmount = 18.00,
        isPaid = true,
        paymentProofUrl = "https://yourcdn.com/proof/rw-4.jpg"
    ),
    RewardWeekly(
        id = "rw-5",
        advertiserId = "ad_002",
        userId = "user_125",
        weekStartDate = "2025-07-15",
        rewardAmount = 14.50,
        isPaid = false,
        paymentProofUrl = null
    )
)
