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
        String fastTrackStr = this.aksesFastTrack ? "Ya" : "Tidak";
        String statusStok = (getStok() > 0) ? String.valueOf(getStok()) : "SOLD OUT";
        System.out.printf("[VIP]     Kode: %-7s | Wahana: %-15s | Harga: Rp%-9.0f | FastTrack: %-3s | VIP Fee: Rp%-7.0f | Total: Rp%-9.0f | Stok: %-8s%n",
                getKodeTiket(), getNamaWahana(), getHargaDasar(), fastTrackStr, this.biayaFasilitasVIP, hitungHargaTiket(), statusStok);
    }
}

    

    

