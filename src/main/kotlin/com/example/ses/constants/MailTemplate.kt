package com.example.ses.constants

enum class MailTemplate(val subject: String, val templateName: String) {
    WELCOME("환영합니다.", "welcome.html"),
    HELLO_WORLD("Hello World!", "hello-world.html"),
    BUG("버그 발생!", "bug.html")
}