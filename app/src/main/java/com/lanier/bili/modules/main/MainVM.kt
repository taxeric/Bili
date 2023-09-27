package com.lanier.bili.modules.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lanier.bili.apis.BiliApis
import com.lanier.bili.models.BiliRecommendVideoItem
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
}