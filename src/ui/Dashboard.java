package ui;
import model.Complaint;
import model.User;
import service.SearchService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Simple dashboard after login.
 */
public class Dashboard extends JFrame {

    private User loggedInUser;

    // Part 3: Search & Filter components
    JTextField txtSearch;
    JButton btnSearch, btnFilter;
    JComboBox<String> cmbCategory, cmbLocation;
    JTable tblResults;
    DefaultTableModel tblModel;

    public Dashboard(User user) {
        this.loggedInUser = user;
        initUI();
    }

    private void initUI() {
        setTitle("HopeFind - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Original Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome, " + loggedInUser.getName(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel, BorderLayout.NORTH);

        // Original Complaint Button
        JButton complaintButton = new JButton("Submit Complaint");
        complaintButton.addActionListener(e -> new ComplaintForm(loggedInUser));
        add(complaintButton, BorderLayout.SOUTH);

        // New: Search & Filter Panel (Part 3)
        JPanel searchPanel = new JPanel();
        txtSearch = new JTextField(10);
        btnSearch = new JButton("Search");

        cmbCategory = new JComboBox<>(new String[]{"Crime", "Lost Item", "Missing Person"});
        cmbLocation = new JComboBox<>(new String[]{"Lahore", "Karachi", "Islamabad"});
        btnFilter = new JButton("Apply Filter");

        searchPanel.add(new JLabel("Keyword:"));
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);
        searchPanel.add(new JLabel("Category:"));
        searchPanel.add(cmbCategory);
        searchPanel.add(new JLabel("Location:"));
        searchPanel.add(cmbLocation);
        searchPanel.add(btnFilter);
        add(searchPanel, BorderLayout.CENTER);

        // New: Table to show results
        String[] columns = {"Category", "Description", "Location", "Status"};
        tblModel = new DefaultTableModel(columns, 0);
        tblResults = new JTable(tblModel);
        JScrollPane scrollPane = new JScrollPane(tblResults);
        add(scrollPane, BorderLayout.EAST);

        // Connect actions to SearchService
        SearchService searchService = new SearchService();

        btnSearch.addActionListener(e -> {
            String keyword = txtSearch.getText();
            List<Complaint> results = searchService.searchByKeyword(keyword);
            updateTable(results);
        });

        btnFilter.addActionListener(e -> {
            String category = (String) cmbCategory.getSelectedItem();
            String location = (String) cmbLocation.getSelectedItem();
            List<Complaint> results = searchService.filterByCategoryAndLocation(category, location);
            updateTable(results);
        });

        setVisible(true);
    }

    private void updateTable(List<Complaint> list) {
        tblModel.setRowCount(0);
        for (Complaint c : list) {
            tblModel.addRow(new Object[]{
                    c.getCategory(),
                    c.getDescription(),
                    c.getLocation(),
                    c.getStatus()
            });
    }
}
}