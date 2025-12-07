package latihan;

import java.util.*;
import static latihan.bacaFile.loadFromFile;

public class TSPBruteForceUAS {

    static char[] vertices;
    static int[][] w;

    public static void main(String[] args) {

        loadFromFile("graf.txt");   // baca data graf

        // Buat array indeks simpul kecuali simpul awal (0)
        int n = vertices.length;
        int[] arr = new int[n - 1];
        for (int i = 1; i < n; i++) arr[i - 1] = i;

        List<int[]> permutations = generatePermutations(arr);

        long start = System.nanoTime();

        int bestWeight = Integer.MAX_VALUE;
        List<String> bestRoutes = new ArrayList<>();

        int count = 1;
        for (int[] perm : permutations) {

            int total = hitungBobot(perm);

            // Cetak rute
            System.out.printf("%d. %s   | Bobot = %d%n", 
                count, buildRouteString(perm), total);

            // Simpan rute terbaik
            if (total < bestWeight) {
                bestWeight = total;
                bestRoutes.clear();
                bestRoutes.add(buildRouteString(perm));
            } else if (total == bestWeight) {
                bestRoutes.add(buildRouteString(perm));
            }

            count++;
        }

        // Output akhir
        System.out.println("\nRute terpendek:");
        bestRoutes.forEach(System.out::println);

        System.out.println("Bobot minimum = " + bestWeight);

        long end = System.nanoTime();
        System.out.printf("Waktu pencarian: %.3f ms%n", 
                          (end - start) / 1_000_000.0);
    }
    static int hitungBobot(int[] perm) {
        int total = 0, prev = 0; // mulai dari simpul 0

        for (int p : perm) {
            total += w[prev][p];
            prev = p;
        }
        total += w[prev][0];   // kembali ke awal
        return total;
    }
    static List<int[]> generatePermutations(int[] arr) {
        List<int[]> list = new ArrayList<>();
        permute(arr, 0, list);
        return list;
    }
    static void permute(int[] arr, int start, List<int[]> result) {
        if (start == arr.length) {
            result.add(arr.clone());
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permute(arr, start + 1, result);
            swap(arr, start, i);
        }
    }
    static void swap(int[] a, int i, int j) {
        int t = a[i]; 
        a[i] = a[j]; 
        a[j] = t;
    }
    static String buildRouteString(int[] perm) {
        StringBuilder sb = new StringBuilder();
        sb.append(vertices[0]);

        for (int p : perm) 
            sb.append(" - ").append(vertices[p]);

        sb.append(" - ").append(vertices[0]);
        return sb.toString();
    }
}
