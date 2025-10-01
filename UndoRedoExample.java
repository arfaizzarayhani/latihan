package latihan;
import java.util.Stack;

public class UndoRedoExample 
{
    public static void main(String[] args) 
    {
        // Deklarasi Stack untuk menyimpan riwayat aksi
        Stack<String> historyStack = new Stack<>();
        
        System.out.println("--- Simulasi Aplikasi Editor ---");
        
        // 1. Pengguna melakukan beberapa aksi (push ke stack)
        System.out.println("\nPengguna melakukan aksi:");
        performAction("Mengetik 'Halo'", historyStack);
        performAction("Menyisipkan gambar", historyStack);
        performAction("Mengubah font", historyStack);
        performAction("Menghapus baris", historyStack);
        
        System.out.println("\nRiwayat Aksi Saat Ini: " + historyStack);
        
        // 2. Pengguna melakukan Undo (pop dari stack)
        System.out.println("\n--- Pengguna Melakukan UNDO ---");
        undoAction(historyStack);
        
        System.out.println("\n--- Pengguna Melakukan UNDO Lagi ---");
        undoAction(historyStack);
        
        System.out.println("\nRiwayat Aksi Saat Ini: " + historyStack);
        
        // 3. Mencoba Undo pada stack yang sudah kosong
        System.out.println("\n--- Mencoba UNDO pada Riwayat Kosong ---");
        undoAction(historyStack);
    }
    
    /**
     * Menambahkan aksi ke riwayat (push ke stack).
     */
    public static void performAction(String action, Stack<String> stack) 
    {
        System.out.println("Aksi: " + action);
        stack.push(action);
    }
    
    /**
     * Membatalkan aksi terakhir (pop dari stack).
     */
    public static void undoAction(Stack<String> stack) 
    {
        if (!stack.empty()) 
        {
            String lastAction = stack.pop();
            System.out.println("Membatalkan aksi: " + lastAction);
        } else {
            System.out.println("Tidak ada aksi untuk dibatalkan. Riwayat kosong.");
        }
    }
}
 