package db;

import model.Complaint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DAO for handling complaint-related database operations.
 */
public class ComplaintDao {

    /**
     * Inserts a complaint into the database.
     *
     * @param complaint the complaint to insert
     * @return true if inserted successfully, false otherwise
     */
    public boolean insertComplaint(Complaint complaint) {
        String query = "INSERT INTO complaints (user_id, category, description, location, report_date, status, photo_path) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, complaint.getUserId());
            stmt.setString(2, complaint.getCategory());
            stmt.setString(3, complaint.getDescription());
            stmt.setString(4, complaint.getLocation());
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(complaint.getReportDate()));
            stmt.setString(6, complaint.getStatus());
            stmt.setString(7, complaint.getPhotoPath());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error in ComplaintDao: " + e.getMessage());
            return false;
        }
    }
}
