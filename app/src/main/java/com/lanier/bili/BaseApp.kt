package com.lanier.bili

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.lanier.bili.utils.SpUtils
import com.lanier.lib_core.net.Serve

/**
 * Author: Turtledove
 * Date  : on 2023/9/13
 * Desc  :
 */
class BaseApp: Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        SpUtils.init(this)
        val k = SpUtils.getValue("", 0)
        k
        Serve.init()
    }
}