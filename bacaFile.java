package latihan;

import java.io.*;

public class bacaFile {

    public static void loadFromFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/latihan/" + filename));

            int n = Integer.parseInt(br.readLine().trim());

            String[] v = br.readLine().trim().split(" ");
            TSPBruteForceUAS.vertices = new char[n];
            for (int i = 0; i < n; i++) TSPBruteForceUAS.vertices[i] = v[i].charAt(0);

            TSPBruteForceUAS.w = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    TSPBruteForceUAS.w[i][j] = Integer.parseInt(row[j]);
                }
            }

            br.close();
            System.out.println("File berhasil dibaca!\n");

        } catch (Exception e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }
    }
}
