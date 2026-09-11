import java.util.Locale;

public class Member extends User {
    public Member(String nama) {
        super(nama);
    }   

    public void cariLagu(Lagu[] playlist, String keyword) {
        System.out.println("\n===== Hasil pencarian =====");

        int pointerSearchResult = 0;
        Lagu[] searchResults = new Lagu[playlist.length];

        for (Lagu lagu : playlist) {
            if (lagu != null) {
                if (lagu.getJudul().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))) {
                    searchResults[pointerSearchResult] = lagu;
                    pointerSearchResult++;
                    lagu.tampilkanInfo();
                }
            }
        }

        if (pointerSearchResult == 0) {
            System.out.println("Tidak ada judul yang cocok");
        }
    }

    public void rataRataDurasi(Lagu[] playlist) {
        double totalDurasi = 0;
        int jumlahLagu = 0;

        for (Lagu lagu : playlist) {
            if (lagu != null) {
                totalDurasi += lagu.getDurasi();
                jumlahLagu++;
            }
        }

        if (jumlahLagu > 0) {
            double rataRata = totalDurasi / jumlahLagu;
            System.out.printf("\nRata-rata durasi lagu: %.2f menit\n", rataRata);
        } else {
            System.out.println("\nTidak ada lagu dalam playlist.");
        }
    }
}
