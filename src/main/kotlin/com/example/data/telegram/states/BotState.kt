package com.example.data.telegram.states

import dev.inmo.micro_utils.fsm.common.State

sealed class BotState : State {
    var throwable: Throwable? = null
    val answers : MutableMap<String, String> = mutableMapOf()
}