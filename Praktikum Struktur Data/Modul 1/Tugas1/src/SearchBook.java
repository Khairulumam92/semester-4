public class SearchBook {
    enum BookCategory {
        NOVEL, BIOGRAFI, TEKNOLOGI, ANAK
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== Pencarian Buku ===");
        System.out.println("Masukkan judul buku : ");
        System.out.println("Masukkan nama pengarang : ");
        System.out.println("Masukkan harga : ");
        System.out.println("Pilih katageori buku : ");
        System.out.println("0. NOVEL\n1. BIOGRAFI\n2. TEKNOLOGI\n3. ANAK");

        for (BookCategory category : BookCategory.values()) {
            System.out.println(category.ordinal() + ". " + category);
        }

        System.out.print("Masukkan pilihan : ");

        System.out.println("=== Informasi Buku ===");
        System.out.println("Judul : ");
        System.out.println("Pengarang : ");
        System.out.println("Harga : ");
        System.out.println("Katageri : ");
    }
}
