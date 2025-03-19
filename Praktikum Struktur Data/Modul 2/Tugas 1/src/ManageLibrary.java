
import java.util.Scanner;

public class ManageLibrary {

    public static void main(String[] args) {
        Library perpustakaan = new Library();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Selamat datang di Pengelolaan Perpustakaan!");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
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
                    System.out.print("Masukkan judul buku yang ingin dicari: ");
                    String cariJudul = scanner.nextLine();
                    perpustakaan.cariBuku(cariJudul);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
