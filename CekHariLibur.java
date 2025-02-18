import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CekHariLibur {
    public static void main(String[] args) {
        // Daftar hari libur nasional (format: "dd-MM-yyyy")
        Set<String> hariLiburNasional = new HashSet<>(Arrays.asList(
            "01-01-2025", // Tahun Baru
            "17-08-2025", // Hari Kemerdekaan RI
            "25-12-2025"  // Natal
        ));

        // Scanner untuk input pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-MM-yyyy): ");
        String inputTanggal = scanner.nextLine();
        scanner.close();

        // Format tanggal
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);

        try {
            // Konversi input ke objek Date
            Date tanggal = sdf.parse(inputTanggal);

            // Mendapatkan hari dalam seminggu
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tanggal);
            int hariDalamMinggu = calendar.get(Calendar.DAY_OF_WEEK);

            // Cek apakah weekend
            boolean isWeekend = (hariDalamMinggu == Calendar.SATURDAY || hariDalamMinggu == Calendar.SUNDAY);

            // Cek apakah hari libur nasional
            boolean isLiburNasional = hariLiburNasional.contains(inputTanggal);

            // Menampilkan hasil
            System.out.println("\nHasil: ");
            if (isLiburNasional) {
                System.out.println(inputTanggal + " adalah Hari Libur Nasional!");
            } else if (isWeekend) {
                System.out.println(inputTanggal + " adalah akhir pekan (weekend)!");
            } else {
                System.out.println(inputTanggal + " adalah hari kerja biasa.");
            }

        } catch (ParseException e) {
            System.out.println("Format tanggal salah! Gunakan format dd-MM-yyyy.");
        }
    }
}
