/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * @author USER
 */

public class TamanBermain implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public void simpanDataKeFile() {
        try (FileOutputStream fileKeluar = new FileOutputStream("data_taman.dat");
             ObjectOutputStream mesinPembeku = new ObjectOutputStream(fileKeluar)) {
            
            mesinPembeku.writeObject(this.daftarTiket);
            mesinPembeku.writeObject(this.dataPengunjung);
            System.out.println("-> [SYSTEM] Seluruh data berhasil disimpan (Serialization) ke Harddisk!");
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal menyimpan data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void muatDataDariFile() {
        try {
            File cekFile = new File("data_taman.dat");
            if (!cekFile.exists()) return;

            try (FileInputStream fileMasuk = new FileInputStream(cekFile);
                 ObjectInputStream mesinPembangkit = new ObjectInputStream(fileMasuk)) {
                
                this.daftarTiket = (ArrayList<Tiket>) mesinPembangkit.readObject();
                this.dataPengunjung = (HashMap<String, Pengunjung>) mesinPembangkit.readObject();

                Tiket.totalTiketBerhasilDibuat = this.daftarTiket.size();
                System.out.println("-> [SYSTEM LOG] Data sistem berhasil dimuat ulang dari penyimpanan.");
            }
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal memuat data: " + e.getMessage());
        }
    }

    public void bacaLogTransaksi() {
        System.out.println("\n--- Riwayat Log Transaksi Pembelian ---");
        try {
            File fileLog = new File("log_transaksi.txt");
            if (!fileLog.exists()) {
                System.out.println("Belum ada riwayat transaksi yang tercatat.");
                return;
            }
            Scanner mesinBaca = new Scanner(fileLog);
            while (mesinBaca.hasNextLine()) {
                System.out.println(mesinBaca.nextLine());
            }
            mesinBaca.close();
        } catch (FileNotFoundException e) {
            System.out.println("Gagal membuka file log transaksi.");
        }
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
        boolean ditemukan = false;
        for (String key : dataPengunjung.keySet()) {
            if (key.equalsIgnoreCase(id)) {
                System.out.println("Ditemukan! Nama: " + dataPengunjung.get(key).getNama());
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
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
        for (String key : dataPengunjung.keySet()) {
            if (key.equalsIgnoreCase(id)) {
                return dataPengunjung.get(key);
            }
        }
        return null;
    }

    public Tiket getTiketInt(int index) {
        return daftarTiket.get(index);
    }

    public int getJumlahTiket() {
        return daftarTiket.size();
    }
}  

