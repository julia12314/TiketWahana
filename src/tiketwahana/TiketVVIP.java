/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;

/**
 *
 * @author USER
 */


// Menerapkan Multiple Implements (DapatFasilitas dan DapatAsuransi)
public class TiketVVIP extends Tiket implements DapatFasilitas, DapatAsuransi {
    private boolean aksesLounge;
    private double biayaSouvenirExclusif;

    public TiketVVIP(String kodeTiket, String namaWahana, double hargaDasar, int stok, boolean aksesLounge, double biayaSouvenirExclusif) {
        super(kodeTiket, namaWahana, hargaDasar, stok);
        this.aksesLounge = aksesLounge;
        this.biayaSouvenirExclusif = biayaSouvenirExclusif;
    }

    @Override
    public double hitungHargaTiket() {
        return getHargaDasar() + this.biayaSouvenirExclusif + 50000;
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
        System.out.println("[Tiket VVIP] Akses Jalur VIP Prioritas Tertinggi + Souvenir Merchandise Eksklusif!");
    }

    // Override method dari Interface DapatFasilitas
    @Override
    public void tampilkanFasilitasKhusus() {
        System.out.println("-> [Fasilitas Khusus] Akses prioritas naik sepuasnya tanpa antre & Merchandise Eksklusif.");
    }

    // Override method dari Interface DapatAsuransi
    @Override
    public void tampilkanInfoAsuransi() {
        System.out.println("-> [Asuransi VVIP] Perlindungan kecelakaan penuh senilai Rp20.000.000 selama bermain.");
    }
}