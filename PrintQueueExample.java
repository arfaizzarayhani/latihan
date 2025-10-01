package latihan;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class PrintQueueExample 
{
    public static void main(String[] args) throws InterruptedException 
    {
        // Deklarasi Queue untuk menampung dokumen yang akan dicetak
        Queue<String> printQueue = new LinkedList<>();

        System.out.println("--- Sistem Antrean Pencetakan Dimulai ---");

        // 1. Pengguna mengirimkan dokumen untuk dicetak (menambahkan ke antrean)
        System.out.println("\nPengguna mengirimkan dokumen:");
        sendDocument("Dokumen A", printQueue);
        sendDocument("Laporan Keuangan", printQueue);
        sendDocument("Surat Penawaran", printQueue);

        System.out.println("\nAntrean saat ini: " + printQueue);

        // 2. Printer mulai memproses antrean
        System.out.println("\n--- Printer Mulai Bekerja ---");
        while (!printQueue.isEmpty()) 
        {
            processNextDocument(printQueue);
            // Memberi jeda 1 detik untuk mensimulasikan proses cetak
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("\n--- Semua dokumen telah dicetak. Antrean kosong. ---");
    }

    /**
     * Menambahkan dokumen ke antrean.
     */
    public static void sendDocument(String docName, Queue<String> queue) 
    {
        System.out.println(">> Mengirimkan: '" + docName + "'");
        queue.offer(docName);
    }

    /**
     * Memproses dokumen berikutnya dari antrean.
     */
    public static void processNextDocument(Queue<String> queue) 
    {
        String document = queue.poll();
        if (document != null) {
            System.out.println("<< Sedang Mencetak: '" + document + "'");
        }
    }
}
