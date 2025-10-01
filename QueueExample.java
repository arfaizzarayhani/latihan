package latihan;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample 
{
    public static void main(String[] args) 
    {
        // 1. Deklarasi dan inisialisasi Queue menggunakan LinkedList
        Queue<String> antreanPelanggan = new LinkedList<>();

// 2. Menambahkan elemen ke antrean (belakang) menggunakan method   
// offer()
        System.out.println("--- Menambahkan Elemen ke Queue (Offer) ---");
        antreanPelanggan.offer("Pelanggan A");
        antreanPelanggan.offer("Pelanggan B");
        antreanPelanggan.offer("Pelanggan C");
        System.out.println("Antrean saat ini: " + antreanPelanggan);

        // 3. Melihat elemen terdepan tanpa menghapusnya menggunakan method 
  // peek()
        System.out.println("\n--- Melihat Elemen Terdepan (Peek) ---");
        String pelangganTerdepan = antreanPelanggan.peek();
        System.out.println("Pelanggan terdepan: " + pelangganTerdepan);
        System.out.println("Antrean setelah peek: " + antreanPelanggan);

        // 4. Mengambil dan menghapus elemen terdepan menggunakan method 
  // poll()
        System.out.println("\n--- Mengambil dan Menghapus Elemen (Poll) ---");
        String pelangganDilayani = antreanPelanggan.poll();
        System.out.println("Pelanggan yang dilayani: " + pelangganDilayani);
        System.out.println("Antrean setelah poll: " + antreanPelanggan);

        // 5. Mengambil dan menghapus elemen yang tersisa
        System.out.println("Melayani pelanggan lagi: " + antreanPelanggan.poll());
        System.out.println("Antrean setelah semua di-poll: " + antreanPelanggan);

        // 6. Mengecek apakah antrean kosong menggunakan method isEmpty()
        System.out.println("\n--- Mengecek Status Queue ---");
        boolean isKosong = antreanPelanggan.isEmpty(); 
        System.out.println("Apakah antrean kosong? " + isKosong);
        
        // Menambahkan elemen lagi untuk percobaan selanjutnya
        antreanPelanggan.offer("Pelanggan X");
        antreanPelanggan.offer("Pelanggan Y");
        antreanPelanggan.offer("Pelanggan Z");
        
        System.out.println("Antrean saat ini: " + antreanPelanggan);
        
        // 7. Menggunakan method remove()
        // remove() mirip dengan poll() tetapi akan melempar 
  // NoSuchElementException jika antrean kosong
        System.out.println("Melayani pelanggan dengan remove(): " + 
    antreanPelanggan.remove());
        System.out.println("Antrean setelah remove(): " + 
    antreanPelanggan);
    }
} 