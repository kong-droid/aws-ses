package com.example.ses.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "swagger.info")
class SwaggerConfig {
    lateinit var title: String
    lateinit var version: String
    lateinit var description: String

    @Bean
    fun openApi(): OpenAPI {
        val info = Info()
            .version(this.version)
            .title(this.title)
            .description(this.description)
        return OpenAPI().info(info)
    }
}