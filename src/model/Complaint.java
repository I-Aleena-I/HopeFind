package model;

import java.time.LocalDateTime;

public class Complaint {
    private int id;
    private int userId;
    private String category;
    private String description;
    private String location;
    private LocalDateTime reportDate;
    private String status;
    private String photoPath;

    public Complaint() {}

    public Complaint(int userId, String category, String description, String location,
                     LocalDateTime reportDate, String status, String photoPath) {
        this.userId = userId;
        this.category = category;
        this.description = description;
        this.location = location;
        this.reportDate = reportDate;
        this.status = status;
        this.photoPath = photoPath;
    }

    // Getters and setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public LocalDateTime getReportDate() { return reportDate; }
    public void setReportDate(LocalDateTime reportDate) { this.reportDate = reportDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPhotoPath() { return photoPath; }
    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }
}
