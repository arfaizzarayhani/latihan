package latihan;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        HashMap<String, String> studentMap = new HashMap<>();

        System.out.println("--- 1. Menambahkan Elemen (put) ---");
        studentMap.put("1801", "Ani Susanti");
        studentMap.put("1802", "Budi Darmawan");
        studentMap.put("1803", "Citra Dewi");
        studentMap.put("1804", "Deni Pratama");
        System.out.println("HashMap setelah penambahan: " + studentMap);

        System.out.println("\n--- 2. Mengambil Nilai (get) ---");
        String studentName = studentMap.get("1802");
        System.out.println("Nama mahasiswa dengan NIM 1802 adalah: "
                + studentName);

        System.out.println("\n--- 3. Mengubah Nilai (put/replace) ---");
        studentMap.put("1803", "Citra Kusuma"); // Nilai lama 'Citra Dewi' akan diganti
        System.out.println("HashMap setelah perubahan 1803: " + studentMap);

        System.out.println("\n--- 4. Menghapus Elemen (remove) ---");
        studentMap.remove("1804");
        System.out.println("HashMap setelah menghapus 1804: " + studentMap);

        System.out.println("\n--- 5. Pengecekan (contains) ---");
        boolean hasKey = studentMap.containsKey("1801");
        System.out.println("Apakah ada NIM 1801? " + hasKey);

        boolean hasValue = studentMap.containsValue("Budi Darmawan");
        System.out.println("Apakah ada nama Budi Darmawan? " + hasValue);

        System.out.println("\n--- 6. Iterasi (Perulangan) ---");
        for (Map.Entry<String, String> entry : studentMap.entrySet()) {
            System.out.println("NIM: " + entry.getKey() + ", Nama: "
                    + entry.getValue());
        }

        System.out.println("\n--- 7. Ukuran ---");
        System.out.println("Jumlah mahasiswa saat ini: "
                + studentMap.size());

        studentMap.clear();
        System.out.println("HashMap setelah clear: " + studentMap);
        System.out.println( "Apakah HashMap kosong?" + studentMap.isEmpty()
    

);
    }
}
