import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CekHariLibur {
    public static void main(String[] args) {
        // Daftar hari libur (contoh: Hari Minggu dan tanggal tertentu)
        List<String> hariLibur = Arrays.asList("Minggu", "1 Januari", "17 Agustus", "25 Desember");

        // Input hari dari pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan hari atau tanggal (misal: Minggu, 17 Agustus): ");
        String inputHari = scanner.nextLine();
        scanner.close();

        // Cek apakah hari yang dimasukkan ada dalam daftar hari libur
        if (hariLibur.contains(inputHari)) {
            System.out.println(inputHari + " adalah hari libur!");
        } else {
            System.out.println(inputHari + " bukan hari libur.");
        }
    }
}
