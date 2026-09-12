public class Admin extends User {
    public Admin(String nama) {
        super(nama);
    }

    // Method untuk menambahkan lagu ke playlist
    // Jika array playlist penuh, maka buat playlist baru dengan ukuran 1 lebih besar dari playlist lama
    // Lagu baru ditambahkan ke playlist baru
    // Jika array playlist belum penuh, maka tambahkan lagu baru ke playlist lama
    public Lagu[] tambahLagu(Lagu[] playlist, Lagu laguBaru) {
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] == null) {
                System.out.println("Memasukan lagu ke playlist lama dengan index " + i);
                playlist[i] = laguBaru;
                return playlist;
            }
        }

        Lagu[] playlistBaru = new Lagu[playlist.length + 1];

        for (int i = 0; i < playlist.length; i++) {
            playlistBaru[i] = playlist[i];
        }

        playlistBaru[playlist.length] = laguBaru;

        return playlistBaru;
    }
}
