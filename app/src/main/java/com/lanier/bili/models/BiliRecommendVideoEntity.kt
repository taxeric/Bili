package com.lanier.bili.models

/**
 * Author: Turtledove
 * Date  : on 2023/9/14
 * Desc  :
 */
data class BiliRecommendVideoEntity(
    val business_card: Any? = Any(),
    val floor_info: Any? = Any(),
    val abtest: BiliRecommendVideoAbTest? = BiliRecommendVideoAbTest(),
    val item: List<BiliRecommendVideoItem> = listOf(),
    val mid: Long = 0L,
    val preload_expose_pct: Double = 0.0,
    val preload_floor_expose_pct: Double = 0.0,
    val side_bar_column: List<BiliRecommendVideoSideBarColumn>? = listOf(),
    val user_feature: Any? = Any()
)

data class BiliRecommendVideoAbTest(
    val group: String = "",
)

data class BiliRecommendVideoItem(
    val av_feature: Any? = Any(),
    val business_info: BiliRecommendVideoBusinessInfo? = BiliRecommendVideoBusinessInfo(),
    val bvid: String = "",
    val cid: Long = 0L,
    val duration: Int = 0,
    val enable_vt: Int = 0,
    val goto: String = "",
    val id: Long = 0L,
    val is_followed: Int = 0,
    val is_stock: Int = 0,
    val ogv_info: Any? = Any(),
    val owner: BiliRecommendVideoOwner = BiliRecommendVideoOwner(),
    val pic: String = "",
    val pic_4_3: String = "",
    val pos: Int = 0,
    val pubdate: Int = 0,
    val rcmd_reason: BiliRecommendVideoRcmdReason? = BiliRecommendVideoRcmdReason(),
    val room_info: Any? = Any(),
    val show_info: Int = 0,
    val stat: BiliRecommendVideoStat = BiliRecommendVideoStat(),
    val title: String = "",
    val track_id: String = "",
    val uri: String = "",
    val vt_display: String = ""
)

data class BiliRecommendVideoSideBarColumn(
    val av_feature: Any? = Any(),
    val card_type: String = "",
    val card_type_en: String = "",
    val comic: Any? = Any(),
    val cover: String = "",
    val duration: Int = 0,
    val enable_vt: Int = 0,
    val goto: String = "",
    val horizontal_cover_16_10: String = "",
    val horizontal_cover_16_9: String = "",
    val id: Long = 0L,
    val is_finish: Int = 0,
    val is_play: Int = 0,
    val is_rec: Int = 0,
    val is_started: Int = 0,
    val new_ep: BiliRecommendVideoNewEp = BiliRecommendVideoNewEp(),
    val pos: Int = 0,
    val producer: List<BiliRecommendVideoProducer> = listOf(),
    val room_info: Any? = Any(),
    val source: String = "",
    val stats: BiliRecommendVideoStats = BiliRecommendVideoStats(),
    val styles: List<String> = listOf(),
    val sub_title: String = "",
    val title: String = "",
    val track_id: String = "",
    val url: String = "",
    val vt_display: String = ""
)

data class BiliRecommendVideoBusinessInfo(
    val activity_type: Int = 0,
    val ad_cb: String = "",
    val ad_desc: String = "",
    val adver_name: String = "",
    val agency: String = "",
    val area: Int = 0,
    val asg_id: Int = 0,
    val business_mark: BiliRecommendVideoBusinessMark = BiliRecommendVideoBusinessMark(),
    val card_type: Int = 0,
    val cm_mark: Int = 0,
    val contract_id: String = "",
    val creative_id: Long = 0L,
    val creative_type: Int = 0,
    val epid: Int = 0,
    val id: Long = 0L,
    val `inline`: BiliRecommendVideoInline = BiliRecommendVideoInline(),
    val intro: String = "",
    val is_ad: Boolean = false,
    val is_ad_loc: Boolean = false,
    val label: String = "",
    val litpic: String = "",
    val mid: String = "",
    val name: String = "",
    val null_frame: Boolean = false,
    val operater: String = "",
    val pic: String = "",
    val pic_main_color: String = "",
    val pos_num: Int = 0,
    val request_id: String = "",
    val res_id: Int = 0,
    val server_type: Int = 0,
    val src_id: Int = 0,
    val stime: Int = 0,
    val style: Int = 0,
    val sub_title: String = "",
    val title: String = "",
    val url: String = ""
)

data class BiliRecommendVideoOwner(
    val face: String = "",
    val mid: Long = 0L,
    val name: String = ""
)

data class BiliRecommendVideoRcmdReason(
    val content: String = "",
    val reason_type: Int = 0
)

data class BiliRecommendVideoStat(
    val danmaku: Int = 0,
    val like: Int = 0,
    val view: Int = 0,
    val vt: Int = 0
)

data class BiliRecommendVideoBusinessMark(
    val bg_border_color: String = "",
    val bg_color: String = "",
    val bg_color_night: String = "",
    val border_color: String = "",
    val border_color_night: String = "",
    val img_height: Int = 0,
    val img_url: String = "",
    val img_width: Int = 0,
    val text: String = "",
    val text_color: String = "",
    val text_color_night: String = "",
    val type: Int = 0
)

data class BiliRecommendVideoInline(
    val inline_barrage_switch: Int = 0,
    val inline_type: Int = 0,
    val inline_url: String = "",
    val inline_use_same: Int = 0
)

data class BiliRecommendVideoNewEp(
    val cover: String = "",
    val day_of_week: Int = 0,
    val duration: Int = 0,
    val id: Long = 0L,
    val index_show: String = "",
    val long_title: String = "",
    val pub_time: String = "",
    val title: String = ""
)

data class BiliRecommendVideoProducer(
    val is_contribute: Int = 0,
    val mid: Long = 0L,
    val name: String = "",
    val type: Int = 0
)

data class BiliRecommendVideoStats(
    val coin: Int = 0,
    val danmaku: Int = 0,
    val favorite: Int = 0,
    val follow: Int = 0,
    val likes: Int = 0,
    val reply: Int = 0,
    val series_follow: Int = 0,
    val series_view: Int = 0,
    val view: Int = 0
)