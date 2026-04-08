import java.util.Scanner;

public class PerpustakaanMain22 {

    // ===================== DATA AWAL =====================
    static Mahasiswa22[] dataMahasiswa = {
        new Mahasiswa22("22001", "Andi",  "Teknik Informatika"),
        new Mahasiswa22("22002", "Budi",  "Teknik Informatika"),
        new Mahasiswa22("22003", "Citra", "Sistem Informasi Bisnis")
    };

    static Buku22[] dataBuku = {
        new Buku22("B001", "Algoritma",   2020),
        new Buku22("B002", "Basis Data",  2019),
        new Buku22("B003", "Pemrograman", 2021),
        new Buku22("B004", "Fisika",      2024)
    };

    static Peminjaman22[] dataPeminjaman = {
        new Peminjaman22(dataMahasiswa[0], dataBuku[0], 7),   // Andi  - Algoritma   - 7 hari
        new Peminjaman22(dataMahasiswa[1], dataBuku[1], 3),   // Budi  - Basis Data  - 3 hari
        new Peminjaman22(dataMahasiswa[2], dataBuku[2], 10),  // Citra - Pemrograman - 10 hari
        new Peminjaman22(dataMahasiswa[2], dataBuku[3], 6),   // Citra - Fisika      - 6 hari
        new Peminjaman22(dataMahasiswa[0], dataBuku[1], 4)    // Andi  - Basis Data  - 4 hari
    };

    // ===================== MENU 1 =====================
    static void tampilkanDataBukuDanMahasiswa() {
        System.out.println("\n========================================");
        System.out.println("          DATA MAHASISWA                ");
        System.out.println("========================================");
        System.out.printf("%-10s %-20s %-25s%n", "NIM", "Nama", "Prodi");
        System.out.println("------------------------------------------");
        for (Mahasiswa22 m : dataMahasiswa) {
            System.out.println(m);
        }

        System.out.println("\n========================================");
        System.out.println("             DATA BUKU                  ");
        System.out.println("========================================");
        System.out.printf("%-10s %-20s %-15s%n", "Kode Buku", "Judul", "Tahun Terbit");
        System.out.println("------------------------------------------");
        for (Buku22 b : dataBuku) {
            System.out.println(b);
        }
    }

    // ===================== MENU 2 =====================
    static void tampilkanDataPeminjaman() {
        System.out.println("\n========================================");
        System.out.println("         DATA PEMINJAMAN BUKU           ");
        System.out.println("========================================");
        System.out.printf("%-8s %-10s %-20s %-15s%n",
                "NIM", "Nama", "Judul Buku", "Lama Pinjam");
        System.out.println("--------------------------------------------------");
        for (Peminjaman22 p : dataPeminjaman) {
            System.out.printf("%-8s %-10s %-20s %-2d hari%n",
                    p.getMahasiswa().getNim(),
                    p.getMahasiswa().getNama(),
                    p.getBuku().getJudul(),
                    p.getLamaPinjam());
        }
    }

    // ===================== MENU 3 =====================
    static void tampilkanDenda() {
        System.out.println("\n========================================");
        System.out.println("     PERHITUNGAN DENDA KETERLAMBATAN    ");
        System.out.println("========================================");
        System.out.printf("%-8s %-10s %-15s %-12s %-15s %-15s%n",
                "NIM", "Nama", "Judul Buku", "Lama Pinjam", "Keterlambatan", "Total Denda");
        System.out.println("------------------------------------------------------------------------");
        for (Peminjaman22 p : dataPeminjaman) {
            System.out.printf("%-8s %-10s %-15s %-12d %-15d Rp %-10d%n",
                    p.getMahasiswa().getNim(),
                    p.getMahasiswa().getNama(),
                    p.getBuku().getJudul(),
                    p.getLamaPinjam(),
                    p.getKeterlambatan(),
                    p.getTotalDenda());
        }
    }

