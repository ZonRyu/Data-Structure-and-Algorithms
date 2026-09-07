public class Lagu {
    String judul;
    String artis;
    double durasi;

    Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    void tampilkanInfo(){
        System.out.println(this.judul + " - " + this.artis + ", " + this.durasi);
    }
}