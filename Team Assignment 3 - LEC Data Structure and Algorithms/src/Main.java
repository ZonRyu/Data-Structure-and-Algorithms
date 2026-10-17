/*
Tugas Kelompok 3 - [LEC] Data Structures and Algorithm Analysis
Group 2 - Anggota:
1. Julyon Putra Sannie      / 2902816550
2. Dede Rukmana             / 2902830366
3. Faiza Shifa Medina       / 2902826034
4. Bima Galaxy Putra        / 2902819464
5. Muhammad Taufiq Al Hakim / 2902820775
*/

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\n===== MENU =====");
            System.out.println("Pilih jumlah lagu untuk melakukan pengetesan:");
            System.out.println("1. Pengetesan 3 lagu");
            System.out.println("2. Pengetesan 5 lagu");
            System.out.println("3. Pengetesan 10 lagu");
            System.out.println("4. Keluar");
            int pilihan = bacaAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    test3Lagu();
                    break;
                case 2:
                    test5Lagu();
                    break;
                case 3:
                    test10Lagu();
                    break;
                case 4:
                    lanjut = false;
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void test3Lagu() {
        final Lagu[] playlist = {
            new Lagu("Antarlina", "Goodenough", 5.01),
            new Lagu("Sorry, i quit!", "Hoolahoop", 3.47),
            new Lagu("Cico Buff", "Cocteau Twins", 3.47)
        };

        Benchmark.test(playlist);
    }

    public static void test5Lagu() {
        final Lagu[] playlist = {
            new Lagu("Antarlina", "Goodenough", 5.01),
            new Lagu("Sorry, i quit!", "Hoolahoop", 3.47),
            new Lagu("Cico Buff", "Cocteau Twins", 3.47),
            new Lagu("Hoppipolla", "Sigur Ros", 4.28),
            new Lagu("Under Pressure", "David Bowie", 4.07)
        };

        Benchmark.test(playlist);
    }

    public static void test10Lagu() {
        final Lagu[] playlist = {
            new Lagu("Antarlina", "Goodenough", 5.01),
            new Lagu("Sorry, i quit!", "Hoolahoop", 3.47),
            new Lagu("Cico Buff", "Cocteau Twins", 3.47),
            new Lagu("Hoppipolla", "Sigur Ros", 4.28),
            new Lagu("Under Pressure", "David Bowie", 4.07),
            new Lagu("Bohemian Rhapsody", "Queen", 5.55),
            new Lagu("Stairway to Heaven", "Led Zeppelin", 8.02),
            new Lagu("Imagine", "John Lennon", 3.03),
            new Lagu("Hotel California", "Eagles", 6.30),
            new Lagu("Smells Like Teen Spirit", "Nirvana", 5.01)
        };

        Benchmark.test(playlist);
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
}
