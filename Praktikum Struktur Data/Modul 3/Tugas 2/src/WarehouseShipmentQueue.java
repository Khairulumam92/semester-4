
import java.util.Scanner;

public class WarehouseShipmentQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManualQueue antrian = new ManualQueue();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM ANTRIAN PENGIRIMAN BARANG ===");
            System.out.println("1. Tambah Item ke Antrian");
            System.out.println("2. Kirim Item (Proses Antrian)");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID Item: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama Item: ");
                    String nama = scanner.nextLine();
                    antrian.tambahBarang(id, nama);
                    break;
                case 2:
                    antrian.sendItem();
                    break;
                case 3:
                    antrian.tampilkanAntrian();
                    break;
                case 4:
                    System.out.println("Keluar dari sistem...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
