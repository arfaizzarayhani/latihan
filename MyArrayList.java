package latihan;
import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> 
{
    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() 
    {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Menambahkan elemen ke akhir list.
     */
    public void add(E element) 
    {
        if (size == data.length) 
        {
            resize();
        }
        data[size++] = element;
    }

    /**
     * Menambahkan elemen di posisi tertentu.
     */
    public void add(int index, E element) 
    {
        Objects.checkIndex(index, size + 1); // Memastikan indeks valid

        if (size == data.length) 
        {
            resize();
        }
        
        // Geser elemen-elemen ke kanan
        for (int i = size; i > index; i--) 
        {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    /**
     * Mengambil elemen pada posisi tertentu.
     */
    @SuppressWarnings("unchecked")
    public E get(int index) 
    {
        Objects.checkIndex(index, size); // Memastikan indeks valid
        return (E) data[index];
    }
     /**
     * Menghapus elemen pada posisi tertentu.
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) 
    {
        Objects.checkIndex(index, size); // Memastikan indeks valid
        
        E removedElement = (E) data[index];
        
        // Geser elemen-elemen ke kiri
        for (int i = index; i < size - 1; i++) 
        {
            data[i] = data[i + 1];
        }
        data[size - 1] = null; // Membantu garbage collection
        size--;
        
        return removedElement;
    }

    /**
     * Mengembalikan jumlah elemen dalam list.
     */
    public int size() 
    {
        return size;
    }

    /**
     * Memperbesar ukuran array internal.
     */
    private void resize() 
    {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
        System.out.println("Array diresize menjadi kapasitas: " +
newCapacity);
    }
    
    @Override
    public String toString() 
    {
        if (size == 0) 
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) 
        {
            sb.append(data[i]);
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
        MyArrayList<String> myStringList = new MyArrayList<>();
        System.out.println("Ukuran awal: " + myStringList.size());
        
        myStringList.add("Halo");
        myStringList.add("Dunia");
        myStringList.add("Java");
        
        System.out.println("List saat ini: " + myStringList);
        System.out.println("Ukuran setelah penambahan: " +
myStringList.size());
        System.out.println("Elemen pada indeks 1: " + myStringList.get(1));
        
        myStringList.add(1, "Baru"); // Menambahkan di tengah
        System.out.println("List setelah sisip di indeks 1: " +
myStringList);

        myStringList.remove(2); // Menghapus di tengah
        System.out.println("List setelah hapus elemen 'Dunia': " +
myStringList);
        
        // Menambahkan elemen sampai resize terjadi
        for (int i = 0; i < 8; i++) 
        {
            myStringList.add("Elemen-" + i);
        }
        System.out.println("List setelah banyak penambahan: " +
myStringList);
    }
} 