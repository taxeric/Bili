package com.lanier.bili.models

/**
 * Created by 幻弦让叶
 * on 2023/9/19
 */
data class BiliVideoDetailsEntity(
    val aid: Long = 0L,
    val bvid: String = "",
    val cid: Long = 0L,
    val copyright: Int = 0,
    val ctime: Int = 0,
    val desc: String = "",
    val desc_v2: List<BiliVideoDetailsDescV2> = listOf(),
    val dimension: BiliVideoDetailsDimension = BiliVideoDetailsDimension(),
    val disable_show_up_info: Boolean = false,
    val duration: Int = 0,
    val `dynamic`: String = "",
    val enable_vt: Int = 0,
    val honor_reply: BiliVideoDetailsHonorReply? = BiliVideoDetailsHonorReply(),
    val is_chargeable_season: Boolean = false,
    val is_season_display: Boolean = false,
    val is_story: Boolean = false,
    val is_upower_exclusive: Boolean = false,
    val is_upower_play: Boolean = false,
    val like_icon: String = "",
    val mission_id: Int = 0,
    val need_jump_bv: Boolean = false,
    val no_cache: Boolean = false,
    val owner: BiliVideoDetailsOwner = BiliVideoDetailsOwner(),
    val pages: List<BiliVideoDetailsPage>? = listOf(),
    val pic: String = "",
    val premiere: Any? = Any(),
    val pubdate: Int = 0,
    val rights: BiliVideoDetailsRights = BiliVideoDetailsRights(),
    val stat: BiliVideoDetailsStat = BiliVideoDetailsStat(),
    val state: Int = 0,
    val subtitle: BiliVideoDetailsSubtitle = BiliVideoDetailsSubtitle(),
    val teenage_mode: Int = 0,
    val tid: Int = 0,
    val title: String = "",
    val tname: String = "",
    val user_garb: BiliVideoDetailsUserGarb = BiliVideoDetailsUserGarb(),
    val videos: Int = 0,
    val vt_display: String = "",
)

data class BiliVideoDetailsDescV2(
    val biz_id: Int = 0,
    val raw_text: String = "",
    val type: Int = 0
)

data class BiliVideoDetailsDimension(
    val height: Int = 0,
    val rotate: Int = 0,
    val width: Int = 0
)

data class BiliVideoDetailsHonorReply(
    val honor: List<BiliVideoDetailsHonor> = listOf()
)

data class BiliVideoDetailsOwner(
    val face: String = "",
    val mid: Long = 0L,
    val name: String = ""
)

data class BiliVideoDetailsPage(
    val cid: Long = 0L,
    val dimension: BiliVideoDetailsDimension = BiliVideoDetailsDimension(),
    val duration: Int = 0,
    val first_frame: String = "",
    val from: String = "",
    val page: Int = 0,
    val part: String = "",
    val vid: String = "",
    val weblink: String = ""
)

data class BiliVideoDetailsRights(
    val arc_pay: Int = 0,
    val autoplay: Int = 0,
    val bp: Int = 0,
    val clean_mode: Int = 0,
    val download: Int = 0,
    val elec: Int = 0,
    val free_watch: Int = 0,
    val hd5: Int = 0,
    val is_360: Int = 0,
    val is_cooperation: Int = 0,
    val is_stein_gate: Int = 0,
    val movie: Int = 0,
    val no_background: Int = 0,
    val no_reprint: Int = 0,
    val no_share: Int = 0,
    val pay: Int = 0,
    val ugc_pay: Int = 0,
    val ugc_pay_preview: Int = 0
)

data class BiliVideoDetailsStat(
    val aid: Long = 0L,
    val argue_msg: String = "",
    val coin: Int = 0,
    val danmaku: Int = 0,
    val dislike: Int = 0,
    val evaluation: String = "",
    val favorite: Int = 0,
    val his_rank: Int = 0,
    val like: Int = 0,
    val now_rank: Int = 0,
    val reply: Int = 0,
    val share: Int = 0,
    val view: Int = 0,
    val vt: Int = 0,
)

data class BiliVideoDetailsSubtitle(
    val allow_submit: Boolean = false,
    val list: List<BiliVideoDetailsZiMu>? = listOf()
)

data class BiliVideoDetailsUserGarb(
    val url_image_ani_cut: String = ""
)

data class BiliVideoDetailsHonor(
    val aid: Long = 0L,
    val desc: String = "",
    val type: Int = 0,
    val weekly_recommend_num: Int = 0
)

data class BiliVideoDetailsZiMu(
    val ai_status: Int = 0,
    val ai_type: Int = 0,
    val author: BiliVideoDetailsAuthor = BiliVideoDetailsAuthor(),
    val id: Long = 0,
    val id_str: String = "",
    val is_lock: Boolean = false,
    val lan: String = "",
    val lan_doc: String = "",
    val subtitle_url: String = "",
    val type: Int = 0
)

data class BiliVideoDetailsAuthor(
    val birthday: Int = 0,
    val face: String = "",
    val in_reg_audit: Int = 0,
    val is_deleted: Int = 0,
    val is_fake_account: Int = 0,
    val is_senior_member: Int = 0,
    val mid: Int = 0,
    val name: String = "",
    val rank: Int = 0,
    val sex: String = "",
    val sign: String = ""
)
