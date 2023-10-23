package com.lanier.bili.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object SpUtil {

    private const val FILE_NAME = "Bili_share_data"

    private lateinit var sharedPreferences: SharedPreferences

    private val _innerSPChangeListener = MutableStateFlow("")
    val spChangeKey: StateFlow<String> = _innerSPChangeListener.asStateFlow()

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        sharedPreferences.registerOnSharedPreferenceChangeListener(localDatasetChangedListener)
    }

    fun put(key: String, value: Any) {
        sharedPreferences.edit {
            when (value) {
                is String -> {
                    putString(key, value)
                }
                is Int -> {
                    putInt(key, value)
                }
                is Boolean -> {
                    putBoolean(key, value)
                }
                is Float -> {
                    putFloat(key, value)
                }
                is Long -> {
                    putLong(key, value)
                }
            }
        }
    }

    fun put(key: Array<String>, value: Array<*>) {
        if (key.size != value.size) {
            return
        }
        sharedPreferences.edit {
            key.forEachIndexed { index, k ->
                when (val v = value[index]) {
                    is String -> {
                        putString(k, v)
                    }
                    is Int -> {
                        putInt(k, v)
                    }
                    is Boolean -> {
                        putBoolean(k, v)
                    }
                    is Float -> {
                        putFloat(k, v)
                    }
                    is Long -> {
                        putLong(k, v)
                    }
                }
            }
        }
    }

    fun getString(key: String, def: String = "") = sharedPreferences.getString(key, def) ?: def

    fun getInt(key: String, def: Int = 0) = sharedPreferences.getInt(key, def)

    fun getBoolean(key: String, def: Boolean = false) = sharedPreferences.getBoolean(key, def)

    fun clear() {
        sharedPreferences.edit {
            clear()
        }
    }

    fun <T> saveMap(map: Map<String,T>){
        val editor = sharedPreferences.edit()
        map.forEach { (key, value) ->
            run {
                when (value) {
                    is String -> editor.putString(key, value)
                    is Int -> editor.putInt(key, value)
                    is Boolean -> editor.putBoolean(key, value)
                    is Float -> editor.putFloat(key, value)
                    is Long -> editor.putLong(key, value)
                    else -> {}
                }
                editor.apply()
            }
        }
    }

    private val localDatasetChangedListener =
        SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            _innerSPChangeListener.tryEmit(key)
        }
}