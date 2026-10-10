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

// Single Linked List --> daftar nilai mahasiswa

public class StudentList {
    private Node head;
    private Node tail;
    private int size;

    // Tambah di belakang. False jika data null atau NIM sudah ada
    public boolean addStudent(Mahasiswa m) {
        if (m == null || findNode(m.getNim()) != null) return false;

        Node baru = new Node(m);
        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            tail.setNext(baru);
            tail = baru;
        }
        size++;
        return true;
    }

    // Hapus berdasarkan NIM. False jika tidak ditemukan
    public boolean removeStudent(String nim) {
        if (head == null) return false;

        // kasus 1: yang dihapus adalah head
        if (head.getData().getNim().equals(nim)) {
            head = head.getNext();
            if (head == null) tail = null; // list jadi kosong
            size--;
            return true;
        }

        Node prev = head;
        Node cur = head.getNext();
        while (cur != null) {
            if (cur.getData().getNim().equals(nim)) {
                prev.setNext(cur.getNext());
                if (cur == tail) tail = prev; 
                size--;
                return true;
            }
            prev = cur;
            cur = cur.getNext();
        }
        return false;
    }

    // Update nilai berdasarkan NIM. False jika NIM tidak ada atau nilai di luar 0-100
    public boolean updateNilai(String nim, int nilaiBaru) {
        if (nilaiBaru < 0 || nilaiBaru > 100) return false;
        Node n = findNode(nim);
        if (n == null) return false;
        n.getData().setNilai(nilaiBaru);
        return true;
    }

    public void displayStudents() {
        displayStudents("Daftar Mahasiswa:");
    }

    public void displayStudents(String title) {
        System.out.println(title);
        if (head == null) {
            System.out.println("(daftar kosong)");
            return;
        }
        Node cur = head;
        int no = 1;
        while (cur != null) {
            System.out.println(no + ". " + cur.getData());
            cur = cur.getNext();
            no++;
        }
    }

    public int size() { return size; }
    public boolean isEmpty() { return head == null; }

    private Node findNode(String nim) {
        Node cur = head;
        while (cur != null) {
            if (cur.getData().getNim().equals(nim)) return cur;
            cur = cur.getNext();
        }
        return null;
    }
}