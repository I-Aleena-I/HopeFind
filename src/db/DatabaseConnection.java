package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides a reusable method to connect to the MySQL database.
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "scd@123"; // Replace with your current MySQL password

    /**
     * Establishes and returns a MySQL database connection.
     *
     * @return Connection object or null if failed
     */
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    /**
     * Closes the given database connection.
     *
     * @param conn the Connection object to close
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    // For testing the connection
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            closeConnection(conn);
        }
    }
}