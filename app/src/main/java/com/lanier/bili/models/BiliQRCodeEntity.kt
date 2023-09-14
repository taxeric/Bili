package com.lanier.bili.models

import okhttp3.Headers

/**
 * Author: Turtledove
 * Date  : on 2023/9/14
 * Desc  :
 */
data class BiliQRCodeDataEntity(

    /**
     * 扫码登录密钥
     */
    val qrcode_key: String = "",
    val url: String = ""
)

/**
 * 扫码结果
 */
data class BiliQRCodeResultEntity(

    /**
     * 非0即为异常
     */
    val code: Int = 0,
    val message: String = "",
    val refresh_token: String = "",
    val timestamp: Long = 0,
    val url: String = ""
) {

    var headers: Headers? = null
}
