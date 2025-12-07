package latihan;

public class MainBruteForceExample {
    public static void main(String[] args) {
        BruteForceExample brute = new BruteForceExample();
        bruteForceWrapper(brute);
    }

    public static void bruteForceWrapper(BruteForceExample brute) {
        String attempt = "";
        long start = System.currentTimeMillis();

        while (true) {
            attempt = brute.toString();

            if (attempt.equals(BruteForceExample.password)) {
                long end = System.currentTimeMillis();
                System.out.println("Password: " + attempt);
                System.out.println("Total time to crack: " + ((end - start) / 1000) + " seconds.");
                break;
            }

            System.out.println("Tried: " + attempt);
            brute.increment();
        }
    }
}
