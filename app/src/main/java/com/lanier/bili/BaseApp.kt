package com.lanier.bili

import android.app.Application
import com.lanier.bili.utils.SpUtil
import com.lanier.lib_core.net.Serve

/**
 * Author: Turtledove
 * Date  : on 2023/9/13
 * Desc  :
 */
class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        SpUtil.init(this)
        Serve.init()
    }
}