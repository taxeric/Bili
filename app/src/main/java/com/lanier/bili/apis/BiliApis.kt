package com.lanier.bili.apis

import com.lanier.bili.models.*
import com.lanier.bili.net.ServeHelper
import okhttp3.FormBody
import okhttp3.Request

/**
 * Author: Turtledove
 * Date  : on 2023/9/14
 * Desc  :
 */
object BiliApis {

    /**
     * 获取盐值&密钥
     */
    @Deprecated("使用密码登录时使用该方法")
    suspend fun getSaltAndKey(): BiliBaseResponse<SaltKeyDataEntity> {
        val req = BiliRequest()
            .url("https://passport.bilibili.com/x/passport-login/web/key")
            .build()
        val data = ServeHelper.sendRequest<BiliBaseResponse<SaltKeyDataEntity>>(req)
        if (data != null) {
            return data
        }
        return BiliBaseResponse.default()
    }

    /**
     * 申请网页二维码
     */
    suspend fun requestWebQRCode(): BiliBaseResponse<BiliQRCodeDataEntity> {
        val req = BiliRequest()
            .url("https://passport.bilibili.com/x/passport-login/web/qrcode/generate")
            .build()
        val data = ServeHelper.sendRequest<BiliBaseResponse<BiliQRCodeDataEntity>>(req)
        if (data != null) {
            return data
        }
        return BiliBaseResponse.default()
    }

    /**
     * 扫码登录
     */
    suspend fun scanQRCodeForLogin(
        qrcode_key: String
    ): BiliBaseResponse<BiliQRCodeResultEntity> {
        val body = FormBody.Builder()
            .add("qrcode_key", qrcode_key)
            .build()
        val req = BiliRequest()
            .url("https://passport.bilibili.com/x/passport-login/web/qrcode/poll")
            .post(body)
            .build()
        val response = ServeHelper.request(req)
        val headers = response.headers
        val dataStr = response.body?.string()
        if (dataStr != null) {
            val data = try {
                ServeHelper.fromJson<BiliBaseResponse<BiliQRCodeResultEntity>>(dataStr)
            } catch (e: Exception) {
                null
            }
            if (data != null) {
                data.data?.headers = headers
                return data
            }
            return BiliBaseResponse.default()
        }
        return BiliBaseResponse.default()
    }

    /**
     * 首页推荐列表
     *
     * @param SESSDATA 从登录的响应头获取
     */
    suspend fun recommendVideoList(
        SESSDATA: String,
        fresh_type: Int = 3,
        version: Int = 1,
        ps: Int = 10,
        fresh_idx: Int = 1,
        fresh_idx_1h: Int = 1
    ): BiliBaseResponse<BiliRecommendVideoEntity> {
        if (SESSDATA.isEmpty()) {
            return BiliBaseResponse.default()
        }
        val req = BiliRequest()
            .url("https://api.bilibili.com/x/web-interface/index/top/rcmd?fresh_type=$fresh_type&version=$version&ps=$ps&fresh_idx=$fresh_idx&fresh_idx_1h=$fresh_idx_1h")
            .addHeader("Cookie", SESSDATA)
            .build()
        val data = ServeHelper.sendRequest<BiliBaseResponse<BiliRecommendVideoEntity>>(req)
        if (data != null) {
            return data
        }
        return BiliBaseResponse.default()
    }
}