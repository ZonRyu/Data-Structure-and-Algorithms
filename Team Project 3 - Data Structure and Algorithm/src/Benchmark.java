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

import java.util.Locale;

// Mengukur waktu n operasi pada Queue, Stack, dan Linked List dengan System.nanoTime()
public class Benchmark {

    private static final int[] SIZES = {100, 1_000, 10_000};

    private static final String[] LABELS = {
        "Queue  enqueue x n",
        "Queue  serve x n",
        "Stack  addText x n",
        "Stack  undo x n",
        "Stack  redo x n",
        "List   addStudent x n",
        "List   updateNilai x n",
        "List   removeStudent x n"
    };

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            runAll(1_000);
        }

        long[][] hasil = new long[LABELS.length][SIZES.length];
        for (int s = 0; s < SIZES.length; s++) {
            long[] satuKolom = runAll(SIZES[s]);
            for (int r = 0; r < LABELS.length; r++) {
                hasil[r][s] = satuKolom[r];
            }
        }
        cetakTabel(hasil);
    }

    private static long[] runAll(int n) {
        return new long[] {
            benchQueueEnqueue(n),
            benchQueueServe(n),
            benchStackAdd(n),
            benchStackUndo(n),
            benchStackRedo(n),
            benchListAdd(n),
            benchListUpdate(n),
            benchListRemove(n)
        };
    }

    // Queue
    private static long benchQueueEnqueue(int n) {
        CustomerQueue q = new CustomerQueue();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            q.enqueue(new Customer("C" + i));
        }
        return System.nanoTime() - start;
    }

    private static long benchQueueServe(int n) {
        CustomerQueue q = new CustomerQueue();
        for (int i = 0; i < n; i++) q.enqueue(new Customer("C" + i)); //persiapan
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            q.serve();
        }
        return System.nanoTime() - start;
    }

    // Stack
    private static long benchStackAdd(int n) {
        TextEditor e = new TextEditor();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            e.addText("x");
        }
        return System.nanoTime() - start;
    }

    private static long benchStackUndo(int n) {
        TextEditor e = isiEditor(n);
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            e.undo();
        }
        return System.nanoTime() - start;
    }

    private static long benchStackRedo(int n) {
        TextEditor e = isiEditor(n);
        for (int i = 0; i < n; i++) e.undo();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            e.redo();
        }
        return System.nanoTime() - start;
    }

    private static TextEditor isiEditor(int n) {
        TextEditor e = new TextEditor();
        for (int i = 0; i < n; i++) e.addText("x");
        return e;
    }

    // Linked List
    private static long benchListAdd(int n) {
        StudentList list = new StudentList();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.addStudent(new Mahasiswa(String.valueOf(i), "M" + i, 80));
        }
        return System.nanoTime() - start;
    }

    private static long benchListUpdate(int n) {
        StudentList list = isiList(n);
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.updateNilai(String.valueOf(i), 90);
        }
        return System.nanoTime() - start;
    }

    private static long benchListRemove(int n) {
        StudentList list = isiList(n);
        long start = System.nanoTime();
        for (int i = n - 1; i >= 0; i--) {
            list.removeStudent(String.valueOf(i));
        }
        return System.nanoTime() - start;
    }

    private static StudentList isiList(int n) {
        StudentList list = new StudentList();
        for (int i = 0; i < n; i++) {
            list.addStudent(new Mahasiswa(String.valueOf(i), "M" + i, 80));
        }
        return list;
    }

    // Output
    private static void cetakTabel(long[][] hasil) {
        System.out.println("\n[HASIL BENCHMARK (satuan: mikrodetik, total n operasi)]");
        System.out.printf("%-26s", "Operasi");
        for (int n : SIZES) {
            System.out.printf("%16s", "n = " + n);
        }
        System.out.println();
        System.out.println("-".repeat(26 + 16 * SIZES.length));

        for (int r = 0; r < LABELS.length; r++) {
            System.out.printf("%-26s", LABELS[r]);
            for (int s = 0; s < SIZES.length; s++) {
                System.out.printf("%16s", String.format(Locale.US, "%.1f", hasil[r][s] / 1000.0));
            }
            System.out.println();
        }
    }
}