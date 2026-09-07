import java.util.Locale;

public class User {
    String nama;

    User(String nama) {
        this.nama = nama;
    }
}

class Admin extends User {
    Admin(String nama) {
        super(nama);
    }

    Lagu[] tambahLagu(Lagu[] playlist, Lagu laguBaru){
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

//        System.arraycopy(playlist, 0, playlistBaru, 0, playlist.length);

        playlistBaru[playlist.length] = laguBaru;

        return playlistBaru;
    }
}

class Member extends User {
    Lagu[] playlist;

    Member(String nama) {
        super(nama);
    }

    void tampilkanSemuaLagu(Lagu[] playlist) {
        for (Lagu lagu: playlist) {
            if (lagu == null) {
                break;
            }

            lagu.tampilkanInfo();
        }
    }

    void cariLagu(Lagu[] playlist, String keyword) {
        System.out.println("Hasil pencarian:");

        int pointerSearchResult = 0;
        Lagu[] searchResults = new Lagu[playlist.length];

        for (Lagu lagu : playlist) {
            if (lagu != null) {
                if (lagu.judul.toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))) {
                    searchResults[pointerSearchResult] = lagu;
                    pointerSearchResult = pointerSearchResult + 1;
                    lagu.tampilkanInfo();
                }
            }
        }

        if (pointerSearchResult == 0) {
            System.out.println("Tidak ada judul yang cocok");
        }
    }
}