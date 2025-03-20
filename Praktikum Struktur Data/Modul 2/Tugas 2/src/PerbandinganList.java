
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PerbandinganList {

    public static void main(String[] args) {
        // Judul Program
        System.out.println("==============================================");
        System.out.println("  EKSPERIMEN PERBANDINGAN ARRAYLIST vs LINKEDLIST  ");
        System.out.println("==============================================");
        System.out.println();

        // Inisialisasi ArrayList dan LinkedList dengan 100.000 elemen
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int jumlahElemen = 100_000;

        // Mengisi kedua list dengan bilangan bulat
        for (int i = 0; i < jumlahElemen; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Garis pemisah
        System.out.println("--------------------------------------------------");
        System.out.println(" 1. Penyisipan Elemen di Awal List");
        System.out.println("--------------------------------------------------");

        // Pengukuran waktu untuk operasi penyisipan di awal list
        long startTime = System.nanoTime();
        arrayList.add(0, -1); // Menyisipkan elemen di awal ArrayList
        long endTime = System.nanoTime();
        System.out.println("ArrayList  : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.add(0, -1); // Menyisipkan elemen di awal LinkedList
        endTime = System.nanoTime();
        System.out.println("LinkedList : " + (endTime - startTime) + " ns");
        System.out.println();

        // Garis pemisah
        System.out.println("--------------------------------------------------");
        System.out.println(" 2. Penghapusan Elemen di Tengah List");
        System.out.println("--------------------------------------------------");

        // Pengukuran waktu untuk operasi penghapusan di tengah list
        int tengah = jumlahElemen / 2;
        startTime = System.nanoTime();
        arrayList.remove(tengah); // Menghapus elemen di tengah ArrayList
        endTime = System.nanoTime();
        System.out.println("ArrayList  : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.remove(tengah); // Menghapus elemen di tengah LinkedList
        endTime = System.nanoTime();
        System.out.println("LinkedList : " + (endTime - startTime) + " ns");
        System.out.println();

        // Garis pemisah
        System.out.println("--------------------------------------------------");
        System.out.println(" 3. Akses Elemen Secara Acak");
        System.out.println("--------------------------------------------------");

        // Pengukuran waktu untuk operasi akses elemen secara acak
        Random random = new Random();
        int indeksAcak = random.nextInt(jumlahElemen);
        startTime = System.nanoTime();
        int elemenArrayList = arrayList.get(indeksAcak); // Mengakses elemen di ArrayList
        endTime = System.nanoTime();
        System.out.println("ArrayList  : " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        int elemenLinkedList = linkedList.get(indeksAcak); // Mengakses elemen di LinkedList
        endTime = System.nanoTime();
        System.out.println("LinkedList : " + (endTime - startTime) + " ns");
        System.out.println();

        System.out.println("--------------------------------------------------");
        System.out.println(" ANALISIS HASIL ");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Penyisipan di Awal:");
        System.out.println("   - ArrayList  : Lambat (harus menggeser elemen).");
        System.out.println("   - LinkedList : Cepat (hanya ubah referensi node).");
        System.out.println();
        System.out.println("2. Penghapusan di Tengah:");
        System.out.println("   - ArrayList  : Lambat (harus menggeser elemen).");
        System.out.println("   - LinkedList : Cepat (hanya ubah referensi node).");
        System.out.println();
        System.out.println("3. Akses Elemen Secara Acak:");
        System.out.println("   - ArrayList  : Cepat (akses langsung dengan indeks).");
        System.out.println("   - LinkedList : Lambat (harus traversal dari awal/akhir).");
        System.out.println("--------------------------------------------------");
    }
}
