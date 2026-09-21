/*
 * Tugas Kelompok 2 - Data Structures and Algorithm Analysis
 * Group 2 - Anggota:
 *  1. Julyon Putra Sannie      / 2902816550
 *  2. Dede Rukmana             / 2902830366
 *  3. Faiza Shifa Medina       / 2902826034
 *  4. Bima Galaxy Putra        / 2902819464
 *  5. Muhammad Taufiq Al Hakim / 2902820775
*/

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

    // Menentukan apakah pengguna boleh menambah/menghapus lagu
    // Method ini dioverride oleh Admin dan Member
    public boolean bolehMengubahPlaylist() {
        return false;
    }

    // Hak akses, juga dioverride subclass
    public String tampilkanAkses() {
        return "User";
    }
}
