package ui;

import model.Complaint;
import model.User;
import service.ComplaintService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 * GUI form for submitting complaints.
 */
public class ComplaintForm extends JFrame {

    private JComboBox<String> categoryBox;
    private JTextArea descriptionArea;
    private JTextField locationField;
    private JButton submitButton;
    private User loggedInUser;
    private ComplaintService complaintService;

    public ComplaintForm(User user) {
        this.loggedInUser = user;
        this.complaintService = new ComplaintService();
        initUI();
    }

    private void initUI() {
        setTitle("Submit Complaint");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        categoryBox = new JComboBox<>(new String[] {
                "Missing Person", "Lost Item", "Accident", "Suspicious Activity", "Other"
        });

        descriptionArea = new JTextArea();
        locationField = new JTextField();
        submitButton = new JButton("Report");

        add(new JLabel("Category:"));
        add(categoryBox);
        add(new JLabel("Description:"));
        add(new JScrollPane(descriptionArea));
        add(new JLabel("Location:"));
        add(locationField);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitComplaint();
            }
        });

        setVisible(true);
    }

    private void submitComplaint() {
        String category = (String) categoryBox.getSelectedItem();
        String description = descriptionArea.getText().trim();
        String location = locationField.getText().trim();

        if (description.isEmpty() || location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Complaint complaint = new Complaint(
                loggedInUser.getId(),
                category,
                description,
                location,
                LocalDateTime.now(),
                "Pending",
                null
        );

        boolean success = complaintService.submitComplaint(complaint);
        if (success) {
            JOptionPane.showMessageDialog(this, "Complaint submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            descriptionArea.setText("");
            locationField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error submitting complaint.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
//.3