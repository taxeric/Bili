package com.lanier.bili.utils

import android.content.Context
import android.content.SharedPreferences

object SpUtils {

    private const val FILE_NAME = "Bili_share_data"

    lateinit var mSharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun init(context: Context) {
        mSharedPreferences =
            context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        editor = mSharedPreferences.edit()
    }

    fun getValue(key: String, value: Any) : Any {
        when (value) {
            is String -> return mSharedPreferences.getString(key, value) ?: ""
            is Int -> return mSharedPreferences.getInt(key, value)
            is Boolean -> return mSharedPreferences.getBoolean(key, value)
            is Float -> return mSharedPreferences.getFloat(key, value)
            is Long -> return mSharedPreferences.getLong(key, value)
        }
        return ""
    }

    fun <T> saveMap(map: Map<String,T>){
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
}