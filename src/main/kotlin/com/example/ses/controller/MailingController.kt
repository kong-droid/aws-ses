package com.example.ses.controller

import com.example.ses.dto.domain.request.MailingMultiRequest
import com.example.ses.dto.domain.request.MailingSingleRequest
import com.example.ses.dto.domain.response.MailingResultResponse
import com.example.ses.service.MailingService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mailing")
@Tag(name = "메일링", description = "메일링 서비스 테스트 API")
class MailingController(private val mailingService: MailingService) {

    @PostMapping("/single")
    @Operation(summary = "메일 발송", description = "단일 계정에게 발송")
    fun single(@RequestBody request: MailingSingleRequest):ResponseEntity<MailingResultResponse> =
        ResponseEntity.ok(mailingService.sendMail(request.to, request.mailTemplate))

    @PostMapping("/multi")
    @Operation(summary = "메일 발송", description = "여러 계정에게 발송(참조, 숨은 참조 포함")
    fun multi(@RequestBody request: MailingMultiRequest): ResponseEntity<MailingResultResponse> =
        ResponseEntity.ok(mailingService.sendMail(request.to, request.cc, request.bcc, request.mailTemplate))
}