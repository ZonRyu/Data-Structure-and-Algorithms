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

// Class ini dibuat untuk menyimpan data satu pelanggan customer service.

public class Customer {

    // Dibuat private (encapsulation), akses melalui getter/setter
    private String name;

    // Constructor: dipanggil keika membuat pelanggan baru
    public Customer(String name) {
        this.name = name;
    }

    // Getter: untuk mengambil nama
    public String getName() {
        return name;
    }

    // Setter: untuk mengubah nama ketika salah ketik
    public void setName(String name) {
        this.name = name;
    }

    // Print nama pelanggan
    @Override
    public String toString() {
        return name;
    }
}