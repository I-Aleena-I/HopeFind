package ui;

import model.User;
import service.AuthService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI form for user login.
 */
public class LoginForm extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton goToRegisterButton;

    private AuthService authService;

    public LoginForm() {
        authService = new AuthService();
        initUI();
    }

    /**
     * Initializes the login form UI.
     */
    private void initUI() {
        setTitle("HopeFind - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        goToRegisterButton = new JButton("Go to Register");

        add(loginButton);
        add(goToRegisterButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });

        goToRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // close current form
                new RegisterForm(); // switch to register
            }
        });

        setVisible(true);
    }

    /**
     * Attempts to log the user in using the email and password.
     */
    private void loginUser() {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = authService.loginUser(email, password);

        if (user != null) {
            JOptionPane.showMessageDialog(this, "Login successful! Welcome, " + user.getName(), "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // close login form
            new Dashboard(user); // open dashboard
        } else {
            JOptionPane.showMessageDialog(this, "Login failed. Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
