package com.example.ses.service

import com.example.ses.constants.MailTemplate
import com.example.ses.dto.domain.response.MailingResultResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine
import software.amazon.awssdk.services.ses.SesClient
import java.util.Locale

@Service
class MailingServiceImpl(
    private val sesClient: SesClient,
    private val sesEmailBuilder: SesEmailBuilder,
    private val templateEngine: SpringTemplateEngine,
    @Value("\${cloud.aws.email}") private val sender: String
) : MailingService {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun sendMail(to: String, mailTemplate: MailTemplate): MailingResultResponse? {
        val htmlBody = templateEngine.process("main", this.context(mailTemplate))
        val request = sesEmailBuilder.sendEmailRequest(sender, to, mailTemplate.subject, htmlBody)
        try {
            logger.info("request info: to= {}, subject= {}, body= {}", to, mailTemplate.subject, htmlBody)
            val result = sesClient.sendEmail(request)
            logger.info("result= {}", result)
            return MailingResultResponse(true)
        } catch(e: Exception) {
            logger.error("exception cause={}, message={}", e.cause, e.message)
            return MailingResultResponse(false)
        }
    }

    override fun sendMail(to: List<String>, cc: List<String>?, bcc: List<String>?, mailTemplate: MailTemplate): MailingResultResponse? {
        val htmlBody = templateEngine.process("main", this.context(mailTemplate))
        val request = sesEmailBuilder.sendEmailRequest(sender, to, cc, bcc, mailTemplate.subject, htmlBody)
        try {
            logger.info("request info: to= {}, cc= {}, bcc= {},subject= {}, body= {}", to, cc, bcc, mailTemplate.subject, htmlBody)
            val result = sesClient.sendEmail(request)
            logger.info("result= {}", result)
            return MailingResultResponse(true)
        } catch(e: Exception) {
            logger.error("exception cause= {}, message= {}", e.cause, e.message)
            return MailingResultResponse(false)
        }
    }

    private fun context(mailTemplate: MailTemplate): Context {
        val map = mapOf(
            "type" to mailTemplate.name.uppercase(),
            "subject" to mailTemplate.subject)
        return Context(Locale.KOREA, map)
    }

}