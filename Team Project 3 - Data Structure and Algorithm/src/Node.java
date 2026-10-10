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

// single linked list: data Mahasiswa + pointer ke simpul berikutnya.
public class Node {
    private Mahasiswa data;
    private Node next;

    public Node(Mahasiswa data) {
        this.data = data;
    }

    public Mahasiswa getData() { return data; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
}