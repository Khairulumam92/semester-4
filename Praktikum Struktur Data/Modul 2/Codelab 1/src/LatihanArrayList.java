import java.util.ArrayList;

public class LatihanArrayList {
    public static void main(String[] args) {
        ArrayList<String> daftarBuah = new ArrayList<>();

        daftarBuah.add("ApeL");
        daftarBuah.add("Jeruk");
        daftarBuah.add("Mangga");
        daftarBuah.add("Semangka");

        System.out.println("Daftar Buah:");
        for (String buah : daftarBuah) {
            System.out.println(buah);
        }

        System.out.println("Elemen pada indeks 1: " + daftarBuah.get(1));

        daftarBuah.set(2, "Durian");

        System.out.println("Daftar Buah setelah perubahan:");
        for (String buah : daftarBuah) {
            System.out.println(buah);
        }

        daftarBuah.remove(3);

        System.out.println("Daftar Buah setelah penghapusan:");
        for (String buah : daftarBuah) {
            System.out.println(buah);
        }

        System.out.println("Jumlah elemen dalam ArrayList: " + daftarBuah.size());

        System.out.println("Apakah ArrayList kosong? " + daftarBuah.isEmpty());
        System.out.println("Apakah ArrayList berisi 'Jeruk'? " + daftarBuah.contains("Jeruk"));
        System.out.println("Apakah ArrayList berisi 'Pisang'? " + daftarBuah.contains("Pisang"));
    }
}