/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiketwahana;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class TiketWahana {

    public static void cariTiket(String kode, ArrayList<Tiket> daftarTiket) throws TiketTidakDitemukanException {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Kode: " + kode + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < daftarTiket.size(); i++) {
            if (daftarTiket.get(i).getKodeTiket().equalsIgnoreCase(kode)) {
                System.out.println("========================================================================================================================");
                System.out.println("| NO | TIPE     | KODE     | WAHANA           | HARGA DASAR  | KETERANGAN TAMBAHAN       | TOTAL HARGA  | STOK   |");
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                daftarTiket.get(i).tampilkanDetailTiket(1);
                System.out.println("-------------------------------------------------------------------------------------------------------------------");
                
                Tiket t = daftarTiket.get(i);
                if (t instanceof DapatFasilitas) {
                    ((DapatFasilitas) t).tampilkanFasilitasKhusus();
                }
                if (t instanceof DapatAsuransi) {
                    ((DapatAsuransi) t).tampilkanInfoAsuransi();
                }
                
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            throw new TiketTidakDitemukanException("Gagal: Tiket dengan kode \"" + kode + "\" tidak ditemukan dalam sistem!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Tiket> daftarTiket = new ArrayList<>();
        HashMap<String, String> dataPengunjung = new HashMap<>();

        try {
            daftarTiket.add(new TiketReguler("TKT-001", "Bianglala", 50000, 10, 10));
            daftarTiket.add(new TiketVIP("TKT-002", "Roller Coaster", 120000, 5, true, 30000));
            daftarTiket.add(new TiketReguler("TKT-003", "Rumah Hantu", 40000, 8, 5));
            daftarTiket.add(new TiketVVIP("TKT-004", "Kora-Kora VVIP", 200000, 3, true, 50000));

            dataPengunjung.put("CUST-001", "Budi Santoso");
            dataPengunjung.put("CUST-002", "Siti Aminah");
            dataPengunjung.put("CUST-003", "Ahmad Fauzi");
        } catch (Exception e) {
            System.out.println("Error saat inisialisasi data: " + e.getMessage());
        }

        boolean isRunning = true;
        System.out.println("===================================================");
        System.out.println("           SISTEM MANAJEMEN TIKET WAHANA           ");
        System.out.println("===================================================");

        while (isRunning) {
            System.out.println("\nMENU UTAMA:");
            System.out.println("1. Tambah Tiket Wahana Baru");
            System.out.println("2. Tampilkan Seluruh Tiket");
            System.out.println("3. Cari Tiket");
            System.out.println("4. Manajemen Pengunjung");
            System.out.println("5. Keluar System");
            System.out.print("Pilih Menu (1-5): ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.println("\nPilih Jenis Tiket Wahana:");
                        System.out.println("1. Tiket Reguler");
                        System.out.println("2. Tiket VIP");
                        System.out.println("3. Tiket VVIP");
                        System.out.print("Pilih tipe (1-3): ");
                        int tipe = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Kode Tiket (misal TKT-005): ");
                        String kode = scanner.nextLine();
                        System.out.print("Masukkan Nama Wahana             : ");
                        String wahana = scanner.nextLine();
                        System.out.print("Masukkan Harga Dasar (Rp)        : ");
                        double harga = scanner.nextDouble();
                        System.out.print("Masukkan Stok Tiket              : ");
                        int stok = scanner.nextInt();
                        scanner.nextLine();

                        if (tipe == 1) {
                            System.out.print("Masukkan Diskon Hari Kerja (%)   : ");
                            double diskon = scanner.nextDouble();
                            daftarTiket.add(new TiketReguler(kode, wahana, harga, stok, diskon));
                        } else if (tipe == 2) {
                            System.out.print("Akses Fast Track (true/false)    : ");
                            boolean fast = scanner.nextBoolean();
                            System.out.print("Biaya Fasilitas VIP (Rp)         : ");
                            double bVip = scanner.nextDouble();
                            daftarTiket.add(new TiketVIP(kode, wahana, harga, stok, fast, bVip));
                        } else if (tipe == 3) {
                            System.out.print("Akses Lounge VVIP (true/false)   : ");
                            boolean lounge = scanner.nextBoolean();
                            System.out.print("Biaya Souvenir Eksklusif (Rp)    : ");
                            double souv = scanner.nextDouble();
                            daftarTiket.add(new TiketVVIP(kode, wahana, harga, stok, lounge, souv));
                        }
                        System.out.println("-> Sukses! Tiket berhasil ditambahkan. Total data: " + daftarTiket.size());
                        break;

                    case 2:
                        System.out.println("\n===================================================================================================================");
                        System.out.println("                                      DAFTAR SELURUH TIKET WAHANA (ArrayList)                                      ");
                        System.out.println("===================================================================================================================");
                        System.out.println("| NO | TIPE     | KODE     | WAHANA           | HARGA DASAR  | KETERANGAN TAMBAHAN  | TOTAL HARGA  | STOK   |");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------");
                        if (daftarTiket.isEmpty()) {
                            System.out.println("Belum ada data tiket yang tersimpan.");
                        } else {
                            for (int i = 0; i < daftarTiket.size(); i++) {
                                daftarTiket.get(i).tampilkanDetailTiket(i + 1);
                            }
                            System.out.println("-------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Total Objek Tiket Berhasil Dibuat: " + Tiket.totalTiketBerhasilDibuat);
                        }
                        break;

                    case 3:
                        System.out.println("\n--- Fitur Cari Tiket ---");
                        System.out.print("Masukkan Kode Tiket yang dicari: ");
                        String cariKode = scanner.nextLine();
                        
                        try {
                            cariTiket(cariKode, daftarTiket);
                        } catch (TiketTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }
                        break;

                    case 4:
                        System.out.println("\n--- Manajemen Pengunjung (HashMap) ---");
                        System.out.println("1. Tambah Pengunjung Baru");
                        System.out.println("2. Cari Pengunjung via ID");
                        System.out.println("3. Tampilkan Semua Pengunjung");
                        System.out.print("Pilih menu (1-3): ");
                        int menuMap = scanner.nextInt();
                        scanner.nextLine();

                        if (menuMap == 1) {
                            System.out.print("Masukkan ID Pengunjung (Key)   : ");
                            String idKey = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (Value)  : ");
                            String namaVal = scanner.nextLine();
                            dataPengunjung.put(idKey, namaVal);
                            System.out.println("-> Pengunjung berhasil ditambahkan!");
                        } else if (menuMap == 2) {
                            System.out.print("Masukkan ID yang dicari        : ");
                            String searchId = scanner.nextLine();
                            if (dataPengunjung.containsKey(searchId)) {
                                System.out.println("Ditemukan! Nama Pengunjung     : " + dataPengunjung.get(searchId));
                            } else {
                                System.out.println("-> Pengunjung dengan ID tersebut tidak terdaftar.");
                            }
                        } else if (menuMap == 3) {
                            System.out.println("Total Pengunjung Terdaftar: " + dataPengunjung.size());
                            for (String keyId : dataPengunjung.keySet()) {
                                System.out.println("- ID: " + keyId + " | Nama: " + dataPengunjung.get(keyId));
                            }
                        }
                        break;

                    case 5:
                        isRunning = false;
                        System.out.println("\nTerima kasih telah menggunakan sistem manajemen tiket wahana!");
                        break;

                    default:
                        System.out.println("Pilihan menu tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Input salah! Harap masukkan format angka yang valid.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] Terjadi kesalahan: " + e.getMessage());
            }
        }
        scanner.close();
    }
}