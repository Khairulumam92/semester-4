
// Kelas Queue manual
class ManualQueue {

    Item front, rear;
    int size;

    public ManualQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    // Menambah barang ke antrian (enqueue)
    public void tambahBarang(String id, String nama) {
        Item newBarang = new Item(id, nama);
        if (this.rear == null) {
            this.front = this.rear = newBarang;
        } else {
            this.rear.next = newBarang;
            this.rear = newBarang;
        }
        this.size++;
        System.out.println("Item [" + id + " - " + nama + "] ditambahkan ke antrian.");
    }

    // Mengirim barang dari antrian (dequeue)
    public void sendItem() {
        if (this.front == null) {
            System.out.println("Antrian kosong, tidak ada barang untuk dikirim.");
            return;
        }
        Item temp = this.front;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        this.size--;
        System.out.println("Item [" + temp.id + " - " + temp.nama + "] telah dikirim.");
    }

    // Menampilkan semua barang dalam antrian
    public void tampilkanAntrian() {
        if (this.front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("\n=== DAFTAR BARANG DALAM ANTRIAN ===");
        Item current = this.front;
        int posisi = 1;
        while (current != null) {
            System.out.println(posisi + ". [" + current.id + "] " + current.nama);
            current = current.next;
            posisi++;
        }
        System.out.println("Total barang dalam antrian: " + this.size + "\n");
    }
}
