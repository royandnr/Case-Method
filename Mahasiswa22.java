public class Mahasiswa22 {
    private String nim;
    private String nama;
    private String prodi;

    public Mahasiswa22(String nim, String nama, String prodi) {
        this.nim   = nim;
        this.nama  = nama;
        this.prodi = prodi;
    }

    public String getNim()   { return nim; }
    public String getNama()  { return nama; }
    public String getProdi() { return prodi; }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-25s", nim, nama, prodi);
    }
}