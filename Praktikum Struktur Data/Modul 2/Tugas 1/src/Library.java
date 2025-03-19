
import java.util.ArrayList;

class Library {

    private ArrayList<Book> daftarBuku = new ArrayList<>();

    public Library() {
        daftarBuku.add(new Book("Data Science Basics", "Maylani"));
        daftarBuku.add(new Book("Introduction to Algorithms", "Thomas H. Cormen"));
        daftarBuku.add(new Book("Clean Code", "Robert C. Martin"));
    }

    public void tambahBuku(String judul, String penulis) {
        daftarBuku.add(new Book(judul, penulis));
        System.out.println("\n=== Buku berhasil ditambahkan! ===\n");
    }

    public void lihatDaftarBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("\n=== Daftar buku kosong. ===\n");
        } else {
            System.out.println("\n=== Daftar Buku ===\n");
            for (int i = 0; i < daftarBuku.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBuku.get(i));
            }
            System.out.println();
        }
    }

    public void cariBuku(String judul) {
        boolean ditemukan = false;
        System.out.println("\n=== Hasil Pencarian ===\n");
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
        System.out.println();
    }
}
