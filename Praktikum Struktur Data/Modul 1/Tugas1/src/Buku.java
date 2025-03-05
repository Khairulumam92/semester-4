public class Buku<T, U> {
    private T judul;
    private U pengarang;
    private double harga;
    private Kategori kategori;

    public Buku(T judul, U pengarang, double harga, Kategori kategori) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.harga = harga;
        this.kategori = kategori;
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

    public Kategori getKategori() {
        return kategori;
    }

    public void displayInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Harga: " + harga);
        System.out.println("Kategori: " + kategori);
    }
}
