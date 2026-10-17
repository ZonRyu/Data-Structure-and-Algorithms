/*
 * Tugas Kelompok 2 - Data Structures and Algorithm Analysis
 * Group 2 - Anggota:
 *  1. Julyon Putra Sannie      / 2902816550
 *  2. Dede Rukmana             / 2902830366
 *  3. Faiza Shifa Medina       / 2902826034
 *  4. Bima Galaxy Putra        / 2902819464
 *  5. Muhammad Taufiq Al Hakim / 2902820775
*/

public class PlaylistRekursif {

    /*
        Menghitung akumulasi total durasi dari seluruh lagu dalam playlist secara rekursif.

        Base Case:
        Ketika parameter n bernilai kurang dari atau sama dengan 0 (n <= 0), 
        proses rekursi berhenti dan mengembalikan nilai.

        Recursive Case:
        Mengambil durasi lagu pada indeks ke-(n - 1), lalu menjumlahkannya 
        dengan pemanggilan kembali fungsi totalDurasi(list, n - 1).
     */
    public static double totalDurasi(Lagu[] list, int n) {
        // Base Case
        if (n <= 0) {
            return 0.0;
        }
        // Recursive Case
        return list[n - 1].getDurasi() + totalDurasi(list, n - 1);
    }

 /*
 * Tujuan:
 * Menampilkan daftar lagu dari akhir ke awal menggunakan rekursi.
 *
 * Base Case:
 * Jika index < 0, rekursi dihentikan karena tidak ada
 * elemen playlist yang perlu ditampilkan.
 *
 * Recursive Case:
 * Menampilkan lagu pada indeks saat ini, kemudian
 * memanggil tampilkanMundur(list, index - 1).
 *
 * Kompleksitas Waktu: O(n), karena setiap lagu ditampilkan
 * tepat satu kali.
 *
 * Kompleksitas Ruang: O(n), karena kedalaman call stack
 * sebanding dengan jumlah lagu.
 */
public static void tampilkanMundur(Lagu[] list, int index) {
    if (index < 0) {
        return;
    }
    System.out.println((index + 1) + ". " + list[index].getJudul());
    tampilkanMundur(list, index - 1);
}

    /*
        Mengembalikan objek Lagu yang memiliki durasi paling lama.

        Base Case: n == 1 -> return list[0]
        
        Recursive Case: bandingkan durasi list[n-1] dengan lagu terpanjang dari sub-array (n-1)
     */
    public static Lagu cariDurasiTerpanjang(Lagu[] list, int n) {
        if (n <= 0) {
            return null;
        }
        if (n == 1) {
            return list[0];
        }
        Lagu maxSebelumnya = cariDurasiTerpanjang(list, n - 1);
        if (list[n - 1].getDurasi() > maxSebelumnya.getDurasi()) {
            return list[n - 1];
        } else {
            return maxSebelumnya;
        }
    }
}
