
import java.util.Scanner;

public class ManageLibrary {

    public static void main(String[] args) {
        Library perpustakaan = new Library();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===================================================");
            System.out.println("=== Selamat datang di Pengelolaan Perpustakaan! ===");
            System.out.println("===================================================\n");
            System.out.println("1. Tambah Buku \n2. Lihat Daftar Buku \n3. Cari Buku \n4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("=== Tambah Buku ===");
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String penulis = scanner.nextLine();
                    perpustakaan.tambahBuku(judul, penulis);
                    break;
                case 2:
                    perpustakaan.lihatDaftarBuku();
                    break;
                case 3:
                    System.out.print("\nMasukkan judul buku yang ingin dicari: ");
                    String cariJudul = scanner.nextLine();
                    perpustakaan.cariBuku(cariJudul);
                    break;
                case 4:
                    System.out.println("\n=== Terima kasih telah menggunakan program ini! ===\n");
                    break;
                default:
                    System.out.println("\n=== Pilihan tidak valid. Silakan coba lagi. ===\n");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
