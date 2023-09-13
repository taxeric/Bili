package com.lanier.lib_core.net

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Author: Turtledove
 * Date  : on 2023/9/13
 * Desc  :
 */
object Serve {

    private lateinit var client: OkHttpClient

    fun init(
        logInterceptor: LogInterceptor = LogInterceptor()
    ) {
        client = OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .build()
    }

    suspend fun sendRequest(request: Request): Response {
        val response = withContext(Dispatchers.Default) {
            client.newCall(request)
                .execute()
        }
        return response
    }
}