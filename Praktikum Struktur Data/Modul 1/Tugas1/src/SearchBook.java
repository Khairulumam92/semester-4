import java.util.Scanner;

public class SearchBook {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Pencarian Buku ===");
            System.out.print("Masukkan judul buku: ");
            String judul = scanner.nextLine();

            System.out.print("Masukkan nama pengarang: ");
            String pengarang = scanner.nextLine();

            System.out.print("Masukkan harga: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("===============");
            System.out.println("Pilih kategori buku:");
            System.out.println("0. NOVEL\n1. BIOGRAFI\n2. TEKNOLOGI\n3. ANAK");

            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            Kategori kategori;

            switch (pilihan) {
                case 0:
                    kategori = Kategori.NOVEL;
                    break;
                case 1:
                    kategori = Kategori.BIOGRAFI;
                    break;
                case 2:
                    kategori = Kategori.TEKNOLOGI;
                    break;
                case 3:
                    kategori = Kategori.ANAK;
                    break;
                default:
                    throw new IllegalArgumentException("Pilihan kategori tidak valid");
            }

            Buku<String, String> buku = new Buku<>(judul, pengarang, harga, kategori);

            System.out.println("=== Informasi Buku ===");
            buku.displayInfo();
            System.out.println("===============");
        }
    }
}
