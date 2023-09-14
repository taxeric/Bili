package com.lanier.bili.apis

import okhttp3.FormBody


/**
 * Author: Turtledove
 * Date  : on 2023/9/14
 * Desc  :
 */
class BiliRequestBody {

    private val builder = FormBody.Builder()

    fun add(key: String, value: String) = apply {
        builder.add(key, value)
    }

    fun build() = builder.build()
}