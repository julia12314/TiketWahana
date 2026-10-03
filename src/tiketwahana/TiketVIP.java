/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;

/**
 *
 * @author USER
 */


public class TiketVIP extends Tiket {
    private boolean aksesFastTrack;
    private double biayaFasilitasVIP;

    public TiketVIP(String kodeTiket, String namaWahana, double hargaDasar, int stok, boolean aksesFastTrack, double biayaFasilitasVIP) {
        super(kodeTiket, namaWahana, hargaDasar, stok);
        this.aksesFastTrack = aksesFastTrack;
        setBiayaFasilitasVIP(biayaFasilitasVIP);
    }

    public boolean isAksesFastTrack() {
        return this.aksesFastTrack;
    }

    public void setAksesFastTrack(boolean aksesFastTrack) {
        this.aksesFastTrack = aksesFastTrack;
    }

    public double getBiayaFasilitasVIP() {
        return this.biayaFasilitasVIP;
    }

    public void setBiayaFasilitasVIP(double biayaFasilitasVIP) {
        if (biayaFasilitasVIP < 0) {
            this.biayaFasilitasVIP = 0;
        } else {
            this.biayaFasilitasVIP = biayaFasilitasVIP;
        }
    }

    @Override
    public double hitungHargaTiket() {
        return getHargaDasar() + this.biayaFasilitasVIP;
    }

    @Override
    public void tampilkanDetailTiket() {
        String statusStok = (getStok() > 0) ? String.valueOf(getStok()) : "SOLD OUT";
        String fastTrackStr = this.aksesFastTrack ? "Ya" : "Tidak";
        String infoTambahan = String.format("FT:%s, VIP:Rp%.0f", fastTrackStr, this.biayaFasilitasVIP);
        System.out.printf("| %-8s | %-8s | %-16s | Rp%-10.0f | %-25s | Rp%-10.0f | %-8s |%n",
                "VIP", getKodeTiket(), getNamaWahana(), getHargaDasar(), infoTambahan, hitungHargaTiket(), statusStok);
    }

    @Override
    public void cetakAturanAkses() {
        System.out.println("[Tiket VIP] Jalur Fast-Track bebas antre + Sertifikat/Akses Fasilitas Jalur Khusus VIP!");
    }
}