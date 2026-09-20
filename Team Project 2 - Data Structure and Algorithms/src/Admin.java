/*
 * Tugas Kelompok 2 - Data Structures and Algorithm Analysis
 * Kelompok 2 | Kelas: [ISI KELAS]
 * Anggota:
 *  1. Julyon Putra Sannie      / 2902816550
 *  2. Dede Rukmana             / 2902830366
 *  3. Faiza Shifa Medina       / 2902826034
 *  4. Bima Galaxy Putra        / 2902819464
 *  5. Muhammad Taufiq Al Hakim / 2902820775
 */
public class Admin extends User {
    public Admin(String nama) {
        super(nama);
    }

    // Admin boleh menambah dan menghapus lagu
    @Override
    public boolean bolehMengubahPlaylist() {
        return true;
    }

    @Override
    public String tampilkanAkses() {
        return "Admin - dapat menambah dan menghapus lagu";
    }
}
