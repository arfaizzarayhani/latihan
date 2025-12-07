package latihan;

import java.util.Scanner;
public class LoginApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager manager = new UserManager();

        while (true) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // bersihkan newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String usernameLogin = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String passwordLogin = scanner.nextLine();
                    manager.loginUser(usernameLogin, passwordLogin);
                    break;

                case 2:
                    System.out.print("Masukkan username baru: ");
                    String usernameBaru = scanner.nextLine();
                    System.out.print("Masukkan password baru: ");
                    String passwordBaru = scanner.nextLine();
                    manager.registerUser(usernameBaru, passwordBaru);
                    break;

                case 3:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
