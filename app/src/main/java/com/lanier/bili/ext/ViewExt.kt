package com.lanier.bili.ext

import android.view.View

/**
 * Created by 幻弦让叶
 * on 2023/10/23
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}
