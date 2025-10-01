package latihan;
import java.util.ArrayList;
import java.util.HashMap;

public class MahasiswaHashMap {
    public static void main(String[] args) {
        //1. Menyimpan data mahasiswa
        HashMap<String, String> mahasiswa = new HashMap<>();
        mahasiswa.put("12345", "Arif");
        mahasiswa.put("67890", "Rini");
        System.out.println(mahasiswa);

        //2. Menyimpan nilai tugas Mahasiswa
        ArrayList<Double> nilai = new ArrayList<>();
        nilai.add(90.0);
        nilai.add(70.0);
        nilai.add(80.0);
        System.out.println(nilai);

        HashMap<String, ArrayList> nilai_tugas = new HashMap<>();
        nilai_tugas.put("12345", nilai);
        System.out.println(nilai_tugas);

        //3. Menghitung Rata-Rata
        ArrayList<Double> tes = new ArrayList<>();
        double jumlah = 0.0;
        double mean = 0.0;
         tes = nilai_tugas.get("12345");    
        for (int i = 0; i < tes.size(); i++) {
            jumlah+= tes.get(i);
        }
        mean = jumlah / tes.size();
        System.out.println(mean);

        //4. HashMap untuk menyimpan nilai uts terdiri dari nim (String) dan nilai_uts (Double).
        HashMap<String, Double> nilai_uts = new HashMap<>();
        nilai_uts.put("12345", 85.0);
        System.out.println("Nilai UTS: " + nilai_uts);

        //5. HashMap untuk menyimpan nilai uas terdiri dari nim (String) dan nilai_uas (Double).
        HashMap<String, Double> nilai_uas = new HashMap<>();
        nilai_uas.put("12345", 80.0);
        System.out.println("Nilai UAS: " + nilai_uas);

        //6. HashMap untuk menyimpan nilai natakuliah yang terdiri dari nim bertipe String
        // dan ArrayList bertipe Double. ArrayList ini berisi nilai rata_rata_tugas, nilai uts, dan
        // nilai uas.
        HashMap<String, ArrayList<Double>> nilai_akhir = new HashMap<>();
        ArrayList<Double> nilai_final = new ArrayList<>();
        nilai_final.add(mean);
        nilai_final.add(nilai_uts.get("12345"));
        nilai_final.add(nilai_uas.get("12345"));
        nilai_akhir.put("12345", nilai_final);
        System.out.println("Nilai Akhir: " + nilai_akhir);

        //7. Nilai Rata-Rata Akhir
        ArrayList<Double> nilaiakhir = new ArrayList<>();
        double total = 0.0;
        double rata_rata_akhir = 0.0;
        nilaiakhir = nilai_akhir.get("12345");
        for (int i = 0; i < nilaiakhir.size(); i++) {
            total+= nilaiakhir.get(i);
        }
        rata_rata_akhir = total / nilaiakhir.size();
        System.out.println("Rata-Rata Akhir: " + rata_rata_akhir);

    }
}
