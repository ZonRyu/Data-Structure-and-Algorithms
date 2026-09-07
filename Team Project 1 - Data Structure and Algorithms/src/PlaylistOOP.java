import java.util.Scanner;

class PlaylistOOP {
    public void main(String[] args) {
        Lagu[] playlist = new Lagu[5];
        Scanner scanner = new Scanner(System.in);

        playlist[0] = new Lagu("Antarlina", "Goodenough", 5.01);
//        playlist[1] = new Lagu("Antarlina", "Goodenough", 5.01);

        Admin admin = new Admin("Jek");
        Member member = new Member("Didi");

        playlist = admin.tambahLagu(playlist, new Lagu("Sorry, i quit!", "Hoolahoop", 3.47));

        member.tampilkanSemuaLagu(playlist);

        bagianMenu(scanner);
    }

    void bagianMenu(Scanner scanner) {
        System.out.println("Pilih opsi: (1/2)");
        System.out.println("1. Login sebagai admin");
        System.out.println("2. Login sebagai member");

        int opt = Integer.parseInt(scanner.nextLine());

        if (opt == 1) {
            bagianAdmin(scanner);
        } else if (opt == 2) {
            bagianMember(scanner);
        } else {
            System.out.println("Opsi tidak terdaftar!!");
            bagianMenu(scanner);
        }
    }

    void bagianAdmin(Scanner scanner) {
        System.out.println("Pilih opsi: (1/2)");
        System.out.println("1. Tambahkan Lagu");
        System.out.println("2. Kembali ke menu");

        int opt = Integer.parseInt(scanner.nextLine());

        if (opt == 1) {
            String judul =
        }
    }

    void bagianMember(Scanner scanner) {
        System.out.println("Pilih opsi: (1/2)");
        System.out.println("1. Tampilkan semua lagu");
        System.out.println("2. Cari lagu");
        System.out.println("3. Kembali ke menu");
    }
}
