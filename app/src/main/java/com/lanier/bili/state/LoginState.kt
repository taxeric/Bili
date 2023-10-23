package com.lanier.bili.state

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Created by 幻弦让叶
 * on 2023/10/23
 */
sealed interface LoginState {
    data object Login: LoginState
    data object Unlogin: LoginState
}

private val _loginState = MutableStateFlow<LoginState>(LoginState.Unlogin)
val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

fun login() {
    _loginState.tryEmit(LoginState.Login)
}

fun unlogin() {
    _loginState.tryEmit(LoginState.Unlogin)
}
