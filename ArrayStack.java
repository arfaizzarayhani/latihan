package latihan;
import java.util.EmptyStackException;

public class ArrayStack<E> 
{
    private Object[] data;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;
 
    public ArrayStack() 
    {
        this.data = new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }

    /**
     * Menambahkan elemen ke atas stack.
     * Jika array penuh, akan dibuat array baru yang lebih besar (seperti ArrayList).
     */
    public void push(E element) 
    {
        if (top == data.length - 1) 
        {
            resize();
        }
        data[++top] = element;
    }

    /**
     * Mengambil dan menghapus elemen teratas dari stack.
     * @throws EmptyStackException jika stack kosong.
     */
    @SuppressWarnings("unchecked")
    public E pop() 
    {
        if (empty()) 
        {
            throw new EmptyStackException();
        }
        E element = (E) data[top];
        data[top--] = null; // Menghapus referensi untuk garbage collection
        return element;
    }

    /**
     * Melihat elemen teratas tanpa menghapusnya.
     * @throws EmptyStackException jika stack kosong.
     */
    @SuppressWarnings("unchecked")
    public E peek() 
    {
        if (empty()) 
        {
            throw new EmptyStackException();
        }
        return (E) data[top];
    }

    /**
     * Mengembalikan true jika stack tidak memiliki elemen.
     */
    public boolean empty() 
    {
        return top == -1;
    }

    /**
     * Mengembalikan jumlah elemen dalam stack.
     */
    public int size() 
    {
        return top + 1;
    }

    /**
     * Metode internal untuk memperbesar ukuran array jika penuh. 
     */
    private void resize() 
    {
        int newCapacity = data.length * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
        System.out.println("Array diresize menjadi kapasitas: " + newCapacity);
    }
    
    @Override
    public String toString() 
    {
        if (empty()) 
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) 
        {
            sb.append(data[i]);
            if (i < top) 
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) 
    {
        ArrayStack<String> stack = new ArrayStack<>();
        
        System.out.println("Stack kosong? " + stack.empty());

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        
        System.out.println("Stack: " + stack);
        System.out.println("Elemen teratas: " + stack.peek());
        System.out.println("Ukuran stack: " + stack.size());

        System.out.println("Mengambil elemen: " + stack.pop());
        System.out.println("Stack setelah pop: " + stack);
        
        System.out.println("Mengambil elemen: " + stack.pop());
        System.out.println("Stack setelah pop: " + stack);
        
        System.out.println("Stack kosong? " + stack.empty());
    }
} 