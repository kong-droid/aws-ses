package com.example.ses.dto.domain.response

import io.swagger.v3.oas.annotations.media.Schema


data class MailingResultResponse(
    @field:Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "결과값, true or false")
    val isSuccess: Boolean
)