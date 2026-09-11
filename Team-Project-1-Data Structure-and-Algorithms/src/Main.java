import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lagu[] playlist = new Lagu[2];

        playlist[0] = new Lagu("Cico Buff", "Cocteau Twins", 3.15);
        playlist[1] = new Lagu("Hoppipola", "Sigur Ros", 3.0);

        login(scanner, playlist);
        scanner.close();
    }

    static void login(Scanner scanner, Lagu[] playlist) {
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n===== Selamat Datang =====");
            System.out.println("Login Sebagai :");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.println("3. Keluar");

            System.out.print("\nInput : ");
            int opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    Admin admin = new Admin("Admin 1");
                    System.out.println("Selamat datang, " + admin.getNama());

                    playlist = menuAdmin(scanner, admin, playlist);
                    break;
                case 2:
                    Member member = new Member("John Doe");
                    System.out.println("Selamat datang, " + member.getNama());

                    menuMember(scanner, member, playlist);
                    break;
                case 3:
                    lanjut = false;
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
                    break;
            }
        }
    }

    static Lagu[] menuAdmin(Scanner scanner, Admin admin, Lagu[] playlist) {
        boolean lanjut = true;

        while(lanjut) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Tampilkan Semua Lagu");
            System.out.println("2. Tambah Lagu");
            System.out.println("3. logout");

            System.out.print("\nInput : ");
            int opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    admin.tampilkanSemuaLagu(playlist);
                    break;
                case 2:
                    scanner.nextLine(); // Membersihkan newline character dari input sebelumnya
                    System.out.print("Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Artis: ");
                    String artis = scanner.nextLine();
                    System.out.print("Durasi: ");
                    double durasi = Double.parseDouble(scanner.nextLine());

                    playlist = admin.tambahLagu(playlist, new Lagu(judul, artis, durasi));
                    System.out.println("Lagu berhasil ditambahkan!");
                    break;
                case 3:
                    lanjut = false;
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
                    break;
            }
        }

        return playlist;
    }

    static void menuMember(Scanner scanner, Member member, Lagu[] playlist) {
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Tampilkan Semua Lagu");
            System.out.println("2. Cari Lagu");
            System.out.println("3. logout");

            System.out.print("\nInput : ");
            int opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    member.tampilkanSemuaLagu(playlist);
                    break;
                case 2:
                    scanner.nextLine(); // Membersihkan newline character dari input sebelumnya
                    System.out.println("Masukkan judul lagu yang ingin dicari: ");
                    String keyword = scanner.nextLine();
                    member.cariLagu(playlist, keyword);
                    break;
                case 3: 
                    lanjut = false;
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
                    break;
            }
        }
    }
}
