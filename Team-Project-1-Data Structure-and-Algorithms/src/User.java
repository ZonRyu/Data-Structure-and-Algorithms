public class User {
    private String nama;

    protected User(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void tampilkanSemuaLagu(Lagu[] playlist) {
        System.out.println("\n===== Daftar Lagu =====");

        for (Lagu lagu : playlist) {
            if (lagu == null) {
                break;
            }

            lagu.tampilkanInfo();
        }
    }
}
