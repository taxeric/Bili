package com.lanier.bili.ext

import android.content.Context
import android.content.Intent

/**
 * Created by 幻弦让叶
 * on 2023/10/1
 */
inline fun <reified C> Context.start(
    crossinline block: Intent.() -> Unit = {}
) {
    val intent = Intent(this, C::class.java)
    block.invoke(intent)
    startActivity(intent)
}
