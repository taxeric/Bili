package com.lanier.bili.net

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.lanier.bili.BaseApp
import com.lanier.lib_core.net.Serve
import okhttp3.Request
import okhttp3.Response

/**
 * Author: Turtledove
 * Date  : on 2023/9/13
 * Desc  :
 */
object ServeHelper {

    val mapper = jacksonObjectMapper()

    inline fun <reified T> fromJson(json: String): T {
        return mapper.readValue(json)
    }

    suspend inline fun <reified T> sendRequest(
        req: Request
    ): T? {
        val response = request(req)
        val json = response.body?.string()
        if (!json.isNullOrEmpty()) {
            return fromJson(json)
        }
        return null
    }

    suspend fun request(req: Request): Response {
        return Serve.sendRequest(req)
    }
}