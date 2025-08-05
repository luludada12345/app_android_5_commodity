package com.example.commodities.modle_class

data class UserProfile(
    val avatarUrl: String,
    val nickname: String,
    val followers: Int,
    val following: Int,
    val likes: Int
)
