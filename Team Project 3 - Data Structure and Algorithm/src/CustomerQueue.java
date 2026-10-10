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

// Queue menggunakan Linked List dengan prinsip FIFO dan menggunakan front & rear

public class CustomerQueue {

    private static class NodePelanggan {
        private Customer data;
        private NodePelanggan next;

        public NodePelanggan(Customer data) {
            this.data = data;
            this.next = null; // Di awal, belum menunjuk ke manapun
        }

        public Customer getData() {
            return data;
        }

        public NodePelanggan getNext() {
            return next;
        }

        public void setNext(NodePelanggan next) {
            this.next = next;
        }
    }

    private NodePelanggan front; // pelanggan paling depan akan dilayani lebih dulu
    private NodePelanggan rear;  // pelanggan paling belakang yang baru masuk
    private int size;            // jumlah pelanggan

    // constructor: antrean baru masih kosong
    public CustomerQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Cek antrean kosong atau tidak. Kalau front null berarti belum ada siapa-siapa.
    // Kompleksitas O(1)
    public boolean isEmpty() {
        return front == null;
    }

    // Mengembalikan jumlah pelanggan di antrean
    public int size() {
        return size;
    }

    // ENQUEUE: tambah pelanggan baru di BELAKANG antrean.
    // O(1) karena ada rear
    public void enqueue(Customer customer) {
        // kalau null, tidak usah diproses
        if (customer == null) {
            return;
        }

        NodePelanggan nodeBaru = new NodePelanggan(customer);

        if (isEmpty()) {
            // kasus pertama: antrean masih kosong, sehingga node baru menjadi front sekaligus rear
            front = nodeBaru;
            rear = nodeBaru;
        } else {
            // kasus biasa: menyambungkan ke belakang rear yang lama, lalu rear dipindah ke node baru
            rear.setNext(nodeBaru);
            rear = nodeBaru;
        }
        size++;
    }

    // DEQUEUE: Melayani pelanggan paling depan, lalu hapus dari antrean.
    // Mengembalikan pelanggan yang dilayani, atau null kalau antrean kosong. O(1).
    public Customer serve() {
        // kalau kosong ga ada yang bisa dilayani
        if (isEmpty()) {
            return null;
        }

        Customer dilayani = front.getData(); // menyimpan dulu sebelum front digeser
        front = front.getNext();             // front pindah ke pelanggan berikutnya

        if (front == null) {
            rear = null;
        }
        size--;
        return dilayani;
    }

    // Menampilkan semua pelanggan dari depan ke belakang. O(n)
    public void display() {
        if (isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }

        System.out.println("Pelanggan dalam antrean:");
        NodePelanggan current = front; // mulai dari depan
        int nomor = 1;
        while (current != null) {
            System.out.println(nomor + ". " + current.getData().getName());
            current = current.getNext(); // geser ke node berikutnya
            nomor++;
        }
    }
}