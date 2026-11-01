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

    public TiketVIP(String kodeTiket, String namaWahana, double hargaDasar, int stok, boolean aksesFastTrack, double biayaFasilitasVIP) throws Exception {
        super(kodeTiket, namaWahana, hargaDasar, stok);
        this.aksesFastTrack = aksesFastTrack;
        this.biayaFasilitasVIP = biayaFasilitasVIP;
    }

    @Override
    public double hitungHargaTiket() {
        return getHargaDasar() + biayaFasilitasVIP;
    }

    @Override
    public void cetakAturanAkses() {
        System.out.println("[Tiket VIP] Akses jalur cepat (Fast Track).");
    }

    @Override
    public void tampilkanFasilitasKhusus() {
        System.out.println("-> [Fasilitas VIP] Akses prioritas jalur antrean khusus.");
    }

    @Override
    public void tampilkanDetailTiket(int no) {
        String ket = "FastTrack: " + (aksesFastTrack ? "Ya" : "Tidak");
        System.out.printf("| %-2d | VIP      | %-8s | %-16s | Rp%-10.0f | %-25s | Rp%-10.0f | %-6d |\n",
                no, getKodeTiket(), getNamaWahana(), getHargaDasar(), ket, hitungHargaTiket(), getStok());
    }
}