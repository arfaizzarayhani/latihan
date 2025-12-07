package latihan;

import java.awt.*;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LoginAppGUI1{
    private static final UserManager userManager = new UserManager();
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored){}
        SwingUtilities.invokeLater(LoginAppGUI1::createAndShowGUI);
    }
    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Login System");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400, 220);
       frame.setLayout(null);
       frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);

        // Label & input username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(120, 30, 220, 25);
        panel.add(userText);

        // Label & input password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(120, 70, 220, 25);
        panel.add(passwordText);

        // Tombol Login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(30, 120, 80, 25);
        panel.add(loginButton);

        // Tombol Register
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(130, 120, 100, 25);
        panel.add(registerButton);

        // Tombol Exit
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(250, 120, 80, 25);
        panel.add(exitButton);

        // Label status
        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(10, 155, 360, 25);
        panel.add(statusLabel);

        userText.addActionListener(e -> passwordText.requestFocusInWindow());
        passwordText.addActionListener(e -> loginButton.doClick());

        loginButton.addActionListener(e -> {
            String username = userText.getText().trim();
            char[] password = passwordText.getPassword();

            if (username.isEmpty() || password.length == 0) {
                statusLabel.setText("Field tidak boleh kosong!");
                return;
            }

            if (userManager.validateLogin(username, password)) {
                UserInfo user = userManager.getUser(username);
                Arrays.fill(password, '\0'); // clear password
                frame.dispose(); // tutup jendela login
                showWelcomeFrame(user); // buka jendela baru
            } else {
                statusLabel.setText("Login gagal. Periksa username/password.");
            }
        });
        // Tombol Register
        registerButton.addActionListener(e -> {
            String username = userText.getText().trim();
            char[] pwd = passwordText.getPassword();

            if (username.isEmpty() || pwd.length == 0) {
                statusLabel.setText("Isi username dan password dulu!");
                return;
            }

            try {
                userManager.registerUser(username, new String(pwd));
                statusLabel.setText("User baru berhasil dibuat: " + username);
            } finally {
                Arrays.fill(pwd, '\0');
            }
        });

        // Tombol Exit
        exitButton.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    // === JENDELA SELAMAT DATANG ===
    private static void showWelcomeFrame(UserInfo user) {
        JFrame welcomeFrame = new JFrame("Selamat Datang");
        welcomeFrame.setSize(350, 200);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel welcomeLabel = new JLabel(
                "<html><center>Login sukses!<br>Selamat datang, <b>" + user.getUsername() +
                        "</b><br>ID Anda: " + user.getId() + "</center></html>",SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(welcomeLabel, BorderLayout.CENTER);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            welcomeFrame.dispose();
            createAndShowGUI(); // kembali ke login
        });
        panel.add(logoutButton, BorderLayout.SOUTH);

        welcomeFrame.add(panel);
        welcomeFrame.setVisible(true);
    }
}