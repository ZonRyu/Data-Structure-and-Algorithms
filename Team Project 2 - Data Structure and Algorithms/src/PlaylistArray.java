/*
 * Tugas Kelompok 2 - Data Structures and Algorithm Analysis
 * Group 2 - Anggota:
 *  1. Julyon Putra Sannie      / 2902816550
 *  2. Dede Rukmana             / 2902830366
 *  3. Faiza Shifa Medina       / 2902826034
 *  4. Bima Galaxy Putra        / 2902819464
 *  5. Muhammad Taufiq Al Hakim / 2902820775
*/

import java.util.Locale;
import java.util.Scanner;

public class PlaylistArray {
    // Kapasitas maksimum playlist
    private static final int KAPASITAS = 10;

    // lagu selalu menumpuk dari index 0, slot kosong (null) ada di belakang
    private Lagu[] playlist = new Lagu[KAPASITAS];
    private Scanner scanner = new Scanner(System.in);

    // Constructor mengisi 3 lagu awal
    public PlaylistArray() {
        playlist[0] = new Lagu("Antarlina", "Goodenough", 5.01);
        playlist[1] = new Lagu("Sorry, i quit!", "Hoolahoop", 3.47);
        playlist[2] = new Lagu("Cico Buff", "Cocteau Twins", 3.47);
    }

    // TRAVERSAL untuk  menelusuri array dari index 0 sampai akhir dan menampilkan setiap lagu
    public void tampilkanSemuaLagu() {
        System.out.println("\nDaftar lagu saat ini:");
        cetakDaftar();
    }

