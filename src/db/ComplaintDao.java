package db;

import model.Complaint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for handling complaint-related database operations.
 */
public class ComplaintDao {

    /**
     * Inserts a complaint into the database.
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
            stmt.setTimestamp(5, Timestamp.valueOf(complaint.getReportDate()));
            stmt.setString(6, complaint.getStatus());
            stmt.setString(7, complaint.getPhotoPath());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error in ComplaintDao (insert): " + e.getMessage());
            return false;
        }
    }

    /**
     * Searches complaints by keyword (in description).
     */
    public List<Complaint> searchByKeyword(String keyword) {
        List<Complaint> results = new ArrayList<>();
        String query = "SELECT * FROM complaints WHERE description LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(extractComplaint(rs));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error in ComplaintDao (search): " + e.getMessage());
        }

        return results;
    }

    /**
     * Filters complaints by category and location.
     */
    public List<Complaint> filterByCategoryAndLocation(String category, String location) {
        List<Complaint> results = new ArrayList<>();
        String query = "SELECT * FROM complaints WHERE category = ? AND location = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, category);
            stmt.setString(2, location);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(extractComplaint(rs));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error in ComplaintDao (filter): " + e.getMessage());
        }

        return results;
    }

    /**
     * Helper method to map a ResultSet row to a Complaint object.
     */
    private Complaint extractComplaint(ResultSet rs) throws SQLException {
        Complaint complaint = new Complaint();
        complaint.setId(rs.getInt("id"));
        complaint.setUserId(rs.getInt("user_id"));
        complaint.setCategory(rs.getString("category"));
        complaint.setDescription(rs.getString("description"));
        complaint.setLocation(rs.getString("location"));
        complaint.setReportDate(rs.getTimestamp("report_date").toLocalDateTime());
        complaint.setStatus(rs.getString("status"));
        complaint.setPhotoPath(rs.getString("photo_path"));
        return complaint;
    }
}