    // ===================== MENU 4 — Insertion Sort =====================
    static void sortingByDenda() {
        // Salin array agar data asli tidak berubah
        Peminjaman22[] sorted = dataPeminjaman.clone();
        int n = sorted.length;

        // Insertion Sort descending berdasarkan totalDenda
        for (int i = 1; i < n; i++) {
            Peminjaman22 key = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j].getTotalDenda() < key.getTotalDenda()) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            sorted[j + 1] = key;
        }

        System.out.println("\n========================================");
        System.out.println("  DATA PEMINJAMAN (Urut Denda Terbesar) ");
        System.out.println("     [Algoritma: Insertion Sort]        ");
        System.out.println("========================================");
        System.out.printf("%-5s %-8s %-10s %-15s %-12s %-15s%n",
                "No", "NIM", "Nama", "Judul Buku", "Lama Pinjam", "Total Denda");
        System.out.println("------------------------------------------------------------------------");
        for (int i = 0; i < sorted.length; i++) {
            Peminjaman22 p = sorted[i];
            System.out.printf("%-5d %-8s %-10s %-15s %-12d Rp %-10d%n",
                    (i + 1),
                    p.getMahasiswa().getNim(),
                    p.getMahasiswa().getNama(),
                    p.getBuku().getJudul(),
                    p.getLamaPinjam(),
                    p.getTotalDenda());
        }
    }

    // ===================== MENU 5 — Binary Search =====================
    static void searchingByNim(Scanner sc) {
        System.out.print("\nMasukkan NIM yang dicari: ");
        String nimCari = sc.nextLine().trim();

        // Salin & urutkan ascending berdasarkan NIM (syarat Binary Search)
        Peminjaman22[] sorted = dataPeminjaman.clone();
        int n = sorted.length;

        for (int i = 1; i < n; i++) {
            Peminjaman22 key = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j].getMahasiswa().getNim()
                    .compareTo(key.getMahasiswa().getNim()) > 0) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            sorted[j + 1] = key;
        }

        // Binary Search
        int low = 0, high = sorted.length - 1, found = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = sorted[mid].getMahasiswa().getNim().compareTo(nimCari);
            if (cmp == 0) { found = mid; break; }
            else if (cmp < 0) low  = mid + 1;
            else              high = mid - 1;
        }

        System.out.println("\n========================================");
        System.out.println("   HASIL PENCARIAN (Binary Search)      ");
        System.out.println("========================================");

        if (found == -1) {
            System.out.println("Data peminjaman dengan NIM " + nimCari + " tidak ditemukan.");
        } else {
            System.out.printf("%-8s %-10s %-15s %-12s %-15s %-15s%n",
                    "NIM", "Nama", "Judul Buku", "Lama Pinjam", "Keterlambatan", "Total Denda");
            System.out.println("------------------------------------------------------------------------");

            // Kumpulkan semua data dengan NIM yang sama
            int start = found;
            while (start > 0 && sorted[start - 1].getMahasiswa().getNim().equals(nimCari)) {
                start--;
            }
            for (int i = start; i < sorted.length; i++) {
                if (!sorted[i].getMahasiswa().getNim().equals(nimCari)) break;
                Peminjaman22 p = sorted[i];
                System.out.printf("%-8s %-10s %-15s %-12d %-15d Rp %-10d%n",
                        p.getMahasiswa().getNim(),
                        p.getMahasiswa().getNama(),
                        p.getBuku().getJudul(),
                        p.getLamaPinjam(),
                        p.getKeterlambatan(),
                        p.getTotalDenda());
            }
        }
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n========================================");
            System.out.println("  SISTEM MANAJEMEN PEMINJAMAN BUKU JTI  ");
            System.out.println("========================================");
            System.out.println("1. Tampilkan Data Buku dan Mahasiswa");
            System.out.println("2. Tampilkan Data Peminjaman");
            System.out.println("3. Hitung Keterlambatan dan Denda");
            System.out.println("4. Urutkan Data Berdasarkan Denda Terbesar");
            System.out.println("5. Cari Data Peminjaman Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.println("========================================");
            System.out.print("Pilih menu: ");

            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1: tampilkanDataBukuDanMahasiswa(); break;
                case 2: tampilkanDataPeminjaman();       break;
                case 3: tampilkanDenda();                break;
                case 4: sortingByDenda();                break;
                case 5: searchingByNim(sc);              break;
                case 0: System.out.println("\nTerima kasih. Program selesai."); break;
                default: System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}