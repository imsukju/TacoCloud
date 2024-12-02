# TacoCloud 프로젝트

TacoCloud는 Spring Framework를 기반으로 설계된 다중 모듈 프로젝트입니다. 이 프로젝트는 실제 환경에서의 주문 관리 시스템, 메시징, API 설계, 보안, 데이터 연동 등 다양한 스프링 기술 스택을 활용하여 학습 및 실습을 목적으로 구성되었습니다.

---

## 포함된 모듈 설명

### 1. **ch8-jwt**
- **기능**: JWT(JSON Web Token)를 사용하여 사용자 인증 및 보안 관리.
- **구성 요소**:
  - `JwtService.java`: JWT 생성, 검증, 만료 시간 관리.
  - `SecurityConfig.java`: Spring Security와 JWT 연동 설정.
  - `AuthController.java`: 사용자 로그인 및 JWT 발급 API 제공.
- **주요 기능**:
  - 사용자 로그인 요청을 처리하고 JWT 발급.
  - 보호된 리소스에 접근 시 JWT의 유효성 검증.

#### 실행 방법
1. `application.yaml` 파일에 다음 설정 추가:
   ```yaml
   jwt:
     secret: YOUR_SECRET_KEY
     expiration: 3600000
   ```
2. 애플리케이션 실행 후 API 호출:
   - `POST /auth/login`: JWT 발급.
   - `GET /protected`: JWT 인증 테스트.

---

### 2. **tacocloud-security**
- **기능**: Spring Security를 활용한 사용자 인증 및 인가.
- **구성 요소**:
  - `UserService.java`: 사용자 인증 및 데이터 관리 로직.
  - `SecurityConfig.java`: 보안 설정 및 사용자 권한(Role) 관리.
- **주요 기능**:
  - 기본 로그인 및 로그아웃 기능 제공.
  - 사용자 역할(Role)에 따라 엔드포인트 접근 제어.

---

### 3. **tacocloud-api**
- **기능**: RESTful API 설계 및 데이터 CRUD 관리.
- **구성 요소**:
  - `TacoController.java`: Taco 엔티티 관련 API 제공.
  - `OrderController.java`: 주문 관련 CRUD API 제공.
- **주요 기능**:
  - JSON 형식의 요청 및 응답 처리.
  - RESTful 방식으로 데이터 관리.

---

### 4. **tacocloud-data**
- **기능**: Spring Data JPA를 활용하여 데이터 계층 설계.
- **구성 요소**:
  - `TacoRepository.java`: Taco 데이터베이스 액세스 계층.
  - `OrderRepository.java`: 주문 관련 CRUD 작업 처리.
- **주요 기능**:
  - 데이터베이스와 연동하여 CRUD 작업 수행.
  - 쿼리 메서드를 활용한 데이터 검색.

---

### 5. **tacocloud-domain**
- **기능**: 핵심 도메인 객체 설계.
- **구성 요소**:
  - `Taco.java`: Taco 엔티티 설계 및 매핑.
  - `Order.java`: 주문 엔티티 설계 및 매핑.
- **주요 기능**:
  - 도메인 객체를 데이터베이스 테이블과 매핑.

---

### 6. **tacocloud-kitchen**
- **기능**: 주방 관리 및 주문 상태 변경.
- **구성 요소**:
  - `KitchenController.java`: 주방 관리 API 제공.
  - `OrderProcessor.java`: 주문 상태 변경 로직.
- **주요 기능**:
  - 주방에서의 주문 처리 상태 관리.
  - 알림 전송을 통한 실시간 상태 업데이트.

---

### 7. **tacocloud-messaging-jms**
- **기능**: Java Messaging Service(JMS)를 활용한 메시징.
- **구성 요소**:
  - `MessagingConfig.java`: JMS 구성 설정.
  - `OrderMessagingService.java`: 메시지 송수신 로직.
- **주요 기능**:
  - 주문 상태 변경 메시지 전송 및 수신.
  - JMS를 사용하여 비동기 처리.

---

### 8. **tacocloud-messaging-kafka**
- **기능**: Apache Kafka를 사용한 메시징.
- **구성 요소**:
  - `KafkaProducer.java`: Kafka 메시지 생산자.
  - `KafkaConsumer.java`: Kafka 메시지 소비자.
- **주요 기능**:
  - 주문 데이터를 Kafka를 통해 송수신.
  - 비동기 메시지 처리를 활용한 확장성 확보.

---

### 9. **tacocloud-messaging-rabbitmq**
- **기능**: RabbitMQ를 사용한 메시징.
- **구성 요소**:
  - `RabbitMQConfig.java`: RabbitMQ 설정 파일.
  - `OrderMessagingService.java`: 메시징 서비스.
- **주요 기능**:
  - RabbitMQ 큐를 통해 주문 메시지 관리.
  - 주문 상태를 비동기로 처리.

---

### 10. **tacocloud-restclient**
- **기능**: RESTful 클라이언트를 사용하여 외부 API 호출.
- **구성 요소**:
  - `RestClientService.java`: 외부 API와의 통신 로직.
- **주요 기능**:
  - 외부 API로 데이터를 전송하거나 가져오기.
  - REST 클라이언트를 사용한 HTTP 요청/응답 관리.

---

### 11. **tacocloud-web**
- **기능**: TacoCloud 웹 프론트엔드 구현.
- **구성 요소**:
  - `TacoController.java`: 사용자 요청 처리 컨트롤러.
  - `orderForm.html`: 주문 입력 페이지.
- **주요 기능**:
  - 사용자와 상호작용 가능한 웹 인터페이스 제공.
  - 주문 작성 및 조회 기능.

---

## 실행 방법

### 1. **필수 요건**
- Java 17 이상
- Maven 또는 Gradle 설치
- Docker (Kafka, RabbitMQ와 같은 메시징 서비스 실행 시 필요)

### 2. **실행**
- 프로젝트 디렉토리로 이동:
  ```bash
  cd [모듈명]
  ```
- Maven을 사용하여 실행:
  ```bash
  mvn spring-boot:run
  ```

### 3. **테스트**
- 각 모듈별 API 또는 웹 브라우저를 통해 테스트:
  - `http://localhost:8080` (기본 포트)
  - Postman을 활용한 API 테스트.

---

## 사용 기술 스택

- **Spring Framework**
  - Spring Boot
  - Spring Data JPA
  - Spring Security
  - Spring Messaging
- **Messaging**
  - RabbitMQ
  - Apache Kafka
  - Java Messaging Service (JMS)
- **Frontend**
  - HTML, Thymeleaf
- **Database**
  - H2, MySQL (설정에 따라 변경 가능)
- **Authentication**
  - JWT (JSON Web Token)
