public class Buku22 {
    private String kodeBuku;
    private String judul;
    private int    tahunTerbit;

    public Buku22(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku    = kodeBuku;
        this.judul       = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKodeBuku()    { return kodeBuku; }
    public String getJudul()       { return judul; }
    public int    getTahunTerbit() { return tahunTerbit; }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15d", kodeBuku, judul, tahunTerbit);
    }
}