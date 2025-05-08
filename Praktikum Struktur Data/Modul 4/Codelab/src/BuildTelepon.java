
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BuildTelepon {

    public static void main(String[] args) {
        HashMap<String, String> bukuTelepon = new HashMap<>();
        Scanner input = new Scanner(System.in);

        bukuTelepon.put("Faizal", "88123456789");
        bukuTelepon.put("Taufiq", "88765432180");
        bukuTelepon.put("Adit", "8855555555");

        System.out.println("=== Isi Buku Telepon: ===");
        for (Map.Entry<String, String> entry : bukuTelepon.entrySet()) {
            System.out.println(
                    "Nama: " + entry.getKey() + ", Telepon: " + entry.getValue()
            );
        }

        System.out.print("\nMasukkan nama yang dicari: ");
        String namaDicari = input.nextLine();

        String nomorTelepon = bukuTelepon.get(namaDicari);

        if (nomorTelepon != null) {
            System.out.println(
                    "\nNomor telepon " + namaDicari + ": " + nomorTelepon
            );
        } else {
            System.out.println("Kontak " + namaDicari + " tidak ditemukan.");
        }

        String namaPengecekan = namaDicari;

        if (bukuTelepon.containsKey(namaPengecekan)) {
            System.out.println(
                    "Kontak " + namaPengecekan + " ada dalam buku telepon."
            );
        } else {
            System.out.println(
                    "Kontak " + namaPengecekan + " tidak ada dalam buku telepon."
            );
        }

        System.out.print("\nMasukkan nama yang akan dihapus :");
        String namaHapus = input.nextLine();

        bukuTelepon.remove(namaHapus);
        System.out.println(
                "\nIsi Buku Telepon setelah menghapus " + namaHapus + ": \n" + bukuTelepon
        );
    }
}
