package com.lanier.bili.models

/**
 * Created by 幻弦让叶
 * on 2023/10/1
 */
data class BiliUserInfoEntity(
    val archive_count: Int = 0,
    val article_count: Int = 0,
    val card: BiliUserCard = BiliUserCard(),
    val follower: Int = 0,
    val following: Boolean = false,
    val like_num: Int = 0,
    val space: BiliUserSpace = BiliUserSpace()
)

data class BiliUserCard(
    val DisplayRank: String = "",
    val Official: BiliUserOfficial = BiliUserOfficial(),
    val approve: Boolean = false,
    val article: Int = 0,
    val attention: Int = 0,
    val attentions: List<Any> = listOf(),
    val birthday: String = "",
    val description: String = "",
    val face: String = "",
    val face_nft: Int = 0,
    val face_nft_type: Int = 0,
    val fans: Int = 0,
    val friend: Int = 0,
    val is_senior_member: Int = 0,
    val level_info: BiliUserLevelInfo = BiliUserLevelInfo(),
    val mid: String = "",
    val name: String = "",
    val nameplate: BiliUserNameplate = BiliUserNameplate(),
    val official_verify: BiliUserOfficialVerify = BiliUserOfficialVerify(),
    val pendant: BiliUserPendant = BiliUserPendant(),
    val place: String = "",
    val rank: String = "",
    val regtime: Int = 0,
    val sex: String = "",
    val sign: String = "",
    val spacesta: Int = 0,
    val vip: BiliUserVip = BiliUserVip()
)

data class BiliUserSpace(
    val l_img: String = "",
    val s_img: String = ""
)

data class BiliUserOfficial(
    val desc: String = "",
    val role: Int = 0,
    val title: String = "",
    val type: Int = 0
)

data class BiliUserLevelInfo(
    val current_exp: Int = 0,
    val current_level: Int = 0,
    val current_min: Int = 0,
    val next_exp: Int = 0
)

data class BiliUserNameplate(
    val condition: String = "",
    val image: String = "",
    val image_small: String = "",
    val level: String = "",
    val name: String = "",
    val nid: Int = 0
)

data class BiliUserOfficialVerify(
    val desc: String = "",
    val type: Int = 0
)

data class BiliUserPendant(
    val expire: Int = 0,
    val image: String = "",
    val image_enhance: String = "",
    val image_enhance_frame: String = "",
    val name: String = "",
    val pid: Int = 0
)

data class BiliUserVip(
    val avatar_subscript: Int = 0,
    val avatar_subscript_url: String = "",
    val due_date: Long = 0,
    val label: BiliUserLabel = BiliUserLabel(),
    val nickname_color: String = "",
    val role: Int = 0,
    val status: Int = 0,
    val theme_type: Int = 0,
    val tv_due_date: Int = 0,
    val tv_vip_pay_type: Int = 0,
    val tv_vip_status: Int = 0,
    val type: Int = 0,
    val vipStatus: Int = 0,
    val vipType: Int = 0,
    val vip_pay_type: Int = 0
)

data class BiliUserLabel(
    val bg_color: String = "",
    val bg_style: Int = 0,
    val border_color: String = "",
    val img_label_uri_hans: String = "",
    val img_label_uri_hans_static: String = "",
    val img_label_uri_hant: String = "",
    val img_label_uri_hant_static: String = "",
    val label_theme: String = "",
    val path: String = "",
    val text: String = "",
    val text_color: String = "",
    val use_img_label: Boolean = false
)
