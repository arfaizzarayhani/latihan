package latihan;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class LoginAppGUI {

    private static final UserManager userManager = new UserManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login System");
        // Pack to fit components and center on screen; allow resizing
        frame.pack();
        frame.setMinimumSize(new Dimension(400, 200));
        frame.setLocationRelativeTo(null);
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        buttonPanel.setBounds(0, 100, 400, 40);
        panel.add(buttonPanel);
        // === Event Handling ===

        // Tekan Enter di username -> lanjut ke password
        userText.addActionListener(e -> passwordText.requestFocusInWindow());

        // Tekan Enter di password -> klik tombol Login
        passwordText.addActionListener(e -> loginButton.doClick());

        // Login button
        loginButton.addActionListener(e -> {
            String username = userText.getText();
            char[] password = passwordText.getPassword();
            if (username.isEmpty() || password.length == 0) {
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
            char[] pwd = passwordText.getPassword();
            try {
                if (username.isEmpty() || pwd.length == 0) {
                    statusLabel.setText("Isi username dan password dulu!");
                    return;
                }
                // convert to String only when needed, then clear
                userManager.registerUser(username, new String(pwd));
                statusLabel.setText("User baru berhasil dibuat: " + username);
            } finally {
                Arrays.fill(pwd, '\0');
            }
        });

        // Exit button
        exitButton.addActionListener(e -> {
            frame.dispose();
        });

        frame.setVisible(true);
    }
}
