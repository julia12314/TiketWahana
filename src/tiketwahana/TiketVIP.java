/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;

/**
 *
 * @author USER
 */
public class TiketVIP extends Tiket implements DapatFasilitas {
    private boolean aksesFastTrack;
    private double biayaFasilitasVIP;
    

    public TiketVIP(String kodeTiket, String namaWahana, double hargaDasar, int stok, boolean aksesFastTrack, double biayaFasilitasVIP) {
        super(kodeTiket, namaWahana, hargaDasar, stok);
        this.aksesFastTrack = aksesFastTrack;
        this.biayaFasilitasVIP = biayaFasilitasVIP;
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
        System.out.println("[Tiket VIP] Jalur Fast-Track bebas antre.");
    }

    @Override
    public void tampilkanFasilitasKhusus() {
        System.out.println("-> [Fasilitas Khusus] Mendapatkan jalur prioritas dan gratis cetak foto aksi wahana.");
    }
}