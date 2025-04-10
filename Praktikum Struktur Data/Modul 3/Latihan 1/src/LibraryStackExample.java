
import java.util.Stack;  // Mengimpor kelas Stack dari package java.util untuk menggunakan struktur data stack.

public class LibraryStackExample {

    public static void main(String[] args) {
        // Membuat objek stack bernama myStack yang menyimpan elemen bertipe String.
        Stack<String> myStack = new Stack<>();

        // Mengecek apakah stack kosong (awalnya kosong, sehingga output: true).
        System.out.println(myStack.isEmpty());

        // Menambahkan elemen ke dalam stack menggunakan metode push().
        myStack.push("Kucing");
        myStack.push("Burning");
        myStack.push("Kelinci");
        myStack.push("Ikan");
        myStack.push("Gajah");

        // Mengecek kembali apakah stack kosong (kini sudah terisi, output: false).
        System.out.println(myStack.isEmpty());

        // Mengambil elemen teratas stack tanpa menghapusnya (output: "Gajah").
        System.out.println("Peek: " + myStack.peek());

        // Menampilkan seluruh isi stack (output: [Kucing, Burning, Kelinci, Ikan, Gajah]).
        System.out.println("Contents: " + myStack);

        // Menghapus dua elemen teratas stack (Gajah dan Ikan dihapus).
        myStack.pop();
        myStack.pop();

        // Menampilkan isi stack setelah dua pop() (output: [Kucing, Burning, Kelinci]).
        System.out.println("Contents after pop: " + myStack);

        // Mencari posisi elemen "Kucing" dalam stack (indeks dimulai dari 1, output: 3).
        System.out.println("Position of 'Kucing': " + myStack.search("Kucing"));
    }
}
