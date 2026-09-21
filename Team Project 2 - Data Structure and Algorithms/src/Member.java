/*
 * Tugas Kelompok 2 - Data Structures and Algorithm Analysis
 * Group 2 - Anggota:
 *  1. Julyon Putra Sannie      / 2902816550
 *  2. Dede Rukmana             / 2902830366
 *  3. Faiza Shifa Medina       / 2902826034
 *  4. Bima Galaxy Putra        / 2902819464
 *  5. Muhammad Taufiq Al Hakim / 2902820775
*/

public class Member extends User {
    public Member(String nama) {
        super(nama);
    }

    // Member hanya boleh melihat, mencari, dan mengurutkan lagu
    @Override
    public boolean bolehMengubahPlaylist() {
        return false;
    }

    @Override
    public String tampilkanAkses() {
        return "Member - dapat melihat, mencari, dan mengurutkan lagu";
    }
}
