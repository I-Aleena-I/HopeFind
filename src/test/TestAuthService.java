package test;

import model.User;
import service.AuthService;

/**
 * Manual test class for AuthService.
 */
public class TestAuthService {
    public static void main(String[] args) {
        AuthService auth = new AuthService();

        // Test 1: Register a new user
        User newUser = new User("Test User", "testuser@example.com", "test123");
        boolean isRegistered = auth.registerUser(newUser);
        System.out.println("Register New User: " + (isRegistered ? "✅ Passed" : "❌ Failed"));

        // Test 2: Attempt duplicate registration
        boolean isDuplicate = auth.registerUser(newUser);
        System.out.println("Duplicate Email Registration: " + (!isDuplicate ? "✅ Passed" : "❌ Failed"));

        // Test 3: Login with correct credentials
        User loggedIn = auth.loginUser("testuser@example.com", "test123");
        System.out.println("Login with Correct Credentials: " + (loggedIn != null ? "✅ Passed" : "❌ Failed"));

        // Test 4: Login with wrong password
        User wrongPass = auth.loginUser("testuser@example.com", "wrongpass");
        System.out.println("Login with Wrong Password: " + (wrongPass == null ? "✅ Passed" : "❌ Failed"));

        // Test 5: Login with non-existent email
        User nonExistent = auth.loginUser("notexist@example.com", "anything");
        System.out.println("Login with Non-Existent Email: " + (nonExistent == null ? "✅ Passed" : "❌ Failed"));
    }
}
