
// Node untuk menyimpan data barang
class Item {

    String id;
    String nama;
    Item next;

    public Item(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.next = null;
    }
}
