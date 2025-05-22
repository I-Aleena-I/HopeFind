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
