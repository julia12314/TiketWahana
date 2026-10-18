/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;

/**
 *
 * @author USER
 */
public class TiketReguler extends Tiket {
    private double diskonHariKerja;

    public TiketReguler(String kodeTiket, String namaWahana, double hargaDasar, int stok, double diskonHariKerja) {
        super(kodeTiket, namaWahana, hargaDasar, stok);
        this.diskonHariKerja = diskonHariKerja;
    }

    @Override
    public double hitungHargaTiket() {
        return getHargaDasar() - (getHargaDasar() * (this.diskonHariKerja / 100.0));
    }

    @Override
    public void tampilkanDetailTiket() {
        String statusStok = (getStok() > 0) ? String.valueOf(getStok()) : "SOLD OUT";
        String infoTambahan = String.format("Diskon: %.0f%%", this.diskonHariKerja);
        System.out.printf("| %-8s | %-8s | %-16s | Rp%-10.0f | %-25s | Rp%-10.0f | %-8s |%n",
                "REGULER", getKodeTiket(), getNamaWahana(), getHargaDasar(), infoTambahan, hitungHargaTiket(), statusStok);
    }

    @Override
    public void cetakAturanAkses() {
        System.out.println("[Tiket Reguler] Jalur antrean standar harian.");
    }
}