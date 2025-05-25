package service;

import db.ComplaintDao;
import model.Complaint;

import java.util.List;

/**
 * Provides search and filter operations for complaints.
 */
public class SearchService {

    private final ComplaintDao dao = new ComplaintDao();

    /**
     * Search complaints by keyword in description.
     *
     * @param keyword the keyword to search
     * @return list of matching complaints
     */
    public List<Complaint> searchByKeyword(String keyword) {
        return dao.searchByKeyword(keyword);
    }
    public List<Complaint> filterByCategoryAndLocation(String category, String location) {
        return dao.filterByCategoryAndLocation(category,location);
    }
}
