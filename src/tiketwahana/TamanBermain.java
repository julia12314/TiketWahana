/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author USER
 */

public class TamanBermain {
    private String namaTaman;

    private ZonaWahana zonaUtama;
    

    private ArrayList<Tiket> daftarTiket;
    private HashMap<String, Pengunjung> dataPengunjung;

    public TamanBermain(String namaTaman) {
        this.namaTaman = namaTaman;
        this.zonaUtama = new ZonaWahana("Zona Bermain Utama", 200); 
        this.daftarTiket = new ArrayList<>();
        this.dataPengunjung = new HashMap<>();
    }

    public void bukaTamanBermain() {
        System.out.println("\n*** Menginisialisasi sistem " + this.namaTaman + " ***");
        zonaUtama.bukaZona();
    }

    public void tambahTiket(Tiket t) {
        daftarTiket.add(t);
        System.out.println("Sukses! Tiket berhasil ditambahkan. (Total Tiket: " + daftarTiket.size() + ")");
    }

    public void tambahPengunjung(Pengunjung p) {
        dataPengunjung.put(p.getIdPengunjung(), p);
        System.out.println("Berhasil menambahkan pengunjung!");
    }

    public void lihatSemuaTiket() {
        if (daftarTiket.isEmpty()) {
            System.out.println("Belum ada tiket yang tersimpan.");
            return;
        }
        System.out.println("========================================================================================================================");
        System.out.println("| NO | TIPE     | KODE     | WAHANA           | HARGA DASAR  | KETERANGAN TAMBAHAN       | TOTAL HARGA  | STOK   |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < daftarTiket.size(); i++) {
            daftarTiket.get(i).tampilkanDetailTiket(i + 1);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }

    public void cariTiket(String judul) throws TiketTidakDitemukanException {
        System.out.println("\nMencari Tiket dengan Judul Wahana: " + judul);
        boolean ditemukan = false;
        for (Tiket t : daftarTiket) {
            if (t.getNamaWahana().equalsIgnoreCase(judul)) {
                System.out.println("Ditemukan!");
                t.tampilkanDetailTiket(1);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new TiketTidakDitemukanException("Gagal: Tiket dengan wahana \"" + judul + "\" tidak terdaftar di sistem.");
        }
    }

    public void cariPengunjung(String id) {
        if (dataPengunjung.containsKey(id)) {
            System.out.println("Ditemukan! Nama: " + dataPengunjung.get(id).getNama());
        } else {
            System.out.println("Pengunjung dengan ID tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaPengunjung() {
        System.out.println("Total Pengunjung Terdaftar: " + dataPengunjung.size());
        for (Pengunjung p : dataPengunjung.values()) {
            System.out.println("- ID: " + p.getIdPengunjung() + " | Nama: " + p.getNama());
        }
    }

    public Pengunjung getPengunjung(String id) {
        return dataPengunjung.get(id);
    }

    public Tiket getTiketInt(int index) {
        return daftarTiket.get(index);
    }

    public int getJumlahTiket() {
        return daftarTiket.size();
    }
}    

