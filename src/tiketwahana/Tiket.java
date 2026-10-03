/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;

/**
 *
 * @author USER
 */

public class Tiket {
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

    public String getKodeTiket() {
        return this.kodeTiket;
    }

    public void setKodeTiket(String kodeTiket) {
        this.kodeTiket = kodeTiket;
    }

    public String getNamaWahana() {
        return this.namaWahana;
    }

    public void setNamaWahana(String namaWahana) {
        this.namaWahana = namaWahana;
    }

    public double getHargaDasar() {
        return this.hargaDasar;
    }

    public void setHargaDasar(double hargaDasar) {
        if (hargaDasar < 0) {
            System.out.println("[Peringatan] Harga dasar tidak boleh negatif! Diset ke 0.");
            this.hargaDasar = 0;
        } else {
            this.hargaDasar = hargaDasar;
        }
    }

    public int getStok() {
        return this.stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("[Peringatan] Stok tidak boleh negatif! Diset ke 0.");
            this.stok = 0;
        } else {
            this.stok = stok;
        }
    }

    public double hitungHargaTiket() {
        return this.hargaDasar;
    }

    public void tampilkanDetailTiket() {
        String statusStok = (this.stok > 0) ? String.valueOf(this.stok) : "SOLD OUT";
        System.out.printf("| %-8s | %-8s | %-16s | Rp%-10.0f | %-25s | Rp%-10.0f | %-8s |%n", 
            "BIASA", this.kodeTiket, this.namaWahana, getHargaDasar(), "-", hitungHargaTiket(), statusStok);
    }

    public void cetakAturanAkses() {
        System.out.println("[Tiket Biasa] Akses wahana standar tanpa keutamaan jalur atau fasilitas tambahan.");
    }
}