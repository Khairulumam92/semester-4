
class Book {

    private String judul;
    private String penulis;

    public Book(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    @Override
    public String toString() {
        return judul + " - " + penulis;
    }
}
