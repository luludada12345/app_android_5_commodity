package com.example.commodities.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.commodities.modle_class.UserProfile

class UserProfileViewModel : ViewModel() {
    var userProfile by mutableStateOf(
        UserProfile(
            avatarUrl = "https://randomuser.me/api/portraits/men/32.jpg",
            nickname = "JamesZu2",
            followers = 1,
            following = 2,
            likes = 0
        )
    )
        private set

    fun updateUserProfile(newProfile: UserProfile) {
        userProfile = newProfile
    }
}
