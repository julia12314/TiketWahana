/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author USER
 */
public class TransaksiPembelian {
    public static void prosesBeli(Pengunjung pengunjung, Tiket tiket) {
        System.out.println("\n----------------------------------------");
        System.out.println("         STRUK TRANSAKSI PEMBELIAN      ");
        System.out.println("----------------------------------------");
        System.out.println("Pembeli  : " + pengunjung.getNama() + " (" + pengunjung.getIdPengunjung() + ")");
        System.out.println("Tiket    : " + tiket.getNamaWahana() + " (" + tiket.getKodeTiket() + ")");
        System.out.println("Total Rp : Rp" + String.format("%.0f", tiket.hitungHargaTiket()));
        System.out.println("Status   : Pembelian Berhasil dicatat di sistem.");
        
        tiket.cetakAturanAkses();
        
        if (tiket instanceof DapatFasilitas) {
            ((DapatFasilitas) tiket).tampilkanFasilitasKhusus();
        }
        if (tiket instanceof DapatAsuransi) {
            ((DapatAsuransi) tiket).tampilkanInfoAsuransi();
        }
        System.out.println("----------------------------------------");

        try (FileWriter pipaTulis = new FileWriter("log_transaksi.txt", true)) {
            String log = "Pembeli: " + pengunjung.getNama() + " (" + pengunjung.getIdPengunjung()
            + ") | Tiket: " + tiket.getNamaWahana() + " | Total: Rp" + String.format("%.0f", tiket.hitungHargaTiket()) + "\n";
            pipaTulis.write(log);
        } catch (IOException e) {
            System.out.println("[Peringatan] Gagal menulis log transaksi ke file: " + e.getMessage());
        }
    }
}