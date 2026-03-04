# 📧 SES Mail Service (Spring Boot + Kotlin)

AWS SES를 활용한 이메일 전송 서비스 프로젝트입니다.
Spring Boot 기반 REST API + Thymeleaf + Swagger UI 환경으로 구성되어 있습니다.

---

## 1️⃣ 개발 환경

### 📌 Language & Framework

| 항목                    | 버전                      |
| --------------------- | ----------------------- |
| Language              | **Kotlin 2.2.21**       |
| Java                  | **Java 17 (Toolchain)** |
| Spring Boot           | **4.0.3**               |
| Dependency Management | **1.1.7**               |
| Build Tool            | **Gradle (Kotlin DSL)** |

### 📌 JVM 설정

```kotlin
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
```

---

## 2️⃣ 아키텍처 개요

* REST API 기반 메일 전송 서비스
* AWS SDK v2 기반 SES 연동
* Swagger UI 기반 API 문서 자동화
* Actuator를 통한 헬스체크 및 모니터링
* Validation 기반 요청값 검증
* AOP 적용 가능 구조

---

## 3️⃣ 사용 라이브러리 정리

### 🔹 Spring Boot Starter

| 라이브러리                            | 설명            |
| -------------------------------- | ------------- |
| `spring-boot-starter-web`        | REST API 서버   |
| `spring-boot-starter-thymeleaf`  | 템플릿 엔진        |
| `spring-boot-starter-validation` | 요청 DTO 검증     |
| `spring-boot-starter-actuator`   | 애플리케이션 모니터링   |
| `spring-boot-starter-mail`       | SMTP 기반 메일 지원 |
| `spring-boot-starter-aspectj`    | AOP 지원        |

---

### 🔹 AWS SDK (SES)

| 라이브러리                            | 버전      | 설명            |
| -------------------------------- | ------- | ------------- |
| `software.amazon.awssdk:ses`     | 2.22.13 | AWS SES 메일 전송 |
| `software.amazon.awssdk:auth`    | 2.22.13 | AWS 인증 처리     |
| `software.amazon.awssdk:regions` | 2.22.13 | 리전 설정         |

✔ AWS SDK v2 사용
✔ IAM 기반 인증 구조

---

### 🔹 API 문서화

| 라이브러리                                 | 버전    | 설명            |
| ------------------------------------- | ----- | ------------- |
| `springdoc-openapi-starter-webmvc-ui` | 3.0.2 | Swagger UI 제공 |

접속 경로 예시:

```
http://localhost:8080/swagger-ui.html
```

---

### 🔹 Kotlin

| 라이브러리            | 설명      |
| ---------------- | ------- |
| `kotlin-reflect` | 리플렉션 지원 |

---

### 🔹 테스트 환경

| 라이브러리                      | 설명                |
| -------------------------- | ----------------- |
| `spring-boot-starter-test` | 통합 테스트            |
| `kotlin-test-junit5`       | Kotlin JUnit5 테스트 |
| `junit-platform-launcher`  | JUnit 실행기         |

---

## 4️⃣ 빌드 및 실행

### 📌 빌드

```bash
./gradlew build
```

### 📌 실행

```bash
./gradlew bootRun
```

또는

```bash
java -jar build/libs/ses-0.0.1-SNAPSHOT.jar
```

---

## 5️⃣ 주요 기능

* AWS SES 기반 이메일 발송
* REST API 제공
* 요청 파라미터 Validation
* Swagger UI 자동 문서화
* Actuator 기반 헬스체크
* AOP 적용 가능 구조

---

## 6️⃣ 향후 확장 고려 사항

* Redis 기반 메일 큐 처리
* 비동기 발송 구조 적용
* Rate Limit 제어
* SNS/SES Bounce 이벤트 처리
* CloudWatch 연동 모니터링

---

## 7️⃣ 프로젝트 구조 예시

```
com.example.ses
 ├── config
 ├── controller
 ├── service
 ├── dto
 ├── exception
 └── SesApplication.kt
```

---

