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
                break;
            }

            lagu.tampilkanInfo();
        }
    }
}
