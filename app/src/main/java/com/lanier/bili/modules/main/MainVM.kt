package com.lanier.bili.modules.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lanier.bili.apis.BiliApis
import com.lanier.bili.ext.collect
import com.lanier.bili.models.BiliRecommendVideoItem
import com.lanier.bili.models.BiliUserInfoEntity
import com.lanier.bili.state.login
import com.lanier.bili.state.loginState
import com.lanier.bili.state.unlogin
import com.lanier.bili.utils.CookieHelper
import com.lanier.bili.utils.SpUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Created by 幻弦让叶
 * on 2023/9/27
 */
class MainVM: ViewModel() {
    
    private val _recommendVideos = MutableStateFlow<List<BiliRecommendVideoItem>>(emptyList())
    val recommendVideos: StateFlow<List<BiliRecommendVideoItem>> = _recommendVideos.asStateFlow()

    private val _userCardInfo = MutableStateFlow(BiliUserInfoEntity())
    val userCardInfo: StateFlow<BiliUserInfoEntity> = _userCardInfo.asStateFlow()

    init {
        val biliCookies = SpUtil.getString(CookieHelper.merge)
        val bmid = SpUtil.getString(CookieHelper.DedeUserID)
        BiliApis.bili_cookies = biliCookies
        BiliApis.bmid = bmid

        if (biliCookies.isEmpty()) {
            unlogin()
        } else {
            login()
        }

        viewModelScope.launch {
            collect(SpUtil.spChangeKey) {
                if (it.isNotEmpty()) {
                    if (it == CookieHelper.merge) {
                        if (SpUtil.getString(it).isEmpty()) {
                            getRecommendVideos()
                        }
                    }
                }
            }
        }
    }

    fun getRecommendVideos() {
        viewModelScope.launch { 
            val data = BiliApis.recommendVideoList()
            if (data.code == BiliApis.CODE_SUCCESS) {
                data.data?.let { 
                    _recommendVideos.tryEmit(it.item)
                }?: _recommendVideos.tryEmit(emptyList())
            }
        }
    }

    fun getMineInfo() {
        viewModelScope.launch {
            val data = BiliApis.obtainUserCardInfo()
            if (data.code == BiliApis.CODE_SUCCESS) {
                data.data?.let {
                    _userCardInfo.tryEmit(it)
                }
            }
        }
    }

    fun exitLogin() {
        viewModelScope.launch {
            SpUtil.put(CookieHelper.merge, "")
            unlogin()
        }
    }
}