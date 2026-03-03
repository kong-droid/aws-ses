package com.example.ses.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.ses.SesClient

@Configuration
@ConfigurationProperties(prefix = "cloud.aws")
class AwsSesConfig {
    lateinit var region: String
    lateinit var accessKey: String
    lateinit var secretKey: String

    @Bean
    fun sesClient(): SesClient {
        val builder = SesClient.builder()
            .region(Region.of(this.region))
            .credentialsProvider(
                StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(this.accessKey, this.secretKey)
                )
            )
        return builder.build()
    }
}