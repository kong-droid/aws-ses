package com.example.ses.service

import org.springframework.stereotype.Component
import software.amazon.awssdk.services.ses.model.Body
import software.amazon.awssdk.services.ses.model.Content
import software.amazon.awssdk.services.ses.model.Destination
import software.amazon.awssdk.services.ses.model.Message
import software.amazon.awssdk.services.ses.model.SendEmailRequest

@Component
class SesEmailBuilder {
    /**
     * TODO
     * apply subject, template
     **/
    fun sendEmailRequest(sender: String, to: String, subject: String, body: String) : SendEmailRequest =
        SendEmailRequest.builder()
            .source(sender)
            .destination(
                Destination.builder()
                    .toAddresses(to)
                    .build()
            )
            .message(
                Message.builder()
                    .subject(Content.builder().data(subject).build())
                    .body(
                        Body.builder()
                            .text(Content.builder().data(body).build())
                            .build()
                    )
                    .build()
            )
            .build()

    fun sendEmailRequest(sender: String, to: List<String>, cc: List<String>? = null, bcc: List<String>? = null ,
                         subject: String, body: String) : SendEmailRequest {
        val destination = Destination
            .builder()
            .toAddresses(to)

        if(cc != null) {
            destination.ccAddresses(cc)
        }

        if(bcc != null) {
            destination.bccAddresses(bcc)
        }

        return SendEmailRequest.builder()
            .source(sender)
            .destination(destination.build())
            .message(
                Message.builder()
                    .subject(Content.builder().data(subject).build())
                    .body(
                        Body.builder()
                            .text(Content.builder().data(body).build())
                            .build()
                    )
                    .build()
            )
            .build()
    }

}