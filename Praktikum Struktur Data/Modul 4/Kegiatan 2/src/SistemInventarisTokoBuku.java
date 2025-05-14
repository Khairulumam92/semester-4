
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class SistemInventarisTokoBuku {

    private static Map<String, Integer> inventaris = new HashMap<>();
    private static Map<String, Double> hargaBuku = new HashMap<>();
    private static Map<String, String> penulisBuku = new HashMap<>();
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, ArrayList<String>> userDetails = new HashMap<>();
    private static String loggedInUser = null;
    private static Scanner scanner = new Scanner(System.in);

    static {
        users.put("khairul-umam", "password123");
        userDetails.put("khairul-umam", new ArrayList<>(Arrays.asList("Khairul Umam", "Jl. Tegalgondo")));

        users.put("jane.doe", "securepass");
        userDetails.put("jane.doe", new ArrayList<>(Arrays.asList("Jane Doe", "Jl. Mawar")));

        users.put("john.smith", "mypassword");
        userDetails.put("john.smith", new ArrayList<>(Arrays.asList("John Smith", "Jl. Melati")));
    }

    private static void register() {
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Registrasi Gagal: Username sudah terdaftar.");
            return;
        }

        if (!username.contains("@")) {
            System.out.println("Registrasi Gagal: Username harus mengandung karakter '@'.");
            return;
        }

        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        if (password.length() < 8) {
            System.out.println("Registrasi Gagal: Password minimal 8 karakter.");
            return;
        }

        System.out.print("Masukkan Nama Lengkap: ");
        String namaLengkap = scanner.nextLine();

        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();

        users.put(username, password);
        userDetails.put(username, new ArrayList<>(Arrays.asList(namaLengkap, alamat)));
        System.out.println("Registrasi Berhasil!");
    }

    private static void login() {
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedInUser = username;
            ArrayList<String> details = userDetails.get(username);
            System.out.println("Login Berhasil!");
            System.out.println("Nama Lengkap: " + details.get(0));
            System.out.println("Alamat: " + details.get(1));
        } else {
            System.out.println("Login Gagal!");
        }
    }

    private static void logout() {
        loggedInUser = null;
        System.out.println("Logout Berhasil!");
    }

    private static void lihatLaporanInventaris() {
        if (loggedInUser == null) {
            System.out.println("Akses ditolak. Silakan login terlebih dahulu.");
            return;
        }

        System.out.println("\nLaporan Inventaris:");
        lihatDaftarBuku();
        System.out.println("User yang login: " + userDetails.get(loggedInUser).get(0));
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\nPilih Menu:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Keluar");
        System.out.print("\nPilihan Anda: ");
    }

    private static void tampilkanMenuSetelahLogin() {
        System.out.println("\nPilih Menu:");
        System.out.println("1. Tambah Buku Baru");
        System.out.println("2. Lihat Daftar Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Tambah Stok Buku");
        System.out.println("5. Hapus Buku");
        System.out.println("6. Perbarui Harga Buku");
        System.out.println("7. Perbarui Penulis Buku");
        System.out.println("8. Lihat Laporan Inventaris");
        System.out.println("9. Logout");
        System.out.print("\nPilihan Anda: ");
    }

    public static void main(String[] args) {
        inisialisasiDataBuku();

        System.out.println("Selamat Datang di Sistem Inventaris Toko Buku\n");

        boolean isRunning = true;
        while (isRunning) {
            if (loggedInUser == null) {
                tampilkanMenuUtama();
                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilihan) {
                        case 1:
                            register();
                            break;
                        case 2:
                            login();
                            break;
                        case 3:
                            System.out.println("Terima kasih telah menggunakan sistem inventaris!");
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Harap masukkan angka antara 1-3.");
                    scanner.nextLine();
                }
            } else {
                tampilkanMenuSetelahLogin();
                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();

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
                            lihatLaporanInventaris();
                            break;
                        case 9:
                            logout();
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Harap masukkan angka antara 1-9.");
                    scanner.nextLine();
                }
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
