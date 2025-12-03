package latihan;

import java.util.*;
import static latihan.bacaFile.loadFromFile;

public class TSPBruteForceUAS {

    static char[] vertices;
    static int[][] w;

    public static void main(String[] args) {

        // --- BACA FILE ---
        loadFromFile("graf.txt");  // data akan masuk ke vertices[] dan w[][]

        // Buat daftar permutasi dari 1..n-1 (karena start selalu index 0 = 'a')
        int[] arr = new int[vertices.length - 1];
        for (int i = 1; i < vertices.length; i++) arr[i - 1] = i;

        List<int[]> permutations = generatePermutations(arr);

        int bestWeight = Integer.MAX_VALUE;
        List<String> bestRoutes = new ArrayList<>();

        int routeNum = 1;
        for (int[] perm : permutations) {
            int total = 0;
            int prev = 0;

            System.out.print(routeNum + ". " + vertices[0]);
            for (int p : perm) {
                System.out.print(" - " + vertices[p]);
                total += w[prev][p];
                prev = p;
            }
            System.out.print(" - " + vertices[0]);

            total += w[prev][0];

            System.out.println("   | Bobot = " + total);

            if (total < bestWeight) {
                bestWeight = total;
                bestRoutes.clear();
                bestRoutes.add(buildRouteString(perm));
            } else if (total == bestWeight) {
                bestRoutes.add(buildRouteString(perm));
            }

            routeNum++;
        }

        System.out.println("\nRute terpendek:");
        for (String r : bestRoutes) System.out.println(r);

        System.out.println("Bobot minimum = " + bestWeight);
    }

    // ---------------------- PERMUTASI ------------------------
    static List<int[]> generatePermutations(int[] arr) {
        List<int[]> result = new ArrayList<>();
        permute(arr, 0, result);
        return result;
    }

    static void permute(int[] arr, int start, List<int[]> result) {
        if (start == arr.length) {
            result.add(arr.clone());
            return;
        }
        for (int i = start; i < arr.length; i++) {
            int t = arr[start]; arr[start] = arr[i]; arr[i] = t;
            permute(arr, start + 1, result);
            t = arr[start]; arr[start] = arr[i]; arr[i] = t;
        }
    }

    static String buildRouteString(int[] perm) {
        StringBuilder sb = new StringBuilder("" + vertices[0]);
        for (int p : perm) sb.append(" - ").append(vertices[p]);
        sb.append(" - ").append(vertices[0]);
        return sb.toString();
    }
}
