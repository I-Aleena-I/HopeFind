# Test Results for Provided Test Cases

## 1. ComplaintServiceTest

- **Test:** Insert a new complaint for user_id=1
- **Result:** ✅ Passed  
  Complaint was inserted successfully.

## 2. SearchServiceTest

- **Test 1:** Search by keyword "missing"
- **Result:** ✅ Passed  
  Returned a non-null list (size ≥ 0).

- **Test 2:** Filter by category "Crime" and location "Lahore"
- **Result:** ✅ Passed  
  All returned complaints matched the category and location.

## 3. TestAuthService

- **Test 1:** Register a new user  
  Result: ✅ Passed

- **Test 2:** Attempt duplicate registration  
  Result: ✅ Passed (duplicate prevented)

- **Test 3:** Login with correct credentials  
  Result: ✅ Passed

- **Test 4:** Login with wrong password  
  Result: ✅ Passed (login rejected)

- **Test 5:** Login with non-existent email  
  Result: ✅ Passed (login rejected)

## 4. TestDatabaseConnection

- **Test 1:** Single database connection  
  Result: ✅ Passed (connection successful)

- **Test 2:** Open 3 sequential connections  
  Result: ✅ Passed (all connections successful)

---

# Summary
All manual and automated tests executed successfully without errors.  
No failed tests reported.
