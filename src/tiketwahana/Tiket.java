/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;
import java.io.Serializable;

/**
 *
 * @author USER
 */
public abstract class Tiket implements Serializable {
    private static final long serialVersionUID = 1L;
    private String kodeTiket;
    private String namaWahana;
    private double hargaDasar;
    private int stok;
    
    public static int totalTiketBerhasilDibuat = 0;

    public Tiket(String kodeTiket, String namaWahana, double hargaDasar, int stok) throws Exception {
        if (hargaDasar < 0 || stok < 0) {
            throw new Exception("Harga dasar atau stok tidak boleh bernilai negatif!");
        }
        this.kodeTiket = kodeTiket;
        this.namaWahana = namaWahana;
        this.hargaDasar = hargaDasar;
        this.stok = stok;
        totalTiketBerhasilDibuat++;
    }

    public String getKodeTiket() { return this.kodeTiket; }
    public String getNamaWahana() { return this.namaWahana; }
    public double getHargaDasar() { return this.hargaDasar; }
    public int getStok() { return this.stok; }

    public void setHargaDasar(double hargaDasar) {
        this.hargaDasar = (hargaDasar < 0) ? 0 : hargaDasar;
    }

    public void setStok(int stok) {
        this.stok = (stok < 0) ? 0 : stok;
    }

    public abstract double hitungHargaTiket();
    public abstract void cetakAturanAkses();
    public abstract void tampilkanDetailTiket(int no);
}