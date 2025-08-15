package loginsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * A simple GUI-based User Registration and Login System.
 * 
 * This system allows multiple users to:
 *  1. Register with a username and password
 *  2. Get confirmation of successful registration
 *  3. Login with their credentials
 *  4. Receive success or error messages after login
 * 
 * Data is stored in memory using a HashMap (username → password).
 */
public class LoginSystem {
	
    // HashMap acts as a simple user database (username -> password)
	
	// Stores registered users (username as key, password as value)
	
    private static HashMap<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showMainMenu());
    }
// Shows 2 buttons to select from either register or login.
    
    private static void showMainMenu() {
        JFrame frame = new JFrame("User Authentication System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JButton registerBtn = new JButton("Register");
        JButton loginBtn = new JButton("Login");

        registerBtn.addActionListener(e -> {
            frame.dispose();
            showRegisterForm();
        });

        loginBtn.addActionListener(e -> {
            frame.dispose();
            showLoginForm();
        });

        frame.add(new JLabel("Welcome! Please Register or Login"));
        frame.add(registerBtn);
        frame.add(loginBtn);

        frame.setVisible(true);
    }
//Display registration form 
    
    private static void showRegisterForm() {
        JFrame frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back");

        registerBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Fields cannot be empty!");
            } else if (userDatabase.containsKey(username)) {
                JOptionPane.showMessageDialog(frame, "User already exists!");
            } else {
                userDatabase.put(username, password);
                JOptionPane.showMessageDialog(frame, "Registration Successful!");
                frame.dispose();
                showMainMenu();
            }
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            showMainMenu();
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(registerBtn);
        frame.add(backBtn);

        frame.setVisible(true);
    }
//Display Login form
    private static void showLoginForm() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");
        JButton backBtn = new JButton("Back");

        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            
//on successful login welcomes and on unsuccessful one displays error message
            
            if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                JOptionPane.showMessageDialog(frame, "Login Successful! Welcome " + username);
                frame.dispose();
                showMainMenu();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Username or Password!");
            }
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            showMainMenu();
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginBtn);
        frame.add(backBtn);

        frame.setVisible(true);
    }
}
