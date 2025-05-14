
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class SistemInventarisTokoBuku {

    private static Map<String, Integer> inventaris = new HashMap<>();
    private static Map<String, Double> hargaBuku = new HashMap<>();
    private static Map<String, String> penulisBuku = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inisialisasiDataBuku();

        System.out.println("Selamat Datang di Sistem Inventaris Toko Buku\n");

        boolean isRunning = true;
        while (isRunning) {
            tampilkanMenu();
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline

                switch (pilihan) {
                    case 1:
                        tambahBukuBaru();
                        break;
                    case 2:
                        lihatDaftarBuku();
                        break;
                    case 3:
                        cariBuku();
                        break;
                    case 4:
                        tambahStokBuku();
                        break;
                    case 5:
                        hapusBuku();
                        break;
                    case 6:
                        perbaruiHargaBuku();
                        break;
                    case 7:
                        perbaruiPenulisBuku();
                        break;
                    case 8:
                        System.out.println("Terima kasih telah menggunakan sistem inventaris!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka antara 1-8.");
                scanner.nextLine(); // Membersihkan input yang tidak valid
            }
        }
    }

    private static void inisialisasiDataBuku() {
        inventaris.put("Laskar Pelangi", 50);
        hargaBuku.put("Laskar Pelangi", 85000.0);
        penulisBuku.put("Laskar Pelangi", "Andrea Hirata");

        inventaris.put("Bumi Manusia", 30);
        hargaBuku.put("Bumi Manusia", 95000.0);
        penulisBuku.put("Bumi Manusia", "Pramoedya Ananta");

        inventaris.put("Harry Potter dan Batu Bertuah", 100);
        hargaBuku.put("Harry Potter dan Batu Bertuah", 120000.0);
        penulisBuku.put("Harry Potter dan Batu Bertuah", "J.K. Rowling");

        inventaris.put("The Hobbit", 40);
        hargaBuku.put("The Hobbit", 110000.0);
        penulisBuku.put("The Hobbit", "J.R.R. Tolkien");

        inventaris.put("Dilan 1990", 60);
        hargaBuku.put("Dilan 1990", 75000.0);
        penulisBuku.put("Dilan 1990", "Pidi Baiq");
    }

    private static void tampilkanMenu() {
        System.out.println("\nPilih Menu:");
        System.out.println("1. Tambah Buku Baru");
        System.out.println("2. Lihat Daftar Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Tambah Stok Buku");
        System.out.println("5. Hapus Buku");
        System.out.println("6. Perbarui Harga Buku");
        System.out.println("7. Perbarui Penulis Buku");
        System.out.println("8. Keluar");
        System.out.print("\nPilihan Anda: ");
    }

    private static void tambahBukuBaru() {
        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();

        if (inventaris.containsKey(judul)) {
            System.out.println("Buku sudah ada dalam inventaris!");
            return;
        }

        System.out.print("Masukkan Nama Penulis: ");
        String penulis = scanner.nextLine();

        int stok = getValidIntegerInput("Masukkan Jumlah Stok: ");
        double harga = getValidDoubleInput("Masukkan Harga Buku: ");

        inventaris.put(judul, stok);
        hargaBuku.put(judul, harga);
        penulisBuku.put(judul, penulis);
        System.out.println("Buku berhasil ditambahkan!");
    }

    private static void lihatDaftarBuku() {
        if (inventaris.isEmpty()) {
            System.out.println("Inventaris kosong.");
            return;
        }

        System.out.println("\nDaftar Buku:");
        System.out.println("=================================================================================");
        System.out.printf("| %-30s | %-20s | %-6s | %-12s |\n", "Judul", "Penulis", "Stok", "Harga");
        System.out.println("=================================================================================");

        for (String judul : inventaris.keySet()) {
            System.out.printf("| %-30s | %-20s | %-6d | Rp%,-10.2f |\n",
                    judul,
                    penulisBuku.get(judul),
                    inventaris.get(judul),
                    hargaBuku.get(judul));
        }
        System.out.println("=================================================================================");
    }

    private static void cariBuku() {
        System.out.print("Masukkan Judul Buku yang Dicari: ");
        String judul = scanner.nextLine();

        if (!inventaris.containsKey(judul)) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }

        System.out.println("\nDetail Buku:");
        System.out.println("Judul   : " + judul);
        System.out.println("Penulis : " + penulisBuku.get(judul));
        System.out.printf("Stok    : %d\n", inventaris.get(judul));
        System.out.printf("Harga   : Rp%,.2f\n", hargaBuku.get(judul));
    }

    private static void tambahStokBuku() {
        System.out.print("Masukkan Judul Buku yang Akan Ditambah Stoknya: ");
        String judul = scanner.nextLine();

        if (!inventaris.containsKey(judul)) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }

        int tambahan = getValidIntegerInput("Masukkan Jumlah Stok yang Akan Ditambahkan: ");
        inventaris.put(judul, inventaris.get(judul) + tambahan);
        System.out.println("Stok buku berhasil diperbarui!");
    }

    private static void hapusBuku() {
        System.out.print("Masukkan Judul Buku yang Akan Dihapus: ");
        String judul = scanner.nextLine();

        if (inventaris.remove(judul) == null) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }

        hargaBuku.remove(judul);
        penulisBuku.remove(judul);
        System.out.println("Buku berhasil dihapus!");
    }

    private static void perbaruiHargaBuku() {
        System.out.print("Masukkan Judul Buku yang Akan Diperbarui Harganya: ");
        String judul = scanner.nextLine();

        if (!hargaBuku.containsKey(judul)) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }

        double hargaBaru = getValidDoubleInput("Masukkan Harga Baru: ");
        hargaBuku.put(judul, hargaBaru);
        System.out.println("Harga buku berhasil diperbarui!");
    }

    private static void perbaruiPenulisBuku() {
        System.out.print("Masukkan Judul Buku yang Akan Diperbarui Penulisnya: ");
        String judul = scanner.nextLine();

        if (!penulisBuku.containsKey(judul)) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan Nama Penulis Baru: ");
        String penulisBaru = scanner.nextLine();
        penulisBuku.put(judul, penulisBaru);
        System.out.println("Penulis buku berhasil diperbarui!");
    }

    private static int getValidIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input < 0) {
                    System.out.println("Masukkan angka positif!");
                    continue;
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Masukkan angka yang valid!");
                scanner.nextLine();
            }
        }
    }

    private static double getValidDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double input = scanner.nextDouble();
                scanner.nextLine();
                if (input < 0) {
                    System.out.println("Masukkan angka positif!");
                    continue;
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Masukkan angka yang valid!");
                scanner.nextLine();
            }
        }
    }
}
