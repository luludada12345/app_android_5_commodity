package com.example.commodities.store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.Preferences

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_prefs").also {
    println("DataStore Extension Loaded!") // 仅用于调试
}