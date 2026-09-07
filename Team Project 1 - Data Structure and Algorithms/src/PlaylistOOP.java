import java.util.Scanner;

class PlaylistOOP {
    public void main(String[] args) {
        Lagu[] playlist = new Lagu[5];
        Scanner scanner = new Scanner(System.in);

        playlist[0] = new Lagu("Antarlina", "Goodenough", 5.01);
        playlist[1] = new Lagu("Sorry, i quit!", "Hoolahoop", 3.47);

        Admin admin;
        Member member;

        bagianMenu(scanner, playlist);
    }

    void bagianMenu(Scanner scanner, Lagu[] playlist) {
        System.out.println("Pilih opsi: (1/2)");
        System.out.println("1. Login sebagai admin");
        System.out.println("2. Login sebagai member");

        int opt = Integer.parseInt(scanner.nextLine());

        if (opt == 1) {
            bagianAdmin(scanner, playlist);
        } else if (opt == 2) {
            bagianMember(scanner, playlist);
        } else {
            System.out.println("Opsi tidak terdaftar!!");
            bagianMenu(scanner, playlist);
        }
    }

    void bagianAdmin(Scanner scanner,  Lagu[] playlist) {
        Admin admin = new Admin("Jack");
        System.out.println("Pilih opsi: (1/2)");
        System.out.println("1. Tambahkan Lagu");
        System.out.println("2. Kembali ke menu");

        int opt = Integer.parseInt(scanner.nextLine());

        if (opt == 1) {
            System.out.print("Judul: ");
            String judul = scanner.nextLine();
            System.out.print("Artis: ");
            String artis = scanner.nextLine();
            System.out.print("Durasi: ");
            double durasi = Double.parseDouble(scanner.nextLine());

            playlist = admin.tambahLagu(playlist, new Lagu(judul, artis, durasi));
            bagianAdmin(scanner, playlist);
        } else if (opt == 2) {
            bagianMenu(scanner, playlist);
        } else {
            System.out.println("Opsi tidak terdaftar!!");
            bagianAdmin(scanner, playlist);
        }
    }

    void bagianMember(Scanner scanner, Lagu[] playlist) {
        Member member = new Member("Jean");
        System.out.println("Pilih opsi: (1/2)");
        System.out.println("1. Tampilkan semua lagu");
        System.out.println("2. Cari lagu");
        System.out.println("3. Kembali ke menu");

        int opt = Integer.parseInt(scanner.nextLine());

        if (opt == 1) {
            member.tampilkanSemuaLagu(playlist);
            bagianMember(scanner, playlist);
        } else if (opt == 2) {
            System.out.println("Masukan judul lagu yang ingin dicari:");
            String keyword = scanner.nextLine();
            member.cariLagu(playlist, keyword);
            bagianMember(scanner, playlist);
        } else if (opt == 3) {
            bagianMenu(scanner, playlist);
        } else {
            System.out.println("Opsi tidak terdaftar!!");
            bagianMember(scanner, playlist);
        }
    }
}
