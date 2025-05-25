# Refactor Report for Test Cases

## Overview

This report covers refactoring observations and recommendations for the provided test cases:  
- ComplaintServiceTest  
- SearchServiceTest  
- TestAuthService  
- TestDatabaseConnection

---

## 1. ComplaintServiceTest

- **Current State:**  
  Manual test using `main` method and print statements.  
- **Refactor Suggestions:**  
  - Convert to a proper unit test framework like JUnit for automated test runs.  
  - Use assertions instead of printing results for better test validation.  
  - Add setup and teardown methods to prepare test data and clean up.

---

## 2. SearchServiceTest

- **Current State:**  
  Uses JUnit 5 tests with assertions.  
- **Refactor Suggestions:**  
  - Add test cases for no results scenarios.  
  - Add tests for invalid or empty inputs.  
  - Use mock objects for data isolation if possible.  
  - Use `assertTrue(results.size() > 0)` where expecting guaranteed results.

---

## 3. TestAuthService

- **Current State:**  
  Manual testing via `main` method with print statements.  
- **Refactor Suggestions:**  
  - Migrate to JUnit tests with proper assertions.  
  - Separate tests for registration, duplicate registration, login success, login failure.  
  - Mock data source or reset DB state before each test to avoid side effects.

---

## 4. TestDatabaseConnection

- **Current State:**  
  Manual testing with multiple sequential connection attempts and print output.  
- **Refactor Suggestions:**  
  - Use JUnit to automate connection tests with assertions.  
  - Add negative tests for invalid credentials or unreachable DB.  
  - Close connections properly (already using try-with-resources, good practice).  

---

## Summary

Manual tests relying on `System.out.println` would benefit greatly from migrating to automated test frameworks such as JUnit to enable repeatable, reliable, and clear test results. Adding mocking and test isolation will improve robustness and maintainability.
