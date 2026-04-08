public class Peminjaman22 {
    private Mahasiswa22 mahasiswa;
    private Buku22      buku;
    private int       lamaPinjam;
    private int       keterlambatan;
    private int       totalDenda;

    private static final int BATAS_PINJAM  = 5;
    private static final int DENDA_PER_HARI = 2000;

    public Peminjaman22(Mahasiswa22 mahasiswa, Buku22 buku, int lamaPinjam) {
        this.mahasiswa  = mahasiswa;
        this.buku       = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }

    public void hitungDenda() {
        if (lamaPinjam > BATAS_PINJAM) {
            this.keterlambatan = lamaPinjam - BATAS_PINJAM;
            this.totalDenda    = keterlambatan * DENDA_PER_HARI;
        } else {
            this.keterlambatan = 0;
            this.totalDenda    = 0;
        }
    }

    public Mahasiswa22 getMahasiswa()     { return mahasiswa; }
    public Buku22      getBuku()          { return buku; }
    public int       getLamaPinjam()    { return lamaPinjam; }
    public int       getKeterlambatan() { return keterlambatan; }
    public int       getTotalDenda()    { return totalDenda; }
}