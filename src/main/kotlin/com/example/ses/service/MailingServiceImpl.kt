package com.example.ses.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import software.amazon.awssdk.services.ses.SesClient
import software.amazon.awssdk.services.ses.model.SendEmailResponse

@Service
class MailingServiceImpl(
    private val sesClient: SesClient,
    private val sesEmailBuilder: SesEmailBuilder,
    @Value("\${cloud.aws.email}") private val sender: String
) : MailingService {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun sendMail(to: String, subject: String, body: String): SendEmailResponse? {
        val request = sesEmailBuilder.sendEmailRequest(sender, to, subject, body)
        try {
            logger.info("request info: to= {}, subject= {}, body= {}", to, subject, body)
            val result = sesClient.sendEmail(request)
            logger.info("result= {}", result)
            return result
        } catch(e: Exception) {
            logger.error("exception cause={}, message={}", e.cause, e.message)
            return null
        }
    }

    override fun sendMail(to: List<String>, cc: List<String>?, bcc: List<String>?,
                          subject: String, body: String): SendEmailResponse? {
        val request = sesEmailBuilder.sendEmailRequest(sender, to, cc, bcc, subject, body)
        try {
            logger.info("request info: to= {}, cc= {}, bcc= {},subject= {}, body= {}", to, cc, bcc, subject, body)
            val result = sesClient.sendEmail(request)
            logger.info("result= {}", result)
            return result
        } catch(e: Exception) {
            logger.error("exception cause= {}, message= {}", e.cause, e.message)
            return null
        }
    }

}