package com.lanier.bili.ext

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 * Created by 幻弦让叶
 * on 2023/9/30
 */
fun <T> LifecycleOwner.collect(
    flow: Flow<T>,
    block: suspend (T) -> Unit,
) {
    lifecycleScope.launch {
        collect(flow) {
            block.invoke(it)
        }
    }
}

fun <T> LifecycleOwner.collectWhenStarted(
    flow: Flow<T>,
    block: suspend (T) -> Unit,
) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            collect(flow) {
                block.invoke(it)
            }
        }
    }
}

suspend fun <T> collect(
    flow: Flow<T>,
    block: suspend (T) -> Unit
) {
    flow.collect {
        block.invoke(it)
    }
}
