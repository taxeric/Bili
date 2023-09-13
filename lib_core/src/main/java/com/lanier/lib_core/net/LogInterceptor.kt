package com.lanier.lib_core.net

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import java.nio.charset.Charset

/**
 * Author: Turtledove
 * Date  : on 2023/9/13
 * Desc  :
 */
class LogInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
        val response = chain.proceed(chain.request())
        val mediaType = response.body?.contentType()
        val content = response.body?.string()
        println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
        println(">>>> 请求协议: ${if (req.isHttps) "https" else "http"}")
        if (req.headers.size > 0) {
            req.headers.forEach { header ->
                println(">>>> 请 求 头: $header")
            }
        }
        println(">>>> 请求路径: ${req.url}")
        println(">>>> 请求方法: ${req.method}")
        try {
            req.body?.let {
                val buffer = Buffer()
                it.writeTo(buffer)
                var charset: Charset? = Charset.forName("UTF-8")
                val contentType = req.body?.contentType()
                if (contentType != null) {
                    charset = contentType.charset(charset)
                }
                println(">>>> 请求参数: ${buffer.readString(charset!!)}")
            }
            println(">>>> 请求响应: ${response.code}")
            println(">>>> 响应结果: $content")
        } catch (e: Exception) {
            println(">>>> 响应异常: ${e.message}")
        }
        println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
        return response
            .newBuilder()
            .body(content?.toResponseBody(mediaType))
            .build()
    }
}