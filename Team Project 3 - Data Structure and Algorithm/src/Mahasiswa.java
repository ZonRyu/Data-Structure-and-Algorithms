/*
TUGAS PRAKTIKUM
[COSC6025036: AAC2-LAB] Data Structures and Algorithm Analysis

Group 2 - Anggota:
1. Julyon Putra Sannie        / 2902816550
2. Dede Rukmana               / 2902830366
3. Faiza Shifa Medina         / 2902826034
4. Bima Galaxy Putra          / 2902819464
5. Muhammad Taufiq Al Hakim   / 2902820775

*/

// Data satu mahasiswa. NIM menggunakan String supaya angka 0 di depan tidak hilang.
public class Mahasiswa {
    private String nim;
    private String nama;
    private int nilai;

    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        setNilai(nilai); // setter
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public int getNilai() { return nilai; }

    // nilai di luar 0-100 ditolak
    public void setNilai(int nilai) {
        if (nilai < 0 || nilai > 100) {
            throw new IllegalArgumentException("Nilai harus 0-100");
        }
        this.nilai = nilai;
    }

    // format sesuai contoh output soal
    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Nilai: " + nilai;
    }
}