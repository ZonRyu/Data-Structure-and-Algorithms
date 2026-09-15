import java.util.Scanner;

public class Admin extends User {
    public Admin(String nama) {
        super(nama);
    }

    // Method untuk menambahkan lagu ke playlist
    // Jika array playlist penuh, maka buat playlist baru dengan ukuran 1 lebih besar dari playlist lama
    // Lagu baru ditambahkan ke playlist baru
    // Jika array playlist belum penuh, maka tambahkan lagu baru ke playlist lama
    public Lagu[] tambahLagu(Lagu[] playlist, Scanner scanner) {
        for (int i = 0; i < playlist.length; i++) {
            // Melakukan pengecekan adakah slot kosong di array
            if (playlist[i] == null) {
                System.out.println("Masukan informasi lagu");
                scanner.nextLine(); // Membersihkan newline character dari input sebelumnya
                System.out.print("Judul: ");
                String judul = scanner.nextLine();
                System.out.print("Artis: ");
                String artis = scanner.nextLine();
                System.out.print("Durasi: ");
                double durasi = scanner.nextDouble();

                System.out.println("Memasukan lagu ke playlist dengan index " + i);
                System.out.println("Lagu berhasil ditambahkan");
                playlist[i] = new Lagu(judul, artis, durasi);
                return playlist;
            }

            // Cek apakah pointer index i sudah berada di akhir index array
            if (playlist.length - 1 == i) {
                // Beritahu bahwa array sudah penuh
                // Kenapa cuman melakukan pengecekan pointer index berada di akhir index array
                // Karena ketika ada slot akan masuk ke if statement diatas
                // Dan tidak akan lanjut ke if statement ini karena sudah melakukan aksi return
                System.out.println("Playlist sudah penuh, harap hapus lagu sebelum menambahkan lagu baru");
                return playlist;
            }
        }

//        System.out.println("Playlist penuh, harap hapus lagu terlebih dahulu untuk menambahkan lagu baru");
//        return playlist;

//        Lagu[] playlistBaru = new Lagu[playlist.length + 1];
//
//        for (int i = 0; i < playlist.length; i++) {
//            playlistBaru[i] = playlist[i];
//        }
//
//        playlistBaru[playlist.length] = laguBaru;
//
        return playlist;
    }
}
