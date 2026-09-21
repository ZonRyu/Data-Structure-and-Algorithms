/*
 * Tugas Kelompok 2 - Data Structures and Algorithm Analysis
 * Group 2 - Anggota:
 *  1. Julyon Putra Sannie      / 2902816550
 *  2. Dede Rukmana             / 2902830366
 *  3. Faiza Shifa Medina       / 2902826034
 *  4. Bima Galaxy Putra        / 2902819464
 *  5. Muhammad Taufiq Al Hakim / 2902820775
*/

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

    // Test direct edit
    // Method untuk menampilkan detail lagu
    public void tampilkanInfo() {
        System.out.println("Judul : " + this.judul);
        System.out.println("Artis : " + this.artis);
        System.out.println("Durasi: " + this.durasi + " menit");
        System.out.println("-----------------------");
    }
}
