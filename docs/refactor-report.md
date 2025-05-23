# Refactor Report - HopeFind (Account Management)

## Author: Aleena Asif

---

## Refactor Summary

This document outlines the clean code principles and improvements made to the HopeFind Account Management module.

---

### 1. Code Organization

- Split logic into packages: `model`, `service`, `db`, `ui`
- `Main.java` used as a clean entry point
- GUI code isolated from business logic (AuthService)

---

### 2. Clean Code Principles Used

| Principle               | Example                                  |
|-------------------------|-------------------------------------------|
| Descriptive naming      | `registerUser()`, `DatabaseConnection`   |
| No duplication (DRY)    | Shared `User` object across services and UI |
| Meaningful comments     | Used only where logic needs clarity      |
| SRP (Single Responsibility) | Each class does one clear job         |
| Password Security       | Used BCrypt to hash passwords            |
| Graceful error handling | Try-catch with user-friendly messages    |

---

### Refactor Changes

| File              | What Was Refactored                        |
|-------------------|---------------------------------------------|
| `AuthService.java`| Extracted DB logic, added hash checking     |
| `LoginForm.java`  | Removed logic duplication, added validation |
| `RegisterForm.java` | Added form validation, clear messages    |
| `DatabaseConnection.java` | Separated DB logic into a utility  |

---

## Next Suggestions

- Add field validation (email format)
- Create GUI form for complaint submission
- Write JUnit test cases for full automation




# Refactor Report - HopeFind (Complaint Management)
## Author: Zainab Rehman

---


## Refactor Summary
This document outlines the clean code principles and improvements made to 
the HopeFind Complaint Management module.

---


### 1. Code Organization
- Structured packages: `model`, `service`, `db`, `ui`

- Clear separation between complaint submission and processing

- Dedicated complaint tracking system

---

### 2. Clean Code Principles Used


| Principle               | Example                                  |
|-------------------------|-------------------------------------------|
| Descriptive naming      | `submitComplaint()`, `ComplaintStatus`   |
| No duplication (DRY)    | Centralized complaint validation logic    |
| Meaningful comments     | Added where business logic needs clarity  |
| SRP (Single Responsibility) | Separated report generation from submission |
| Data Security          | Parameterized SQL queries                |
| Graceful error handling | Unified complaint processing errors      |

---
   
### Refactor Changes

| File                   | What Was Refactored                     |
|------------------------|-----------------------------------------|
| `ComplaintDao.java`    | Implemented proper connection management |
| `ComplaintService.java`| Added validation layer before DB ops     |
| `ComplaintForm.java`   | Separated UI from business logic        |
| `Complaint.java`       | Enhanced model with status tracking     |

---
   
### Next Suggestions

- Add complaint category filtering

- Implement photo attachment compression

- Develop automated status notifications

- Create comprehensive test suite for complaint workflows





