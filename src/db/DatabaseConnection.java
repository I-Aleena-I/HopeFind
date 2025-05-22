package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides a reusable method to connect to the MySQL database.
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/hopefind";
    private static final String USER = "root";
    private static final String PASSWORD = "Snack_Time#88";

    /**
     * Establishes and returns a MySQL database connection.
     *
     * @return Connection object or null if failed
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed: " + e.getMessage());
            return null;
        }
    }
}
