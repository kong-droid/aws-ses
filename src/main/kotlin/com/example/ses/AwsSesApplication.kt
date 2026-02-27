package com.example.ses

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AwsSesApplication

fun main(args: Array<String>) {
    runApplication<AwsSesApplication>(*args)
}
