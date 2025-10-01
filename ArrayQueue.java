package latihan;
import java.util.NoSuchElementException;

public class ArrayQueue<E> 
{
    private Object[] data;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 5;

    public ArrayQueue() 
    {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayQueue(int capacity) 
    {
        this.data = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    } 

    /**
     * Menambahkan elemen ke belakang antrean.
     * @param element Elemen yang akan ditambahkan.
     * @return true jika berhasil, false jika antrean penuh.
     */
    public boolean offer(E element) 
    {
        if (isFull()) 
        {
            return false;
        }
        rear = (rear + 1) % data.length;
        data[rear] = element;
        size++;
        return true;
    }

    /**
     * Mengambil dan menghapus elemen terdepan dari antrean.
     * @return Elemen terdepan atau null jika antrean kosong.
     */
    @SuppressWarnings("unchecked")
    public E poll() 
    {
        if (isEmpty()) 
        {
            return null;
        }
        E element = (E) data[front];
        data[front] = null; // Membantu garbage collection
        front = (front + 1) % data.length;
        size--;
        return element;
    }

    /**
     * Mengintip elemen terdepan tanpa menghapusnya.
     * @return Elemen terdepan atau null jika antrean kosong.
     */
    @SuppressWarnings("unchecked")
    public E peek() 
    {
        if (isEmpty()) 
        {
            return null;
        }
        return (E) data[front];
    }
    
    public boolean isEmpty() 
    {
        return size == 0;
    }

    public boolean isFull() 
    {
        return size == data.length;
    }

    public int size() 
    {
        return size;
    }

    @Override
    public String toString() 
    { 
        if (isEmpty()) 
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) 
        {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) 
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) 
    {
        ArrayQueue<String> queue = new ArrayQueue<>();
        
        System.out.println("--- Percobaan Awal ---");
        System.out.println("Apakah antrean kosong? " + queue.isEmpty());

        // Menambahkan elemen
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        System.out.println("Antrean: " + queue);
        System.out.println("Ukuran antrean: " + queue.size());

        // Mengintip dan mengambil
        System.out.println("\n--- Mengambil Elemen ---");
        System.out.println("Elemen terdepan (peek): " + queue.peek());
        System.out.println("Elemen yang dilayani (poll): " + queue.poll());
        System.out.println("Antrean setelah poll: " + queue);
        
        // Menambahkan elemen baru (melingkar)
        System.out.println("\n--- Mengisi Antrean Hingga Penuh ---");
        queue.offer("D");
        queue.offer("E");
        queue.offer("F"); // Antrean sekarang penuh
        System.out.println("Antrean: " + queue);
        System.out.println("Apakah antrean penuh? " + queue.isFull());
        
        // Mencoba menambahkan lagi saat penuh
        System.out.println("Mencoba offer 'G': " + queue.offer("G"));
    }
} 