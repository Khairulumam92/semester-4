
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PerbandinganList {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int jumlahElemen = 100_000;

        // Mengisi kedua list dengan bilangan bulat
        for (int i = 0; i < jumlahElemen; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Pengukuran waktu untuk operasi penyisipan di awal list
        long startTime = System.nanoTime();
        arrayList.add(0, -1); // Menyisipkan elemen di awal ArrayList
        long endTime = System.nanoTime();
        System.out.println("Waktu penyisipan di awal ArrayList: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.add(0, -1); // Menyisipkan elemen di awal LinkedList
        endTime = System.nanoTime();
        System.out.println("Waktu penyisipan di awal LinkedList: " + (endTime - startTime) + " ns");

        // Pengukuran waktu untuk operasi penghapusan di tengah list
        int tengah = jumlahElemen / 2;
        startTime = System.nanoTime();
        arrayList.remove(tengah); // Menghapus elemen di tengah ArrayList
        endTime = System.nanoTime();
        System.out.println("Waktu penghapusan di tengah ArrayList: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.remove(tengah); // Menghapus elemen di tengah LinkedList
        endTime = System.nanoTime();
        System.out.println("Waktu penghapusan di tengah LinkedList: " + (endTime - startTime) + " ns");

        // Pengukuran waktu untuk operasi akses elemen secara acak
        Random random = new Random();
        int indeksAcak = random.nextInt(jumlahElemen);
        startTime = System.nanoTime();
        int elemenArrayList = arrayList.get(indeksAcak); // Mengakses elemen di ArrayList
        endTime = System.nanoTime();
        System.out.println("Waktu akses acak di ArrayList: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        int elemenLinkedList = linkedList.get(indeksAcak); // Mengakses elemen di LinkedList
        endTime = System.nanoTime();
        System.out.println("Waktu akses acak di LinkedList: " + (endTime - startTime) + " ns");
    }
}
