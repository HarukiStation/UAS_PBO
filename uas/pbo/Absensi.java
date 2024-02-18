package uas.pbo;

class Absensi {
    private int nip;
    private String date;
    private int jamkerja;

    public Absensi(int nip, String date, int jamkerja) {
        this.nip = nip;
        this.date = date;
        this.jamkerja = jamkerja;
    }

    public int getJamkerja() {
        return jamkerja;
    }

    // Check kehadiran lebih dari jam 7 (keterlambatan)
    public int getTerlambat() {
        return Math.max(0, jamkerja - 7);
    }

    // Check pulang sebelum jam 16 (kekurangan jam)
    public int getJamKurang() {
        return Math.max(0, 16 - jamkerja);
    }
}
