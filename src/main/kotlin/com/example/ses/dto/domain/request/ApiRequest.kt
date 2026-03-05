package com.example.ses.dto.domain.request

import com.example.ses.constants.MailTemplate
import io.swagger.v3.oas.annotations.media.Schema

data class MailingSingleRequest(
    @field:Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "템플릿 타입 = WELCOME, HELLO_WORLD, BUG")
    val mailTemplate: MailTemplate,
    @field:Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "받는 이메일")
    val to: String
)

data class MailingMultiRequest(
    @field:Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "템플릿 타입 = WELCOME, HELLO_WORLD, BUG")
    val mailTemplate: MailTemplate,
    @field:Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "받는 이메일, ['sample1@example.com', 'sample2@example.com']")
    val to: List<String>,
    @field:Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "참조 이메일, ['sample1@example.com', 'sample2@example.com']")
    val cc: List<String>?,
    @field:Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "숨은 참조 이메일, ['sample1@example.com', 'sample2@example.com']")
    val bcc: List<String>?
)