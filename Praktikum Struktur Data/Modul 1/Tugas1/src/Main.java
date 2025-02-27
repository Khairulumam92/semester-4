import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Pencarian Buku ===");
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();

        System.out.print("Masukkan nama pengarang: ");
        String pengarang = scanner.nextLine();

        System.out.print("Masukkan harga: ");
        double harga = scanner.nextDouble();

        Buku<String, String> buku = new Buku<>(judul, pengarang, harga);
        buku.displayInfo();
    }
}
