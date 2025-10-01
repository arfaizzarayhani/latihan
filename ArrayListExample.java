package latihan;
import java.util.ArrayList;

public class ArrayListExample 
{
    public static void main(String[] args) 
    {
        // 1. Deklarasi dan inisialisasi sebuah ArrayList
        // ArrayList ini dapat menyimpan elemen bertipe String
        ArrayList<String> fruits = new ArrayList<>();

        // 2. Menambahkan elemen ke ArrayList menggunakan method add()
        System.out.println("--- Menambahkan elemen ke ArrayList ---");
        fruits.add("Apel");      // Menambahkan di akhir
        fruits.add("Jeruk");     // Menambahkan di akhir
        fruits.add("Mangga");    // Menambahkan di akhir
        System.out.println("ArrayList saat ini: " + fruits);

        // 3. Menambahkan elemen di indeks tertentu
        fruits.add(1, "Semangka");
        System.out.println("ArrayList setelah menambahkan 'Semangka' di indeks 1: "
+ fruits);

        // 4. Mengambil elemen dari ArrayList menggunakan method get()
        System.out.println("\n--- Mengakses elemen ---");
        String firstFruit = fruits.get(0);
        System.out.println("Buah pertama: " + firstFruit);

        // 5. Mengubah elemen di indeks tertentu menggunakan method set()
        fruits.set(2, "Anggur");
        System.out.println("ArrayList setelah mengubah indeks 2 menjadi 'Anggur': "
+ fruits);

        // 6. Menghapus elemen dari ArrayList menggunakan method remove()
        fruits.remove("Jeruk");  // Menghapus berdasarkan nilai
        System.out.println("\n--- Menghapus elemen ---");
        System.out.println("ArrayList setelah menghapus 'Jeruk': " + fruits);
        
        fruits.remove(0);        // Menghapus berdasarkan indeks
        System.out.println("ArrayList setelah menghapus elemen di indeks 0: " +
fruits);

        // 7. Mengambil ukuran ArrayList menggunakan method size()
        int size = fruits.size();
        System.out.println("\n--- Informasi tambahan ---");
        System.out.println("Jumlah elemen dalam ArrayList: " + size);
        
        // 8. Mengecek apakah ArrayList kosong
        boolean isEmpty = fruits.isEmpty();
        System.out.println("Apakah ArrayList kosong? " + isEmpty);

        // 9. Membersihkan seluruh isi ArrayList
        fruits.clear();
        System.out.println("ArrayList setelah dibersihkan: " + fruits);
        System.out.println("Jumlah elemen setelah dibersihkan: " + fruits.size()); 
    } 
}
 