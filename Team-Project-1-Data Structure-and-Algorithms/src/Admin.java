public class Admin extends User {
    public Admin(String nama) {
        super(nama);
    }

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
