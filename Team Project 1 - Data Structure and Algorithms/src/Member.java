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
}
