package service;

import db.DatabaseConnection;
import model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AuthService handles user-related operations like registration and login.
 */
public class AuthService {

    /**
     * Registers a new user by saving their details in the database.
     * Password is encrypted before storing.
     *
     * @param user The User object with name, email, and raw password.
     * @return true if registration was successful, false otherwise.
     */
    public boolean registerUser(User user) {
        String insertQuery = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {

            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, hashedPassword);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        }  catch (SQLException e) {
        if (e.getMessage().contains("Duplicate entry")) {
            System.out.println("❌ Registration failed: Email already exists.");
        } else {
            System.out.println("❌ Registration failed: " + e.getMessage());
        }
        return false;
    }

}

    /**
     * Verifies user credentials during login.
     */
    public User loginUser(String email, String password) {
        String selectQuery = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(selectQuery)) {

            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                String hashedPassword = result.getString("password");

                if (BCrypt.checkpw(password, hashedPassword)) {
                    return new User(
                            result.getInt("id"),
                            result.getString("name"),
                            result.getString("email"),
                            hashedPassword
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Login failed: " + e.getMessage());
        }

        return null;
    }
}
