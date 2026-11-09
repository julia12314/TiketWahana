/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiketwahana;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author USER
 */

public class TiketWahana {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        TamanBermain tamanCeria = new TamanBermain("Taman Bermain Ceria");
        tamanCeria.bukaTamanBermain();

        try {
            tamanCeria.tambahTiket(new TiketReguler("TKT-001", "Bianglala", 50000, 10, 10));
            tamanCeria.tambahTiket(new TiketVIP("TKT-002", "Roller Coaster", 120000, 5, true, 30000));
            tamanCeria.tambahTiket(new TiketReguler("TKT-003", "Rumah Hantu", 40000, 8, 5));
            tamanCeria.tambahTiket(new TiketVVIP("TKT-004", "Kora-Kora VVIP", 200000, 3, true, 50000));

            tamanCeria.tambahPengunjung(new Pengunjung("CUST-001", "Budi Santoso"));
            tamanCeria.tambahPengunjung(new Pengunjung("CUST-002", "Siti Aminah"));
            tamanCeria.tambahPengunjung(new Pengunjung("CUST-003", "Ahmad Fauzi"));
        } catch (Exception e) {
            System.out.println("Error saat inisialisasi: " + e.getMessage());
        }

        boolean isRunning = true;
        System.out.println("=======================================================");
        System.out.println("             SISTEM MANAJEMEN TIKET WAHANA             ");
        System.out.println("=======================================================");

        while (isRunning) {
            System.out.println("\nMENU UTAMA:");
            System.out.println("1. Tambah Tiket Wahana Baru");
            System.out.println("2. Lihat Daftar Tiket");
            System.out.println("3. Cari Tiket");
            System.out.println("4. Manajemen Pengunjung");
            System.out.println("5. Pembelian Tiket / Transaksi"); 
            System.out.println("6. Keluar System");
            System.out.print("Pilih Menu (1-6): ");

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
                            tamanCeria.tambahTiket(new TiketReguler(kode, wahana, harga, stok, diskon));
                        } else if (tipe == 2) {
                            System.out.print("Akses Fast Track (true/false)    : ");
                            boolean fast = scanner.nextBoolean();
                            System.out.print("Biaya Fasilitas VIP (Rp)         : ");
                            double bVip = scanner.nextDouble();
                            tamanCeria.tambahTiket(new TiketVIP(kode, wahana, harga, stok, fast, bVip));
                        } else if (tipe == 3) {
                            System.out.print("Akses Lounge VVIP (true/false)   : ");
                            boolean lounge = scanner.nextBoolean();
                            System.out.print("Biaya Souvenir Eksklusif (Rp)    : ");
                            double souv = scanner.nextDouble();
                            tamanCeria.tambahTiket(new TiketVVIP(kode, wahana, harga, stok, lounge, souv));
                        }
                        break;

                    case 2:
                        System.out.println("\n--- DAFTAR SELURUH TIKET WAHANA ---");
                        tamanCeria.lihatSemuaTiket();
                        break;

                    case 3:
                        System.out.println("\n--- Fitur Cari Tiket (Demo Custom Exception) ---");
                        System.out.print("Masukkan Nama Wahana yang dicari: ");
                        String cariJudul = scanner.nextLine();
                        
                        try {
                            tamanCeria.cariTiket(cariJudul);
                        } catch (TiketTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("\n--- Manajemen Pengunjung ---");
                        System.out.println("1. Tambah Pengunjung");
                        System.out.println("2. Cari Pengunjung");
                        System.out.println("3. Lihat Semua Pengunjung");
                        System.out.print("Pilih menu (1-3): ");
                        int menuP = scanner.nextInt();
                        scanner.nextLine();

                        if (menuP == 1) {
                            System.out.print("Masukkan ID Pengunjung : ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Pengunjung: ");
                            String nama = scanner.nextLine();
                            tamanCeria.tambahPengunjung(new Pengunjung(id, nama));
                        } else if (menuP == 2) {
                            System.out.print("ID Pengunjung yg dicari: ");
                            tamanCeria.cariPengunjung(scanner.nextLine());
                        } else if (menuP == 3) {
                            tamanCeria.lihatSemuaPengunjung();
                        }
                        break;

                    case 5:
                        System.out.println("\n--- Sistem Pembelian Tiket (Demo Association) ---");
                        System.out.print("Masukkan ID Pengunjung Pembeli: ");
                        String inputId = scanner.nextLine();
                        
                        Pengunjung pembeli = tamanCeria.getPengunjung(inputId);
                        if (pembeli == null) {
                            System.out.println("Gagal: Pengunjung belum terdaftar di sistem!");
                        } else if (tamanCeria.getJumlahTiket() == 0) {
                            System.out.println("Gagal: Belum ada tiket yang tersedia.");
                        } else {
                            tamanCeria.lihatSemuaTiket();
                            System.out.print("Pilih Nomor Tiket yang ingin dibeli (1-" + tamanCeria.getJumlahTiket() + "): ");
                            int noTiket = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noTiket >= 0 && noTiket < tamanCeria.getJumlahTiket()) {
                                Tiket tiketPilih = tamanCeria.getTiketInt(noTiket);

                                TransaksiPembelian.prosesBeli(pembeli, tiketPilih);
                            } else {
                                System.out.println("Nomor tiket tidak valid!");
                            }
                        }
                        break;

                    case 6:
                        isRunning = false;
                        System.out.println("\nTerima kasih telah menggunakan Sistem Manajemen Tiket Taman Bermain!");
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