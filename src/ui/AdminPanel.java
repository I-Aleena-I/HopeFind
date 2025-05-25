package ui;

import db.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPanel extends JFrame {
    private JTextArea complaintArea;
    private JLabel analyticsLabel;

    public AdminPanel() {
        setTitle("Admin Panel - HopeFind");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        complaintArea = new JTextArea();
        complaintArea.setEditable(false);
        add(new JScrollPane(complaintArea), BorderLayout.CENTER);

        analyticsLabel = new JLabel("Analytics: Loading...");
        add(analyticsLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JTextField idField = new JTextField(5);
        JButton approveBtn = new JButton("Approve");
        JButton rejectBtn = new JButton("Reject");
        JButton deleteBtn = new JButton("Delete False");
        JButton refreshBtn = new JButton("Refresh");

        buttonPanel.add(new JLabel("Complaint ID:"));
        buttonPanel.add(idField);
        buttonPanel.add(approveBtn);
        buttonPanel.add(rejectBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(refreshBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        approveBtn.addActionListener(e -> handleAction(idField, "APPROVED"));
        rejectBtn.addActionListener(e -> handleAction(idField, "REJECTED"));
        deleteBtn.addActionListener(e -> handleAction(idField, "DELETE"));
        refreshBtn.addActionListener(e -> refreshData());

        refreshData();
        setVisible(true);
    }

    private void handleAction(JTextField idField, String action) {
        Connection conn = null;
        try {
            int id = Integer.parseInt(idField.getText());
            conn = DatabaseConnection.getConnection();
            if (conn != null) {
                if ("DELETE".equals(action)) {
                    String sql = "DELETE FROM complaints WHERE id = ?";
                    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setInt(1, id);
                        stmt.executeUpdate();
                    }
                } else {
                    String sql = "UPDATE complaints SET status = ? WHERE id = ?";
                    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, action);
                        stmt.setInt(2, id);
                        stmt.executeUpdate();
                    }
                }
                refreshData();
            }
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }

    private void refreshData() {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            if (conn != null) {
                StringBuilder sb = new StringBuilder();
                String sql = "SELECT id, title, status FROM complaints";
                try (PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        sb.append("ID: ").append(rs.getInt("id"))
                                .append(", Title: ").append(rs.getString("title"))
                                .append(", Status: ").append(rs.getString("status"))
                                .append("\n");
                    }
                }
                complaintArea.setText(sb.toString());

                sql = "SELECT COUNT(*) as total, SUM(CASE WHEN status IN ('APPROVED', 'REJECTED') THEN 1 ELSE 0 END) as resolved FROM complaints";
                try (PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int total = rs.getInt("total");
                        int resolved = rs.getInt("resolved");
                        double percentage = total > 0 ? (resolved * 100.0 / total) : 0;
                        analyticsLabel.setText("Total: " + total + ", Resolved: " + resolved + ", %: " + String.format("%.2f", percentage));
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminPanel::new);
    }
}