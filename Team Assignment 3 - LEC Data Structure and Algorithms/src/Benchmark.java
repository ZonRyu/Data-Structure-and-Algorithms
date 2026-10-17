/*
Tugas Kelompok 3 - [LEC] Data Structures and Algorithm Analysis
Group 2 - Anggota:
1. Julyon Putra Sannie      / 2902816550
2. Dede Rukmana             / 2902830366
3. Faiza Shifa Medina       / 2902826034
4. Bima Galaxy Putra        / 2902819464
5. Muhammad Taufiq Al Hakim / 2902820775
*/

import java.util.Locale;

public class Benchmark {

    public static void test(Lagu[] playlist) {
        int n = playlist.length;

        System.out.println("\n=== ANALISIS REKURSIF PLAYLIST ===");
        System.out.println("Jumlah lagu : " + n);

        // Pengukuran waktu totalDurasi()
        long startTotal = System.nanoTime();
        double total = PlaylistRekursif.totalDurasi(playlist, n);
        long endTotal = System.nanoTime();
        double timeTotalMs = (endTotal - startTotal) / 1_000_000.0;

        System.out.printf(Locale.US, "Total durasi : %.2f menit\n", total);

        // Pengukuran waktu cariDurasiTerpanjang() / cariLaguTerpanjang()
        long startMax = System.nanoTime();
        Lagu laguTerpanjang = PlaylistRekursif.cariDurasiTerpanjang(playlist, n);
        long endMax = System.nanoTime();
        double timeMaxMs = (endMax - startMax) / 1_000_000.0;

        if (laguTerpanjang != null) {
            System.out.printf(Locale.US, "Lagu terpanjang: \"%s\" - %s (%.2f menit)\n",
                    laguTerpanjang.getJudul(), laguTerpanjang.getArtis(), laguTerpanjang.getDurasi());
        }

        // Pengukuran waktu tampilkanMundur()
        System.out.println("\nDaftar lagu (ditampilkan terbalik):");
        long startMundur = System.nanoTime();
        // Rekursi mundur dimulai dari indeks terakhir (n - 1)
        PlaylistRekursif.tampilkanMundur(playlist, n - 1);
        long endMundur = System.nanoTime();
        double timeMundurMs = (endMundur - startMundur) / 1_000_000.0;

        // Menampilkan hasil pengukuran waktu eksekusi
        System.out.printf(Locale.US, "\nExecution Time (totalDurasi): %.4f ms%n", timeTotalMs);
        System.out.printf(Locale.US, "Execution Time (tampilkanMundur): %.4f ms%n", timeMundurMs);
        System.out.printf(Locale.US, "Execution Time (cariDurasiTerpanjang): %.4f ms%n", timeMaxMs);
        System.out.println("==================================");
    }
}
