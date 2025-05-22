package test;

import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Manual test class for testing database connection logic.
 */
public class TestDatabaseConnection {
    public static void main(String[] args) {
        System.out.println("🔁 Testing database connection...");


        // Test 1: Simple connection
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connection successful.");
            } else {
                System.out.println("❌ Connection returned null.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }

        // Test 2: Open 3 sequential connections
        for (int i = 1; i <= 3; i++) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                System.out.println("✅ Connection " + i + " established.");
            } catch (SQLException e) {
                System.out.println("❌ Connection " + i + " failed: " + e.getMessage());
            }
        }

        System.out.println("✅ Database connection test completed.");
    }
}
