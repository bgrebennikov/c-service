package com.example.usecase

import com.example.data.responses.CfgResponse

class GetConfigUseCase {

    suspend operator fun invoke() = CfgResponse()

}