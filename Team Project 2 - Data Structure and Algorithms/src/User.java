public class User {
    private String nama;

    protected User(String nama) {
        this.nama = nama;
    }
    
    // Getter dan Setter untuk nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method untuk menampilkan semua lagu dalam playlist
    // Lagu ditampilkan dengan memanggil method tampilkanInfo() dari setiap objek Lagu dengan cara di looping
    public void tampilkanSemuaLagu(Lagu[] playlist) {
        System.out.println("\n===== Daftar Lagu =====");

        for (Lagu lagu : playlist) {
            if (lagu == null) {
                // Continue disini sebagai skip
                // Jadi dia akan balik ke looping awal daripada lanjut ke tampilkanInfo
                // Dan membantu ketika index awal pada array berisi null
                continue;
            }

            lagu.tampilkanInfo();
        }
    }

    // Method untuk mengurutkan lagu didalam playlist mulai dari durasi yang paling singkat
    // Fitur sort menggunakan bubble sort dengan O(n^2)
    // Bubble sort masuk kedalam kategori O(n^2) karena dia mempunyai nested loop
    // Jadi untuk n^2 karna ada loop didalam loop
    // Kalau ada loop didalam loop dan didalam loop lagi jadi nya n^3
    public void urutkanLagu(Lagu[] playlist, User user) {
        System.out.println("\nUrutan lagu sebelum di sorting");
        user.tampilkanSemuaLagu(playlist);

        // Variabel penampung untuk logic penukaran index didalam array
        Lagu temp;

        // Variabel penanda apakah sudah terjadi penukaran index apa belum
        boolean ditukar;

        for(int i = 0; i < playlist.length; i++) {
            // Pada saat awal looping initialize value ditukar menjadi false
            ditukar = false;

            playlist = rapihkanArray(playlist);

            for(int j = 0; j < playlist.length - i - 1; j++){
                if (playlist[j] == null || playlist[j + 1] == null) {
                    // Continue digunakan untuk kembali ke looping
                    // Agar saat playlist di index awal null, dia tidak error
                    continue;
                }

                // Cek apakah item index j lebih besar dari item selanjutnya
                if(playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    // Memasukan item ke temp untuk nantinya ditukar tempat
                    temp = playlist[j];
                    // Menimpa item index j dengan item selanjutnya
                    playlist[j] = playlist[j + 1];
                    // Menimpa item selanjutnya dengan item index j yang ada di variabel temp
                    playlist[j + 1] = temp;
                    // Update variabel ditukar, jadi sudah terjadi penukaran
                    ditukar = true;
                }
            }

            // Kalau tidak ada angka yang ditukar, keluar dari looping
            if (!ditukar)
                break;
        }

        System.out.println("\nUrutan lagu sesudah di sorting");
        user.tampilkanSemuaLagu(playlist);
    }

    // Private untuk sementara karna masih baru dipakai di class ini saja
    private Lagu[] rapihkanArray(Lagu[] playlist) {
        // Variabel penampung ada berapa banyak null nya
        int totalNull = 0;
        // Array penampung baru
        Lagu[] newPLaylist = new Lagu[playlist.length];

        // Cek berapa banyak yang null
        for (Lagu lagu: playlist) {
            if (lagu == null) {
                totalNull++;
            }
        }

        // Kalau ada yang null
        // Looping/copy array lama ke array baru dengan index dari totalNull
        if (totalNull != 0) {
            for (Lagu lagu : playlist) {
                if (lagu != null) {
                    newPLaylist[totalNull] = lagu;
                    // Mengurangi pointer untuk array baru
                    totalNull--;
                }
            }
        }

        // Kembalikan array baru
        return newPLaylist;
    }
}
