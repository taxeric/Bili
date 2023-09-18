package com.lanier.bili.apis

import okhttp3.Headers
import okhttp3.Request
import okhttp3.RequestBody

/**
 * Author: Turtledove
 * Date  : on 2023/9/14
 * Desc  :
 */
class BiliRequest {

    companion object {
        private const val UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36"
    }

    private val builder = Request.Builder()
    private val headers = Headers.Builder()

    init {
        headers.add("User-Agent", UA)
    }

    fun url(url: String) = apply {
        builder.url(url)
    }

    fun post(body: RequestBody) = apply {
        builder.post(body)
    }

    fun method(method: String, body: RequestBody?) = apply {
        builder.method(method, body)
    }

    fun addCookie(name: String, value: String) = apply {
        addHeader(name, value)
    }

    fun addHeader(key: String, value: String) = apply {
        headers.add(key, value)
    }

    fun build(): Request {
        return builder.headers(headers.build()).build()
    }
}