package latihan;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        // 1. Deklarasi dan inisialisasi Stack
        Stack<String> tumpukanBuku = new Stack<>();

        // 2. Menambahkan elemen ke stack menggunakan method push()
        System.out.println("--- Menambahkan Elemen ke Stack (Push) ---");
        tumpukanBuku.push("Buku A");
        tumpukanBuku.push("Buku B");
        tumpukanBuku.push("Buku C");
        System.out.println("Tumpukan saat ini: " + tumpukanBuku);

        // 3. Melihat elemen teratas tanpa menghapusnya menggunakan method peek()
        System.out.println("\n--- Melihat Elemen Teratas (Peek) ---");
        String bukuTeratas = tumpukanBuku.peek();
        System.out.println("Buku teratas: " + bukuTeratas);
        System.out.println("Tumpukan setelah peek: " + tumpukanBuku);
        // 4. Mengambil dan menghapus elemen teratas menggunakan method pop()
        System.out.println("\n--- Mengambil dan Menghapus Elemen (Pop) ---");
        String bukuDiambil = tumpukanBuku.pop();
        System.out.println("Buku yang diambil: " + bukuDiambil);
        System.out.println("Tumpukan setelah pop: " + tumpukanBuku);

        // 5. Mengambil dan menghapus elemen teratas yang tersisa
        System.out.println("Mengambil buku lagi: " + tumpukanBuku.pop());
        System.out.println("Mengambil buku lagi: " + tumpukanBuku.pop());
        System.out.println("Tumpukan setelah semua di-pop: " + tumpukanBuku);

        // 6. Mengecek apakah stack kosong menggunakan method empty()
        System.out.println("\n--- Mengecek Status Stack ---");
        boolean isKosong = tumpukanBuku.empty();
        System.out.println("Apakah tumpukan kosong? " + isKosong);

        // 7. Mencari posisi elemen dari atas stack menggunakan method search()
        tumpukanBuku.push("Buku X");
        tumpukanBuku.push("Buku Y");
        tumpukanBuku.push("Buku Z");

        System.out.println("\n--- Mencari Elemen (Search) ---");
        System.out.println("Tumpukan saat ini: " + tumpukanBuku);

        int posisi = tumpukanBuku.search("Buku X");
        System.out.println("Posisi 'Buku X' dari atas: " + posisi);
        // Posisi dihitung dari 1
    }
}
