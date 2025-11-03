package latihan;

import javax.swing.*;

public class LoginAppGUI {
    private static final UserManager userManager = new UserManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login System");
        frame.setSize(400, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Label & input username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 250, 25);
        panel.add(userText);

        // Label & input password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 60, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 60, 250, 25);
        panel.add(passwordText);

        // Tombol Login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 100, 80, 25);
        panel.add(loginButton);

        // Tombol Register
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 100, 100, 25);
        panel.add(registerButton);

        // Tombol Exit
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(210, 100, 80, 25);
        panel.add(exitButton);

        // Label status
        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(10, 140, 350, 25);
        panel.add(statusLabel);

        // === Event Handling ===

        // Login button
        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Field tidak boleh kosong!");
                return;
            }

            if (userManager.validateLogin(username, password)) {
                UserInfo user = userManager.getUser(username);
                statusLabel.setText("Login sukses! Selamat datang, " + user.getId());
            } else {
                statusLabel.setText("Login gagal. Periksa username/password.");
            }
        });

        // Register button
        registerButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Isi username dan password dulu!");
                return;
            }
            userManager.registerUser(username, password);
            statusLabel.setText("User baru berhasil dibuat: " + username);
        });

        // Exit button
        exitButton.addActionListener(e -> {
            frame.dispose();
        });

        frame.setVisible(true);
    }
}