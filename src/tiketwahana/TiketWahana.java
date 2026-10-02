/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiketwahana;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class TiketWahana {

    public static void cariTiket(String kode, Tiket[] daftarTiket, int jumlahTiket) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Kode: " + kode + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahTiket; i++) {
            if (daftarTiket[i].getKodeTiket().equalsIgnoreCase(kode)) {
                daftarTiket[i].tampilkanDetailTiket();
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Tiket dengan kode \"" + kode + "\" tidak ditemukan.");
        }
    }

  
    public static void cariTiket(double hargaMaksimal, Tiket[] daftarTiket, int jumlahTiket) {
        System.out.printf("%n--- Hasil Pencarian Tiket dengan Harga <= Rp%.0f ---%n", hargaMaksimal);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahTiket; i++) {
            if (daftarTiket[i].hitungHargaTiket() <= hargaMaksimal) {
                daftarTiket[i].tampilkanDetailTiket();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada tiket dengan harga di bawah atau sama dengan Rp" + hargaMaksimal);
        }
    }

    public static int hapusTiket(String kode, Tiket[] daftarTiket, int jumlahTiket) {
        int indexDitemukan = -1;

        for (int i = 0; i < jumlahTiket; i++) {
            if (daftarTiket[i].getKodeTiket().equalsIgnoreCase(kode)) {
                indexDitemukan = i;
                break;
            }
        }

        if (indexDitemukan != -1) {
            for (int i = indexDitemukan; i < jumlahTiket - 1; i++) {
                daftarTiket[i] = daftarTiket[i + 1];
            }
            daftarTiket[jumlahTiket - 1] = null;
            Tiket.totalTiketBerhasilDibuat--;
            
            System.out.println("-> Tiket dengan kode \"" + kode + "\" berhasil dihapus dari sistem!");
            return jumlahTiket - 1;
        } else {
            System.out.println("-> Tiket dengan kode \"" + kode + "\" tidak ditemukan. Gagal menghapus.");
            return jumlahTiket;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tiket[] daftarTiket = new Tiket[100];
        int jumlahTiket = 0;
        boolean isRunning = true;

        daftarTiket[jumlahTiket++] = new TiketReguler("TKT-001", "Bianglala", 50000, 10, 10);
        daftarTiket[jumlahTiket++] = new TiketVIP("TKT-002", "Roller Coaster", 120000, 5, true, 30000);
        daftarTiket[jumlahTiket++] = new TiketReguler("TKT-003", "Rumah Hantu", 40000, 0, 0); 

        System.out.println("=========================================================================");
        System.out.println("   SISTEM MANAJEMEN PEMESANAN TIKET WAHANA TAMAN (MODUL 2 - 5)          ");
        System.out.println("=========================================================================");

        while (isRunning) {
            System.out.println("\nMENU UTAMA:");
            System.out.println("1. Tambah Tiket Wahana Baru");
            System.out.println("2. Tampilkan Seluruh Tiket");
            System.out.println("3. Cari Tiket");
            System.out.println("4. Hapus Data Tiket");
            System.out.println("5. Keluar System");
            System.out.print("Pilih Menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahTiket >= daftarTiket.length) {
                        System.out.println("Kapasitas penyimpanan tiket sudah penuh!");
                        break;
                    }

                    System.out.println("\nPilih Jenis Tiket Wahana:");
                    System.out.println("1. Tiket Reguler");
                    System.out.println("2. Tiket VIP");
                    System.out.print("Pilih tipe (1-2): ");
                    int tipe = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan Kode Tiket (misal TKT-004): ");
                    String kode = scanner.nextLine();
                    System.out.print("Masukkan Nama Wahana             : ");
                    String wahana = scanner.nextLine();
                    System.out.print("Masukkan Harga Dasar (Rp)        : ");
                    double harga = scanner.nextDouble();
                    System.out.print("Masukkan Jumlah Stok Tiket       : ");
                    int stok = scanner.nextInt();

                    if (tipe == 1) {
                        System.out.print("Masukkan Diskon Hari Kerja (%)   : ");
                        double diskon = scanner.nextDouble();
                        daftarTiket[jumlahTiket++] = new TiketReguler(kode, wahana, harga, stok, diskon);
                        System.out.println("-> Tiket Reguler Berhasil Ditambahkan!");
                    } else if (tipe == 2) {
                        System.out.print("Akses Fast Track (true/false)    : ");
                        boolean fastTrack = scanner.nextBoolean();
                        System.out.print("Biaya Fasilitas VIP (Rp)         : ");
                        double biayaVIP = scanner.nextDouble();
                        daftarTiket[jumlahTiket++] = new TiketVIP(kode, wahana, harga, stok, fastTrack, biayaVIP);
                        System.out.println("-> Tiket VIP Berhasil Ditambahkan!");
                    } else {
                        System.out.println("Pilihan jenis tiket tidak valid.");
                    }
                    break;

                case 2:
                    System.out.println("\n=======================================================================================================");
                    System.out.println("                                      DAFTAR SELURUH TIKET WAHANA                                        ");
                    System.out.println("=========================================================================================================");
                    if (jumlahTiket == 0) {
                        System.out.println("Belum ada data tiket yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahTiket; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarTiket[i].tampilkanDetailTiket();
                        }
                        System.out.println("---------------------------------------------------------------------------------------------------------");
                        System.out.println("Total Objek Tiket Berhasil Dibuat: " + Tiket.totalTiketBerhasilDibuat);
                    }
                    break;

                case 3:
                    System.out.println("\nPilih Mode Pencarian Tiket:");
                    System.out.println("1. Cari berdasarkan Kode Tiket");
                    System.out.println("2. Cari berdasarkan Harga Maksimal");
                    System.out.print("Pilih opsi pencarian (1-2): ");
                    int opsiCari = scanner.nextInt();
                    scanner.nextLine();

                    if (opsiCari == 1) {
                        System.out.print("Masukkan Kode Tiket yang dicari: ");
                        String cariKode = scanner.nextLine();
                        cariTiket(cariKode, daftarTiket, jumlahTiket);
                    } else if (opsiCari == 2) {
                        System.out.print("Masukkan Batas Harga Maksimal (Rp): ");
                        double cariHarga = scanner.nextDouble();
                        cariTiket(cariHarga, daftarTiket, jumlahTiket);
                    } else {
                        System.out.println("Pilihan mode pencarian tidak valid.");
                    }
                    break;

                case 4:
                    if (jumlahTiket == 0) {
                        System.out.println("Belum ada data tiket yang tersimpan untuk dihapus.");
                    } else {
                        System.out.print("Masukkan Kode Tiket yang ingin dihapus: ");
                        String kodeHapus = scanner.nextLine();
                        jumlahTiket = hapusTiket(kodeHapus, daftarTiket, jumlahTiket);
                    }
                    break;

                case 5:
                    isRunning = false;
                    System.out.println("\nTerima kasih telah menggunakan Sistem Manajemen Tiket Wahana Taman!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}
