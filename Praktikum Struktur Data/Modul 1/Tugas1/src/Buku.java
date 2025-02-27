public class Buku<T, U> {
    private T judul;
    private U pengarang;
    private double harga;

    public Buku(T judul, U pengarang, double harga) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.harga = harga;
    }

    public T getJudul() {
        return judul;
    }

    public U getPengarang() {
        return pengarang;
    }

    public double getHarga() {
        return harga;
    }

    public void displayInfo() {
        System.out.println("=== Informasi Buku ===");
        System.out.println("Judul : " + getJudul());
        System.out.println("Pengarang : " + getPengarang());
        System.out.println("Harga : " + getHarga());
    }

    enum Kategori {
        NOVEL, BIOGRAFI, TEKNOLOGI, ANAK
    }
}
