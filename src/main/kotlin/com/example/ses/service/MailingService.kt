package com.example.ses.service

import com.example.ses.constants.MailTemplate
import com.example.ses.dto.domain.response.MailingResultResponse

interface MailingService {
    fun sendMail(to: String, mailTemplate: MailTemplate): MailingResultResponse?
    fun sendMail(to: List<String>, cc: List<String>?, bcc: List<String>?, mailTemplate: MailTemplate): MailingResultResponse?
}