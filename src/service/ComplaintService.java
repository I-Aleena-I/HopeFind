package service;

import db.ComplaintDao;
import model.Complaint;

/**
 * Handles complaint logic using ComplaintDao.
 */
public class ComplaintService {

    private ComplaintDao complaintDao = new ComplaintDao();

    public boolean submitComplaint(Complaint complaint) {
        return complaintDao.insertComplaint(complaint);
    }
}
