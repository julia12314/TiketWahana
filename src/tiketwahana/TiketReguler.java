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

    public TiketReguler(String kodeTiket, String namaWahana, double hargaDasar, int stok, double diskonHariKerja) throws Exception {
        super(kodeTiket, namaWahana, hargaDasar, stok);
        this.diskonHariKerja = diskonHariKerja;
    }

    @Override
    public double hitungHargaTiket() {
        return getHargaDasar() - (getHargaDasar() * (diskonHariKerja / 100));
    }

    @Override
    public void cetakAturanAkses() {
        System.out.println("[Tiket Reguler] Akses jalur antrean reguler.");
    }

    @Override
    public void tampilkanDetailTiket(int no) {
        String ket = String.format("Diskon: %.0f%%", diskonHariKerja);
        System.out.printf("| %-2d | Reguler  | %-8s | %-16s | Rp%-10.0f | %-25s | Rp%-10.0f | %-6d |\n",
                no, getKodeTiket(), getNamaWahana(), getHargaDasar(), ket, hitungHargaTiket(), getStok());
    }
}