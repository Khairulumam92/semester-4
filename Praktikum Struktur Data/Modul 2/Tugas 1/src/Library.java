
import java.util.ArrayList;
import java.util.Scanner;

class Library {

    private ArrayList<Book> daftarBuku = new ArrayList<>();

    public void tambahBuku(String judul, String penulis) {
        daftarBuku.add(new Book(judul, penulis));
        System.out.println("Buku berhasil ditambahkan!");
    }

    public void lihatDaftarBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Daftar buku kosong.");
        } else {
            System.out.println("Daftar Buku:");
            for (int i = 0; i < daftarBuku.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBuku.get(i));
            }
        }
    }

    public void cariBuku(String judul) {
        boolean ditemukan = false;
        for (Book buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Buku ditemukan!");
                System.out.println("Judul: " + buku.getJudul());
                System.out.println("Penulis: " + buku.getPenulis());
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
        }
    }
}
