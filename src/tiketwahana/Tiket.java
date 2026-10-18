/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;

/**
 *
 * @author USER
 */
public abstract class Tiket {
    private String kodeTiket;
    private String namaWahana;
    private double hargaDasar;
    private int stok;
    
    public static int totalTiketBerhasilDibuat = 0;

    public Tiket(String kodeTiket, String namaWahana, double hargaDasar, int stok) {
        this.kodeTiket = kodeTiket;
        this.namaWahana = namaWahana;
        setHargaDasar(hargaDasar);
        setStok(stok);
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

    // Abstract Method Wajib
    public abstract double hitungHargaTiket();
    public abstract void cetakAturanAkses();
    public abstract void tampilkanDetailTiket();
} 