import java.util.Locale;

public class Member extends User {
    public Member(String nama) {
        super(nama);
    }   

    // Method untuk mencari lagu berdasarkan judul
    // Lagu yang cocok ditampilkan dengan memanggil method tampilkanInfo() dari setiap objek Lagu dengan cara di looping
    // Jika tidak ada judul yang cocok, tampilkan pesan "Tidak ada judul yang cocok"
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

    // Method untuk menghitung rata-rata durasi lagu dalam playlist
    // Rata-rata dihitung denganc cara loop untuk menjumlahkan durasi semua lagu, 
    // kemudian dibagi dengan total jumlah lagu yang ada
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
