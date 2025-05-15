
public class App {

    public static void main(String[] args) throws Exception {
        do {
            System.out.println("Menu: \n1. Tambah Film\n2. Cari Film\n3. Tampilkan Koleksi(InOrder)\n4. Tampilkan Koleksi (PreOrder)\n5. Tampilkan Koleksi (PostOrder)\n6. Update/Edit Jumlah copy film\n7. Keluar");
            System.out.print("Pilih menu: ");

            switch (PilihanMenu) {
                case 1:
                    System.out.println("Tambah Film");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (false);
    }
}
