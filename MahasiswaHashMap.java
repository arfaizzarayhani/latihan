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
        HashMap<String, Double> rata_rata = new HashMap<>();
        for (String nim : nilai_tugas.keySet()) {
           ArrayList<Double> list_nilai = nilai_tugas.get(nim);
           double total = 0;
           for (double n : list_nilai){
            total +=n;
           }
           double rata = total / list_nilai.size();
           rata_rata.put(nim, rata);
        }
        System.out.println(rata_rata);
    }
}
