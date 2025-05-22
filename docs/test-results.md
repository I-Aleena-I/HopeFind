# HopeFind - Test Results

**Developer**: Aleena Asif  
**Module**: Account Management (Register/Login)

---

## Backend Manual Tests

**Test Case 1**: Register new user  
**Expected**: User registered and inserted in DB  
**Result**: Passed ✅

**Test Case 2**: Try registering with same email again  
**Expected**: Registration fails (duplicate email)  
**Result**: Passed ✅

**Test Case 3**: Login with correct email/password  
**Expected**: Dashboard opens  
**Result**: Passed ✅

**Test Case 4**: Login with wrong password  
**Expected**: Error shown  
**Result**: Passed ✅

**Test Case 5**: Login with unknown email  
**Expected**: Error shown  
**Result**: Passed ✅

---

## GUI Tests

**Action**: Open app  
**Result**: Login screen shows — Passed ✅

**Action**: Click "Go to Register"  
**Result**: Register form opens — Passed ✅

**Action**: Register valid user  
**Result**: Success message appears — Passed ✅

**Action**: Register with existing email  
**Result**: Error shown — Passed ✅

**Action**: Login with correct info  
**Result**: Dashboard appears — Passed ✅

---

## Database Connection Tests

**Connection 1**: Passed ✅  
**Connection 2**: Passed ✅  
**Connection 3**: Passed ✅  
