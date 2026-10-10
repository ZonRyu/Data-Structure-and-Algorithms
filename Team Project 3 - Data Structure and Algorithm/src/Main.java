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

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final CustomerQueue antrean = new CustomerQueue();
    private static final TextEditor editor = new TextEditor();
    private static final StudentList daftarMahasiswa = new StudentList();

    public static void main(String[] args) {
        isiDataAwal();

        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Sistem Antrean (Queue)");
            System.out.println("2. Undo/Redo Editor Teks (Stack)");
            System.out.println("3. Data Mahasiswa (Linked List)");
            System.out.println("4. Benchmark waktu eksekusi");
            System.out.println("0. Keluar");
            int pilihan = bacaAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    menuQueue();
                    break;
                case 2:
                    menuStack();
                    break;
                case 3:
                    menuLinkedList();
                    break;
                case 4:
                    Benchmark.main(new String[0]);
                    break;
                case 0:
                    berjalan = false;
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia, coba lagi.");
            }
        }
    }

    // Data awal
    private static void isiDataAwal() {
        antrean.enqueue(new Customer("Andi"));
        antrean.enqueue(new Customer("Budi"));
        antrean.enqueue(new Customer("Siti"));

        editor.addText("Selamat");
        editor.addText(" datang");

        daftarMahasiswa.addStudent(new Mahasiswa("12345", "Andi", 85));
        daftarMahasiswa.addStudent(new Mahasiswa("67890", "Budi", 90));
    }

    // Submenu Queue
    private static void menuQueue() {
        int pilihan;
        do {
            System.out.println("\n[Antrean Customer Service]");
            System.out.println("1. Tambah pelanggan");
            System.out.println("2. Layani pelanggan");
            System.out.println("3. Tampilkan antrean");
            System.out.println("0. Kembali");
            pilihan = bacaAngka("Pilih: ");

            switch (pilihan) {
                case 1: {
                    String nama = bacaTeksWajib("Nama pelanggan: ");
                    antrean.enqueue(new Customer(nama));
                    System.out.println(nama + " masuk antrean.");
                    break;
                }
                case 2: {
                    Customer dilayani = antrean.serve();
                    if (dilayani == null) {
                        System.out.println("Antrean kosong, tidak ada yang dilayani.");
                    } else {
                        System.out.println("Melayani pelanggan: " + dilayani.getName());
                    }
                    break;
                }
                case 3:
                    antrean.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    // Submenu Stack
    private static void menuStack() {
        int pilihan;
        do {
            System.out.println("\n[Editor Teks (Undo/Redo)]");
            System.out.println("1. Tambah teks");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Tampilkan teks saat ini");
            System.out.println("0. Kembali");
            pilihan = bacaAngka("Pilih: ");

            switch (pilihan) {
                case 1:
                    System.out.print("Teks yang ditambahkan: ");
                    editor.addText(scanner.nextLine());
                    tampilkanTeks();
                    break;
                case 2:
                    if (editor.undo()) {
                        System.out.print("Undo: ");
                        tampilkanTeks();
                    } else {
                        System.out.println("Tidak ada yang bisa di-undo.");
                    }
                    break;
                case 3:
                    if (editor.redo()) {
                        System.out.print("Redo: ");
                        tampilkanTeks();
                    } else {
                        System.out.println("Tidak ada yang bisa di-redo.");
                    }
                    break;
                case 4:
                    tampilkanTeks();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    //  Submenu Linked List
    private static void menuLinkedList() {
        int pilihan;
        do {
            System.out.println("\n[Data Mahasiswa]");
            System.out.println("1. Tambah mahasiswa");
            System.out.println("2. Hapus mahasiswa");
            System.out.println("3. Update nilai");
            System.out.println("4. Tampilkan daftar");
            System.out.println("0. Kembali");
            pilihan = bacaAngka("Pilih: ");

            switch (pilihan) {
                case 1: {
                    String nim = bacaTeksWajib("NIM: ");
                    String nama = bacaTeksWajib("Nama: ");
                    int nilai = bacaNilai("Nilai (0-100): ");
                    if (daftarMahasiswa.addStudent(new Mahasiswa(nim, nama, nilai))) {
                        System.out.println("Mahasiswa ditambahkan.");
                    } else {
                        System.out.println("Gagal: NIM sudah terdaftar.");
                    }
                    break;
                }
                case 2: {
                    String nim = bacaTeksWajib("NIM yang dihapus: ");
                    if (daftarMahasiswa.removeStudent(nim)) {
                        System.out.println("Mahasiswa dihapus.");
                    } else {
                        System.out.println("NIM tidak ditemukan.");
                    }
                    break;
                }
                case 3: {
                    String nim = bacaTeksWajib("NIM yang diupdate: ");
                    int nilaiBaru = bacaNilai("Nilai baru (0-100): ");
                    if (daftarMahasiswa.updateNilai(nim, nilaiBaru)) {
                        System.out.println("Nilai berhasil diupdate.");
                    } else {
                        System.out.println("NIM tidak ditemukan.");
                    }
                    break;
                }
                case 4:
                    daftarMahasiswa.displayStudents();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    private static void tampilkanTeks() {
        System.out.println("Teks saat ini: \"" + editor.getCurrentText() + "\"");
    }

    private static int bacaAngka(String pesan) {
        while (true) {
            System.out.print(pesan);
            String masukan = scanner.nextLine().trim();
            try {
                return Integer.parseInt(masukan);
            } catch (NumberFormatException ex) {
                System.out.println("Input harus berupa angka bulat, coba lagi.");
            }
        }
    }

    private static int bacaNilai(String pesan) {
        while (true) {
            int nilai = bacaAngka(pesan);
            if (nilai >= 0 && nilai <= 100) {
                return nilai;
            }
            System.out.println("Nilai harus di antara 0 dan 100.");
        }
    }

    private static String bacaTeksWajib(String pesan) {
        while (true) {
            System.out.print(pesan);
            String masukan = scanner.nextLine().trim();
            if (!masukan.isEmpty()) {
                return masukan;
            }
            System.out.println("Input tidak boleh kosong.");
        }
    }
}
