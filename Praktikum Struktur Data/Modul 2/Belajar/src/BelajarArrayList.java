import java.util.ArrayList;

public class BelajarArrayList {
    public static void main(String[] args) throws Exception {
        ArrayList<String> namaHewan = new ArrayList<>();

        namaHewan.add("1. Kucing");
        namaHewan.add("2. Anjing");
        namaHewan.add("3. Kelinci");
        namaHewan.add("4. Hamster");

        System.out.println("=== Daftar Nama Hewan ===");
        for (String hewan : namaHewan) {
            System.out.println(hewan);
        }

        System.out.println("Elemen pada indeks 1: " + namaHewan.get(1));
    }
}
