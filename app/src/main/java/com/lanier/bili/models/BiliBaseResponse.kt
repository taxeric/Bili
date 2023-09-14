package com.lanier.bili.models

/**
 * Author: Turtledove
 * Date  : on 2023/9/14
 * Desc  :
 */
class BiliBaseResponse<T> {

    companion object {

        fun <T> default() = BiliBaseResponse<T>().apply { default = true }
    }

    var code: Int = 0
    var `data`: T? = null
    var message: String = ""
    var ttl: Int = 0
    var default = false
}