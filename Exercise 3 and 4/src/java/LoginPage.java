import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {

    // Declare components
    private JLabel userLabel, passLabel, messageLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton, clearButton;

    // Constructor to set up the GUI
    public LoginPage() {
        // Set up the JFrame
        setTitle("Login Page");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Initialize components
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        messageLabel = new JLabel();

        userText = new JTextField();
        passText = new JPasswordField();

        loginButton = new JButton("Login");
        clearButton = new JButton("Clear");

        // Add action listeners for buttons
        loginButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to the JFrame
        add(userLabel);
        add(userText);
        add(passLabel);
        add(passText);
        add(loginButton);
        add(clearButton);
        add(messageLabel);

        // Set visibility
        setVisible(true);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = new String(passText.getPassword());

        // Hardcoded credentials
        String correctUsername = "admin";
        String correctPassword = "1234";

        if (e.getSource() == loginButton) {
            // Validate username and password
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                messageLabel.setText("Login Successful!");
                messageLabel.setForeground(Color.GREEN);
            } else {
                messageLabel.setText("Invalid credentials!");
                messageLabel.setForeground(Color.RED);
            }
        } else if (e.getSource() == clearButton) {
            // Clear input fields
            userText.setText("");
            passText.setText("");
            messageLabel.setText("");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new LoginPage();
    }
}
