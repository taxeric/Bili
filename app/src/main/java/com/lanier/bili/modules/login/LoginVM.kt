package com.lanier.bili.modules.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lanier.bili.apis.BiliApis
import com.lanier.bili.utils.CookieHelper
import com.lanier.bili.utils.SpUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.Headers

/**
 * Created by 幻弦让叶
 * on 2023/9/27
 */
class LoginVM: ViewModel() {
    
    private val _qrUrl = MutableStateFlow("")
    val qrUrl: StateFlow<String> = _qrUrl.asStateFlow()
    
    private var qrKey = ""
    private var headers: Headers? = null
    
    fun requestQRCode() {
        viewModelScope.launch { 
            val data = BiliApis.requestWebQRCode()
            if (data.code == BiliApis.CODE_SUCCESS) {
                data.data?.let {
                    qrKey = it.qrcode_key
                    _qrUrl.tryEmit(it.url)
                }
            }
        }
    }
    
    fun scanCompleted(
        success: () -> Unit,
        err: (String) -> Unit
    ) {
        if (qrKey.isEmpty()) {
            err.invoke("qr key is null")
            return
        }
        viewModelScope.launch { 
            val data = BiliApis.scanQRCodeForLogin(qrKey)
            if (data.code == BiliApis.CODE_SUCCESS) {
                data.data?.let {
                    if (it.code == BiliApis.CODE_SUCCESS) {
                        headers = it.headers
                        success.invoke()
                    } else {
                        err.invoke(it.message)
                    }
                }
            }
        }
    }

    fun saveCookies(
        applied: () -> Unit
    ) {
        CookieHelper.obtainCookies(
            headers = headers,
            onCompleted = { keys, values, merge ->
                SpUtil.put(keys, values)
                SpUtil.put(CookieHelper.merge, merge)
                applied.invoke()
            }
        )
    }
}