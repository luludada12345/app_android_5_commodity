package com.example.commodities.utils

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

@SuppressLint("MissingPermission")
fun printLocation(context: Context) {
    val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    fusedLocationClient.lastLocation
        .addOnSuccessListener { location: Location? ->
            if (location != null) {
                Log.d(
                    "ProfileScreen",
                    "latitude: ${location.latitude}, longitude: ${location.longitude}"
                )
            } else {
                Log.d("ProfileScreen", "无法获取位置")
            }
        }
        .addOnFailureListener {
            Log.d("ProfileScreen", "获取位置失败: ${it.localizedMessage}")
        }
}