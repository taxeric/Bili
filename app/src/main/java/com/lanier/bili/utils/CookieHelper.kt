package com.lanier.bili.utils

import okhttp3.Headers

/**
 * Created by 幻弦让叶
 * on 2023/9/18
 *
 * 用于获取cookie
 */
object CookieHelper {

    // <editor-fold defaultstate="collapsed" desc="存储的key, helper不会存储, 需外部主动存储">
    const val bili_jct = "bili_jct"
    const val SESSDATA = "SESSDATA"
    const val DedeUserID = "DedeUserID"
    const val DedeUserID__ckMd5 = "DedeUserID__ckMd5"
    const val sid = "sid"
    const val merge = "merge"
    // </editor-fold>

    fun obtainCookies(
        headers: Headers? = null,
        print: Boolean = true,
        onCompleted: (
            keys: Array<String>,
            values: Array<String>,
            merge: String,
        ) -> Unit = {_,_,_->}
    ) {
        if (headers == null) {
            onCompleted.invoke(emptyArray(), emptyArray(), "")
            return
        }
        val keys = mutableListOf<String>()
        val values = mutableListOf<String>()
        val merge = StringBuilder()
        headers.forEachIndexed { index, header ->
            if (header.first.contains("cookie")) {
                val second = header.second
                val merge_split = handleCookies(second, keys, values)
                merge.append(merge_split).append(" ")
            }
        }
        if (print) {
            println(keys)
            println(values)
        }
        onCompleted.invoke(
            keys.toTypedArray(),
            values.toTypedArray(),
            merge.deleteAt(merge.lastIndex).toString()
        )
    }

    private fun handleCookies(
        second: String,
        keys: MutableList<String>,
        values: MutableList<String>
    ): String {
        var merge_spilt = ""
        if (second.contains(";")) {
            val firstIndex = second.indexOf(";")
            val singleCookie = second.substring(0, firstIndex)
            merge_spilt = second.substring(0, firstIndex + 1)
            if (singleCookie.contains("=")) {
                val cookie = singleCookie.split("=")
                if (cookie.size == 2) {
                    keys.add(cookie[0])
                    values.add(cookie[1])
                }
            }
        }
        return merge_spilt
    }
}