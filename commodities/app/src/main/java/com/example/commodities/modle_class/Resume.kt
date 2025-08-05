package com.example.commodities.modle_class

import android.net.Uri
import androidx.core.net.toUri

data class Resume(
    var name: String = "",
    var email: String = "",
    var phone: String = "",
    var bio: String = "",
    var education: String = "",
    var workExp: String = "",
    var avatarUri: Uri? = null,
    var pdfUri: Uri? = null   // 新增 PDF 字段
)

val resumeInit = Resume(
    name = "水雷",
    email = "lilei@example.com",
    phone = "13800138000",
    bio = "热爱编程，熟悉Kotlin与Android开发，有丰富的项目经验。",
    education = "清华大学 计算机科学与技术 本科 2015-2019",
    workExp = "2019-2022：字节跳动 Android开发工程师\n2022-至今：腾讯 高级开发工程师",
    avatarUri = "https://i.pravatar.cc/150?img=3".toUri(),
    pdfUri = "https://www.example.com/resume/lilei_resume.pdf".toUri()
)