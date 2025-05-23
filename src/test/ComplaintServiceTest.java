package test;

import db.ComplaintDao;
import model.Complaint;

import java.time.LocalDateTime;

/**
 * Unit tests for ComplaintDao and complaint submission.
 */
public class ComplaintServiceTest {
    public static void main(String[] args) {
        ComplaintDao dao = new ComplaintDao();

        Complaint newComplaint = new Complaint(
                1, // user_id (make sure user with id=1 exists in DB)
                "Missing Person",
                "Little boy with a scar on his forehead",
                "Islamabad",
                LocalDateTime.now(),
                "Pending",
                null
        );

        boolean result = dao.insertComplaint(newComplaint);

        System.out.println("Complaint Submission Test: " + (result ? "✅ Passed" : "❌ Failed"));
    }
}
