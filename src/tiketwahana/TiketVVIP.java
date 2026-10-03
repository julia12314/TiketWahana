/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;

/**
 *
 * @author USER
 */

public class TiketVVIP extends Tiket {
    private boolean aksesLounge;
    private double biayaSouvenirExclusif;

    public TiketVVIP(String kodeTiket, String namaWahana, double hargaDasar, int stok, boolean aksesLounge, double biayaSouvenirExclusif) {
        super(kodeTiket, namaWahana, hargaDasar, stok);
        this.aksesLounge = aksesLounge;
        setBiayaSouvenirExclusif(biayaSouvenirExclusif);
    }

    public boolean isAksesLounge() {
        return this.aksesLounge;
    }

    public void setAksesLounge(boolean aksesLounge) {
        this.aksesLounge = aksesLounge;
    }

    public double getBiayaSouvenirExclusif() {
        return this.biayaSouvenirExclusif;
    }

    public void setBiayaSouvenirExclusif(double biayaSouvenirExclusif) {
        if (biayaSouvenirExclusif < 0) {
            this.biayaSouvenirExclusif = 0;
        } else {
            this.biayaSouvenirExclusif = biayaSouvenirExclusif;
        }
    }

    @Override
    public double hitungHargaTiket() {
        return getHargaDasar() + this.biayaSouvenirExclusif + 50000; // Layanan Penuh VVIP Tambahan 50rb
    }

    @Override
    public void tampilkanDetailTiket() {
        String statusStok = (getStok() > 0) ? String.valueOf(getStok()) : "SOLD OUT";
        String loungeStr = this.aksesLounge ? "Ya" : "Tidak";
        String infoTambahan = String.format("Lounge:%s, Souvenir:Rp%.0f", loungeStr, this.biayaSouvenirExclusif);
        System.out.printf("| %-8s | %-8s | %-16s | Rp%-10.0f | %-25s | Rp%-10.0f | %-8s |%n",
                "VVIP", getKodeTiket(), getNamaWahana(), getHargaDasar(), infoTambahan, hitungHargaTiket(), statusStok);
    }

    @Override
    public void cetakAturanAkses() {
        System.out.println("[Tiket VVIP] Akses Jalur Khusus + Akses VVIP Lounge Mewah + Souvenir Merchandise Eksklusif!");
    }
}   