    // INSERTION untuk mencari slot kosong (null) pertama, lalu mengisinya dengan lagu baru
    // Kalau tidak ada slot kosong berarti playlist penuh, input tidak diminta
    public void tambahLagu() {
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] == null) {
                System.out.print("\nMasukkan judul lagu : ");
                String judul = scanner.nextLine().trim();
                System.out.print("Masukkan artis      : ");
                String artis = scanner.nextLine().trim();
                System.out.print("Masukkan durasi (menit): ");

                // Durasi dibaca sebagai teks lalu diubah ke double
                // replace(',', '.') supaya "4,10" juga diterima
                double durasi = -1;
                try {
                    durasi = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                } catch (NumberFormatException e) {
                    durasi = -1; // bukan angka, ditolak di pengecekan bawah
                }

                if (judul.isEmpty() || artis.isEmpty() || !(durasi > 0)) {
                    System.out.println("Input tidak valid, lagu tidak ditambahkan.");
                    return;
                }

                playlist[i] = new Lagu(judul, artis, durasi);
                System.out.println("Lagu berhasil ditambahkan!");
                tampilkanSemuaLagu();
                return;
            }
        }

        // Kalau loop selesai tanpa menemukan null, semua 10 slot terisi
        System.out.println("\nPlaylist sudah penuh, harap hapus lagu sebelum menambahkan lagu baru");
    }

    // DELETION
    // Asumsi: judul unik, jadi hanya kecocokan pertama yang dihapus
    public void hapusLagu() {
        System.out.print("\nMasukkan judul lagu yang ingin dihapus: ");
        String judul = scanner.nextLine().trim();

        int indeks = -1;
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] == null) {
                continue;
            }
            if (playlist[i].getJudul().equalsIgnoreCase(judul)) {
                indeks = i;
                break;
            }
        }

        if (indeks == -1) {
            System.out.println("Lagu \"" + judul + "\" tidak ditemukan di playlist.");
            return;
        }

        // Tiap elemen ditimpa oleh elemen di sebelah kanannya
        for (int i = indeks; i < playlist.length - 1; i++) {
            playlist[i] = playlist[i + 1];
        }
        playlist[playlist.length - 1] = null;

        System.out.println("Lagu \"" + judul + "\" berhasil dihapus.");
        tampilkanSemuaLagu();
    }

    // SEARCHING memakai linear search, periksa satu per satu dari index 0 sampai akhir
    // Pencarian parsial (contains) dan tidak peduli huruf besar/kecil
    public void cariLagu() {
        System.out.print("\nMasukkan judul lagu yang ingin dicari: ");
        String keyword = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

        if (keyword.isEmpty()) {
            System.out.println("Kata kunci tidak boleh kosong.");
            return;
        }

        System.out.println("\n===== Hasil pencarian =====");
        int ditemukan = 0;

        for (Lagu lagu : playlist) {
            if (lagu != null && lagu.getJudul().toLowerCase(Locale.ROOT).contains(keyword)) {
                ditemukan++;
                lagu.tampilkanInfo();
            }
        }

        if (ditemukan == 0) {
            System.out.println("Tidak ada judul yang cocok");
        }
    }

    // SORTING memakai Bubble Sort berdasarkan durasi (ascending)
    // Bandingkan dua elemen bersebelahan, tukar jika urutannya salah
    // kalau satu putaran tanpa pertukaran, data sudah urut, berhenti lebih awal
    public void urutkanLaguBerdasarkanDurasi() {
        if (hitungLagu() < 2) {
            System.out.println("\nMinimal harus ada 2 lagu untuk diurutkan.");
            return;
        }

        System.out.println("\nUrutan lagu sebelum diurutkan:");
        cetakDaftar();

        Lagu temp;
        boolean ditukar;

        for (int i = 0; i < playlist.length; i++) {
            ditukar = false;

            for (int j = 0; j < playlist.length - i - 1; j++) {
                // Slot kosong dilewati agar tidak terjadi NullPointerException
                if (playlist[j] == null || playlist[j + 1] == null) {
                    continue;
                }

                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                    ditukar = true;
                }
            }

            if (!ditukar) {
                break;
            }
        }

        System.out.println("\nUrutan lagu sesudah diurutkan (durasi ascending):");
        cetakDaftar();
    }

    // Mencetak seluruh lagu dalam playlist dipakai traversal dan sorting
    private void cetakDaftar() {
        int jumlah = 0;

        for (Lagu lagu : playlist) {
            if (lagu == null) {
                continue;
            }
            jumlah++;
            lagu.tampilkanInfo();
        }

        if (jumlah == 0) {
            System.out.println("Playlist masih kosong.");
        }
    }

    // Menghitung jumlah lagu yang tersimpan
    private int hitungLagu() {
        int jumlah = 0;
        for (Lagu lagu : playlist) {
            if (lagu != null) {
                jumlah++;
            }
        }
        return jumlah;
    }

    // Menu login untuk memilih peran Admin atau Member 
    // Playlist disimpan di field, jadi data tetap ada meskipun login berganti
    private void jalankanLogin() {
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n===== Selamat Datang =====");
            System.out.println("Login Sebagai :");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.println("3. Keluar");
            System.out.print("\nInput : ");

            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1":
                    jalankanMenu(new Admin("Admin 1"));
                    break;
                case "2":
                    jalankanMenu(new Member("John Doe"));
                    break;
                case "3":
                    lanjut = false;
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
                    break;
            }
        }
    }

    // Menu playlist
    // agar input huruf tidak membuat program crash dan tidak ada sisa newline di Scanner
    // Menambah dan menghapus lagu hanya boleh oleh pengguna yang bolehMengubahPlaylist() = true
    private void jalankanMenu(User pengguna) {
        System.out.println("Selamat datang, " + pengguna.getNama());
        System.out.println("Hak akses : " + pengguna.tampilkanAkses());

        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Urutkan berdasarkan durasi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1":
                    tampilkanSemuaLagu();
                    break;
                case "2":
                    if (pengguna.bolehMengubahPlaylist()) {
                        tambahLagu();
                    } else {
                        aksesDitolak();
                    }
                    break;
                case "3":
                    if (pengguna.bolehMengubahPlaylist()) {
                        hapusLagu();
                    } else {
                        aksesDitolak();
                    }
                    break;
                case "4":
                    cariLagu();
                    break;
                case "5":
                    urutkanLaguBerdasarkanDurasi();
                    break;
                case "6":
                    lanjut = false;
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, masukkan angka 1-6.");
                    break;
            }
        }
    }

    private void aksesDitolak() {
        System.out.println("Akses ditolak: hanya Admin yang dapat menambah atau menghapus lagu.");
    }

    // Method main untuk menjalankan program
    public static void main(String[] args) {
        PlaylistArray app = new PlaylistArray();
        app.jalankanLogin();
        app.scanner.close();
    }
}
