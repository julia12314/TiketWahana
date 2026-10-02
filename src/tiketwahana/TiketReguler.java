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
        setDiskonHariKerja(diskonHariKerja);
    }

    public double getDiskonHariKerja() {
        return this.diskonHariKerja;
    }

    public void setDiskonHariKerja(double diskonHariKerja) {
        if (diskonHariKerja < 0 || diskonHariKerja > 100) {
            System.out.println("[Peringatan] Diskon harus rentang 0-100%! Diset ke 0.");
            this.diskonHariKerja = 0;
        } else {
            this.diskonHariKerja = diskonHariKerja;
        }
    }
    
    
}
