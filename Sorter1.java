package latihan;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorter 
{ 
    private SortStrategy strategy;

    // Konstruktor: menerima dan menetapkan strategi
    public Sorter(SortStrategy strategy) 
    {
        this.strategy = strategy;
    }

    // Setter: memungkinkan penggantian strategi saat runtime
    public void setStrategy(SortStrategy strategy) 
    {
        this.strategy = strategy;
    }

    // Metode untuk menjalankan sorting menggunakan strategi saat ini
    public void executeSort(List<Integer> data) 
    {
        long startTime = System.nanoTime();
        
        System.out.println("----------------------------------------");
        System.out.println("Menggunakan Algoritma: " + strategy.getName());
        System.out.println("Data Awal: " + data);
        
        // Panggil metode sort dari strategi yang aktif
        strategy.sort(data);
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; 
  // dalam milidetik

        System.out.println("Data Terurut: " + data);
        System.out.println("Waktu Eksekusi: " + duration + " ms");
        System.out.println("----------------------------------------");
    }
    
    

    public static void main(String[] args) 
    {
        // Contoh data acak
        List<Integer> initialData = new ArrayList<>(Arrays.asList(50, 10, 
          90, 30, 70, 40));
        
        // 1. Menggunakan Bubble Sort
        Sorter sorter = new Sorter(new BubbleSort());
        sorter.executeSort(new ArrayList<>(initialData)); 
  // Kirim salinan data

        // 2. Mengganti Strategy tanpa mengubah kode inti Sorter
        // Anda hanya perlu membuat objek QuickSort dan memberikannya ke 
  // Sorter
        sorter.setStrategy(new QuickSort());
        sorter.executeSort(new ArrayList<>(initialData)); 
  // Kirim salinan data
    }
}
