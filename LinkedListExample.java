package latihan;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // 1. Deklarasi dan inisialisasi LinkedList
        // LinkedList ini akan menyimpan elemen bertipe String
        LinkedList<String> studentList = new LinkedList<>();

        // 2. Menambahkan elemen ke LinkedList
        System.out.println("--- Menambahkan Elemen ---");
        studentList.add("Dina");
        studentList.add("Andi");
        studentList.add("Budi");
        studentList.add("Citra");
        System.out.println("List saat ini: " + studentList);

        // Menambahkan elemen di awal dan akhir dengan method spesifik
        studentList.addFirst("Zaki");
        studentList.addLast("Maya");
        System.out.println("List setelah menambahkan di awal dan akhir: " + studentList);

        // 3. Mengakses elemen
        System.out.println("\n--- Mengakses Elemen ---");
        String firstStudent = studentList.getFirst();
        String lastStudent = studentList.getLast();
        System.out.println("Siswa pertama: " + firstStudent);
        System.out.println("Siswa terakhir: " + lastStudent);
        
        // Akses elemen di indeks tertentu (lambat)
        String thirdStudent = studentList.get(2);
        System.out.println("Siswa di indeks 2: " + thirdStudent);

        // 4. Menghapus elemen
        System.out.println("\n--- Menghapus Elemen ---"); 
        studentList.removeFirst();
        studentList.removeLast();
        studentList.remove("Andi");
        System.out.println("List setelah menghapus Zaki, Maya, dan Andi: "
+ studentList);
        
        // 5. Mengambil informasi dasar
        System.out.println("\n--- Informasi List ---");
        System.out.println("Ukuran List: " + studentList.size());
        System.out.println("Apakah List berisi 'Dina'? " + studentList.contains("Dina"));
        
        // 6. Menggunakan sebagai Deque (Double Ended Queue)
        System.out.println("\n--- Menggunakan sebagai Queue/Stack ---");
        // push() dan pop() untuk LIFO (Stack)
        studentList.push("Hana");
        System.out.println("List setelah push 'Hana': " + studentList);
        studentList.pop();
        System.out.println("List setelah pop: " + studentList);
        
        // offer() dan poll() untuk FIFO (Queue)
        studentList.offer("Putri");
        System.out.println("List setelah offer 'Putri': " + studentList);
        studentList.poll();
        System.out.println("List setelah poll: " + studentList);
        
        // 7. Membersihkan list
        studentList.clear();
        System.out.println("\n--- Membersihkan List ---");
        System.out.println("List setelah clear: " + studentList);
    }
} 