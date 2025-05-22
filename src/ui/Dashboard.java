package ui;

import model.User;

import javax.swing.*;
import java.awt.*;

/**
 * Simple dashboard displayed after successful login.
 */
public class Dashboard extends JFrame {

    private User loggedInUser;

    public Dashboard(User user) {
        this.loggedInUser = user;
        initUI();
    }

    /**
     * Initializes the dashboard UI.
     */
    private void initUI() {
        setTitle("HopeFind - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome, " + loggedInUser.getName() + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel);

        setVisible(true);
    }
}
