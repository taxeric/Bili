package com.lanier.bili.models

/**
 * Author: Turtledove
 * Date  : on 2023/9/14
 * Desc  :
 */
data class BiliRecommendVideoEntity(
    val abtest: BiliRecommendVideoAbtest = BiliRecommendVideoAbtest(),
    val item: List<BiliRecommendVideoItem> = listOf(),
    val userfeature: String = ""
)

data class BiliRecommendVideoAbtest(
    val group: String = ""
)

data class BiliRecommendVideoItem(
    val avfeature: String = "",
    val bvid: String = "",
    val cid: Int = 0,
    val duration: Int = 0,
    val goto: String = "",
    val id: Int = 0,
    val isfollowed: Int = 0,
    val owner: BiliRecommendVideoOwner = BiliRecommendVideoOwner(),
    val pic: String = "",
    val pubdate: Int = 0,
    val rcmdreason: BiliRecommendVideoRcmdreason = BiliRecommendVideoRcmdreason(),
    val showinfo: Int = 0,
    val stat: BiliRecommendVideoStat = BiliRecommendVideoStat(),
    val title: String = "",
    val trackid: String = "",
    val uri: String = ""
)

data class BiliRecommendVideoOwner(
    val face: String = "",
    val mid: Int = 0,
    val name: String = ""
)

data class BiliRecommendVideoRcmdreason(
    val content: String = "",
    val reasontype: Int = 0
)

data class BiliRecommendVideoStat(
    val danmaku: Int = 0,
    val like: Int = 0,
    val view: Int = 0
)