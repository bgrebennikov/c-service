package com.example.services.telegram

import com.example.data.telegram.states.BotState
import dev.inmo.micro_utils.fsm.common.utils.StateHandlingErrorHandler


class BotStateErrorHandler : StateHandlingErrorHandler<BotState> {
    override suspend fun invoke(state: BotState, e: Throwable): BotState {
        return state.apply {
            throwable = e
        }
    }
}