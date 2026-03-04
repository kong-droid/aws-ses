package com.example.ses.service

import software.amazon.awssdk.services.ses.model.SendEmailResponse

interface MailingService {
    fun sendMail(to: String, subject: String, body: String): SendEmailResponse?
    fun sendMail(to: List<String>, cc: List<String>?, bcc: List<String>?, subject: String, body: String): SendEmailResponse?
}