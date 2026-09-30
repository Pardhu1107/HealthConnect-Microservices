# 🏥 HealthConnect - Microservices Telemedicine & Healthcare Platform

HealthConnect is an enterprise-grade Distributed Microservices Healthcare System built with **Java 17**, **Spring Boot 3**, **Spring Cloud (Eureka Server & API Gateway)**, **Spring Data JPA**, **MySQL**, and **OpenFeign**.

---

## 📐 System Architecture

```
                       ┌─────────────────────────┐
                       │   Client / Postman UI   │
                       └────────────┬────────────┘
                                    │
                                    ▼
                       ┌─────────────────────────┐
                       │       API GATEWAY       │  (Port: 8080)
                       │     (Single Entry)      │
                       └────────────┬────────────┘
                                    │
                       ┌────────────▼────────────┐
                       │      EUREKA SERVER      │  (Port: 8761)
                       │   (Service Discovery)   │
                       └────────────┬────────────┘
                                    │
          ┌─────────────────────────┼─────────────────────────┬─────────────────────────┐
          │                         │                         │                         │
          ▼                         ▼                         ▼                         ▼
┌──────────────────┐      ┌──────────────────┐      ┌──────────────────┐      ┌──────────────────┐
│ Patient Service  │      │ Practitioner Svc │      │ Appointment Svc  │      │ Prescription Svc │
│  (Port: 8081)    │      │  (Port: 8082)    │      │  (Port: 8083)    │      │  (Port: 8084)    │
└─────────┬────────┘      └─────────┬────────┘      └─────────┬────────┘      └─────────┬────────┘
          │                         │                         │                         │
          ▼                         ▼                         ▼                         ▼
┌──────────────────┐      ┌──────────────────┐      ┌──────────────────┐      ┌──────────────────┐
│   Patient DB     │      │  Practitioner DB │      │  Appointment DB  │      │  Prescription DB │
└──────────────────┘      └──────────────────┘      └──────────────────┘      └──────────────────┘
```

---

## 🚀 Microservices Breakdown

| Microservice | Port | Database | Key Functionality |
| :--- | :---: | :--- | :--- |
| **Eureka Server** | `8761` | N/A | Central Service Registry for dynamic service discovery. |
| **API Gateway** | `8080` | N/A | Single entry-point, JWT authentication & route management (`lb://`). |
| **Patient Service** | `8081` | `healthconnect_patient` | Patient registration, profile management & medical history. |
| **Practitioner Service** | `8082` | `healthconnect_practitioner` | Doctor profiles, specializations & availability scheduling. |
| **Appointment Service** | `8083` | `healthconnect_appointment` | Appointment booking workflow, OpenFeign client integration & status tracking. |
| **Prescription Service** | `8084` | `healthconnect_prescription` | Digital prescription issuance, medicine dosage & patient retrieval. |

---

## 🛠️ Prerequisites & Setup

### 1. Database Creation (MySQL)
Run the following commands in MySQL before starting the services:
```sql
CREATE DATABASE IF NOT EXISTS healthconnect_patient;
CREATE DATABASE IF NOT EXISTS healthconnect_practitioner;
CREATE DATABASE IF NOT EXISTS healthconnect_appointment;
CREATE DATABASE IF NOT EXISTS healthconnect_prescription;
```

### 2. Execution Order in STS (Spring Tool Suite) / IDE
1. `EurekaServerApplication` (Port 8761) -> Dashboard: `http://localhost:8761`
2. `PatientServiceApplication` (Port 8081)
3. `PractitionerServiceApplication` (Port 8082)
4. `AppointmentServiceApplication` (Port 8083)
5. `PrescriptionServiceApplication` (Port 8084)
6. `ApiGatewayApplication` (Port 8080)

---

## 🧪 Postman Collection

Import `HealthConnect_Postman_Collection.json` directly into Postman to test:
- **Authentication**: `POST http://localhost:8080/auth/login`
- **End-to-End Workflow**: Patient Registration ➔ Doctor Scheduling ➔ Appointment Booking ➔ Status Updates ➔ Digital Prescription Retrieval.

---

## 👤 Author & Maintainer
* **Author**: Pardhu1107
* **License**: MIT License
