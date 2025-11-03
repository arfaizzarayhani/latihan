package latihan;

import java.util.*;
import java.io.*;

public class UserManager {
    private final Map<String, UserInfo> userDatabase;
    private static final String FILE_PATH = "users.txt";

    public UserManager() {
        userDatabase = new HashMap<>();
        loadUsersFromFile();
    }

    // Generate ID unik pakai UUID
    private String generateID() {
        return "USR-" + UUID.randomUUID().toString().substring(0, 8);
    }

    // Registrasi user baru + simpan ke file
    public void registerUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            System.out.println("Username sudah terdaftar. Silakan coba lagi.");
        } else {
            String id = generateID();
            UserInfo newUser = new UserInfo(id, username, password);
            userDatabase.put(username, newUser);
            saveUserToFile(newUser);
            System.out.println("Registrasi berhasil untuk user: " + username + " (ID: " + id + ")");
        }
    }

    // Login user
    public void loginUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            UserInfo user = userDatabase.get(username);
            if (user.getPassword().equals(password)) {
                System.out.println("Login berhasil! Selamat datang, " + user.getId());
            } else {
                System.out.println("Password salah. Silakan coba lagi.");
            }
        } else {
            System.out.println("Username tidak ditemukan. Silakan registrasi terlebih dahulu.");
        }
    }
    private void saveUserToFile(UserInfo user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(user.getId() + "," + user.getUsername() + "," + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data user ke file: " + e.getMessage());
        }
    }

    // Muat semua user dari file ke dalam HashMap
    private void loadUsersFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return; // kalau belum ada file, yaudah

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String id = data[0];
                    String username = data[1];
                    String password = data[2];
                    userDatabase.put(username, new UserInfo(id, username, password));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat data user dari file: " + e.getMessage());
        }
    }

    boolean validateLogin(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    UserInfo getUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}