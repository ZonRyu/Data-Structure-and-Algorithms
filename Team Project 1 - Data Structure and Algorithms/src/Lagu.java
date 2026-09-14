public class Lagu {
    private String judul;
    private String artis;
    private double durasi;

    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Getter untuk judul dan durasi
    public String getJudul() {
        return judul;
    }

    public double getDurasi() {
        return durasi;
    }

    // Method untuk menampilkan detail lagu
    public void tampilkanInfo() {
        System.out.println("Judul : " + this.judul);
        System.out.println("Artis : " + this.artis);
        System.out.println("Durasi: " + this.durasi + " menit");
        System.out.println("-----------------------");
    }
}
