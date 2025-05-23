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






**Developer**: Zainab Rehman\
**Module**: Complaint Management

---

## Backend Manual Tests
**Test Case 1**: Submit valid complaint\
**Expected**: Complaint inserted in DB with status "Pending"\
**Result**: Passed ✅

**Test Case 2**: Submit complaint with empty description\
**Expected**: Error returned, complaint not submitted\
**Result**: Passed ✅

**Test Case 3**: Submit complaint with invalid user ID\
**Expected**: Error returned, complaint not submitted\
**Result**: Passed ✅

**Test Case 4**: Submit complaint with photo attachment\
**Expected**: Complaint submitted with photo path stored\
**Result**: Passed ✅

**Test Case 5**: Update complaint status\
**Expected**: Status changed in DB (Pending → Verified → Closed)\
**Result**: Passed ✅

## GUI Tests
**Action**: Open Complaint Form\
**Result**: Form loads with all fields — Passed ✅

**Action**: Select complaint category\
**Result**: Category selection works — Passed ✅

**Action**: Submit with missing required fields\
**Result**: Error message shown — Passed ✅

**Action**: Upload file attachment\
**Result**: File name displayed — Passed ✅

**Action**: Submit valid complaint\
**Result**: Success message appears — Passed ✅

## Database Connection Tests
Insert Operation: Passed ✅

Select Operation: Passed ✅

Update Operation: Passed ✅

Verified by: Zainab Rehman
