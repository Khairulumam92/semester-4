import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Pencarian Buku ===");
            System.out.print("Masukkan judul buku: ");
            String judul = scanner.nextLine();

            System.out.print("Masukkan nama pengarang: ");
            String pengarang = scanner.nextLine();

            System.out.print("Masukkan harga: ");
            double harga = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            System.out.println("Pilih kategori buku: ");
            for (Kategori kategori : Kategori.values()) {
                System.out.println(kategori);
            }
            System.out.print("Masukkan kategori: ");
            Kategori kategori = Kategori.valueOf(scanner.nextLine().toUpperCase());

            Buku<String, String> buku = new Buku<>(judul, pengarang, harga, kategori);
            buku.displayInfo();
        }
    }
}
