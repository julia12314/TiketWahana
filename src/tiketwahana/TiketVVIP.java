/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;

/**
 *
 * @author USER
 */

public class TiketVVIP extends Tiket implements DapatFasilitas, DapatAsuransi {
    private boolean aksesLounge;
    private double biayaSouvenirExclusif;

    public TiketVVIP(String kodeTiket, String namaWahana, double hargaDasar, int stok, boolean aksesLounge, double biayaSouvenirExclusif) throws Exception {
        super(kodeTiket, namaWahana, hargaDasar, stok);
        this.aksesLounge = aksesLounge;
        this.biayaSouvenirExclusif = biayaSouvenirExclusif;
    }

    @Override
    public double hitungHargaTiket() {
        return getHargaDasar() + this.biayaSouvenirExclusif + 50000;
    }

    @Override
    public void cetakAturanAkses() {
        System.out.println("[Tiket VVIP] Akses Jalur VIP Prioritas Tertinggi!");
    }

    @Override
    public void tampilkanFasilitasKhusus() {
        System.out.println("-> [Fasilitas Khusus VVIP] Akses lounge eksklusif & merchandise.");
    }

    @Override
    public void tampilkanInfoAsuransi() {
        System.out.println("-> [Asuransi VVIP] Perlindungan kecelakaan penuh selama bermain.");
    }

    @Override
    public void tampilkanDetailTiket(int no) {
        String ket = "Lounge & Souvenir";
        System.out.printf("| %-2d | VVIP     | %-8s | %-16s | Rp%-10.0f | %-25s | Rp%-10.0f | %-6d |\n",
                no, getKodeTiket(), getNamaWahana(), getHargaDasar(), ket, hitungHargaTiket(), getStok());
    }
}