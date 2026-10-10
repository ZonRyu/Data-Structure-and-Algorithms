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

import java.util.Stack;

public class TextEditor {

    // Teks yang sedang tampil di editor
    private final StringBuilder text;

    // Riwayat perubahan yang dapat dibatalkan (undo)
    private final Stack<String> undoStack;

    // Riwayat perubahan yang dapat dikembalikan (redo)
    private final Stack<String> redoStack;

    // Membuat editor baru dengan teks kosong dan riwayat kosong.
    public TextEditor() {
        text = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    // Menambahkan teks baru di akhir teks
    public void addText(String newText) {
        if (newText == null || newText.isEmpty()) {
            return;
        }
        text.append(newText);
        undoStack.push(newText); // menyimpan potongan teks agar bisa dibatalkan
        redoStack.clear();
    }

    // Membatalkan perubahan terakhir. Potongan teks yang dibatalkan dipindahkan ke redoStack agar dapat dikembalikan.
    public boolean undo() {
        if (undoStack.isEmpty()) {
            return false; // mencegah EmptyStackException
        }
        String potongan = undoStack.pop();
        text.setLength(text.length() - potongan.length()); // hapus potongan dari akhir teks
        redoStack.push(potongan);
        return true;
    }

    //Redo
    public boolean redo() {
        if (redoStack.isEmpty()) {
            return false;
        }
        String potongan = redoStack.pop();
        text.append(potongan);
        undoStack.push(potongan);
        return true;
    }

    //teks yang sedang tampil di editor
    public String getCurrentText() {
        return text.toString();
    }

    //true jika masih ada perubahan yang dapat di-undo
    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    //true jika masih ada perubahan yang dapat di-redo
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
}