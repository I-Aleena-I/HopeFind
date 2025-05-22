# HopeFind - Community Safety & Complaint Platform

HopeFind is a Java-based desktop application that allows users to register, log in, and submit safety-related complaints (like missing persons, lost items, etc.) in a secure and organized way.

---

## Developed By

- Aleena Asif (Account Management)
- Zainab Rehman (Complaint Submission)
- Maryam Shaukat (Search/Filter)
- Mir Fawad-ul-Haq (Admin Panel)

---

## Features Implemented (Phase 1)

- User registration with email and password
- Secure password hashing using BCrypt
- Login form with validation
- Dashboard greeting for logged-in users
- MySQL backend connection with JDBC
- GUI forms built using Java Swing

---

## 🛠 Technologies Used

- Java (JDK 17+)
- Swing (GUI)
- MySQL (Database)
- BCrypt (Password encryption)
- IntelliJ IDEA
- GitHub for version control

---

## How to Run

### 1. Requirements
- Java JDK 17+
- MySQL Server
- IntelliJ IDEA (or another IDE)

### 2. Setup

- Create a MySQL database:
```sql
CREATE DATABASE hopefind;

USE hopefind;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  email VARCHAR(100) UNIQUE,
  password VARCHAR(255)
);
