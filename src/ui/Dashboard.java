package ui;

import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple dashboard after login.
 */
public class Dashboard extends JFrame {

    private User loggedInUser;

    public Dashboard(User user) {
        this.loggedInUser = user;
        initUI();
    }

    private void initUI() {
        setTitle("HopeFind - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome, " + loggedInUser.getName(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel, BorderLayout.CENTER);

        JButton complaintButton = new JButton("Submit Complaint");
        complaintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ComplaintForm(loggedInUser);
            }
        });
        add(complaintButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
