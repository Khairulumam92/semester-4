
import java.util.HashMap;
import java.util.Map;

public class BuildTelepon {

    public static void main(String[] args) {
        HashMap<String, String> bukuTelepon = new HashMap<>();

        bukuTelepon.put("Faizal", "88123456789");
        bukuTelepon.put("Taufiq", "88765432180");
        bukuTelepon.put("Adit", "8855555555");

        System.out.println("Isi Buku Telepon:");
        for (Map.Entry<String, String> entry : bukuTelepon.entrySet()) {
            System.out.println(
                    "Nama: " + entry.getKey() + ", Telepon: " + entry.getValue()
            );
        }

        String namaDicari = "Taufiq";
        String nomorTelepon = bukuTelepon.get(namaDicari);

        if (nomorTelepon != null) {
            System.out.println(
                    "Nomor telepon " + namaDicari + ": " + nomorTelepon
            );
        } else {
            System.out.println("Kontak " + namaDicari + " tidak ditemukan.");
        }

        String namaPengecekan = "Adit";
        if (bukuTelepon.containsKey(namaPengecekan)) {
            System.out.println(
                    "Kontak " + namaPengecekan + " ada dalam buku telepon."
            );
        } else {
            System.out.println(
                    "Kontak " + namaPengecekan + " tidak ada dalam buku telepon."
            );
        }

        String namaHapus = "Faizal";
        bukuTelepon.remove(namaHapus);
        System.out.println(
                "Isi Buku Telepon setelah menghapus " + namaHapus + ": \n" + bukuTelepon
        );
    }
}
