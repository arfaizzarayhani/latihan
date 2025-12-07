package latihan;

import java.util.Arrays;

public class BruteForceExample {

    public static String password = "NADIA";
    public static char[] charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static char[] currentGuess;

    public BruteForceExample() {
        currentGuess = new char[password.length()];
        Arrays.fill(currentGuess, charset[0]);
    }

    public void increment() {
        int index = currentGuess.length - 1;

        while (index >= 0) {
            if (currentGuess[index] == charset[charset.length - 1]) {
                currentGuess[index] = charset[0];
                index--;
            } else {
                int pos = Arrays.binarySearch(charset, currentGuess[index]);
                currentGuess[index] = charset[pos + 1];
                return;
            }
        }
    }

    @Override
    public String toString() {
        return String.valueOf(currentGuess);
    }

    public static void bruteForce() {
        BruteForceExample b = new BruteForceExample();
        String attempt;
        long start = System.currentTimeMillis();

        while (true) {
            attempt = b.toString();

            if (attempt.equals(password)) {
                long end = System.currentTimeMillis();
                System.out.println("Password: " + attempt);
                System.out.println("Total time to crack: " + (end - start) + " ms");
                break;
            }

            System.out.println("Tried: " + attempt);
            b.increment();
        }
    }

    public static void main(String[] args) {
        bruteForce();
    }
}
