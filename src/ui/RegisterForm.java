package ui;

import model.User;
import service.AuthService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI form for user registration.
 */
public class RegisterForm extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton goToLoginButton;
    private AuthService authService;

    public RegisterForm() {
        authService = new AuthService();
        initUI();
    }

    /**
     * Initializes the registration form UI.
     */
    private void initUI() {
        setTitle("HopeFind - Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // center the window
        setLayout(new GridLayout(5, 2, 10, 10));

        // Fields and labels
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // Buttons
        registerButton = new JButton("Register");
        goToLoginButton = new JButton("Go to Login");

        add(registerButton);
        add(goToLoginButton);

        // Register button logic
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        // Login redirection (not implemented yet)
        goToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current form
                new LoginForm(); // Open login form
            }
        });

        setVisible(true);
    }

    /**
     * Reads user input and attempts to register a new account.
     */
    private void registerUser() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = new User(name, email, password);
        boolean success = authService.registerUser(user);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed. Email might be taken.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
