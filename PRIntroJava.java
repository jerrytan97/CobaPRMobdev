/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printrojava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class PRIntroJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println(".:Menu.:");
        System.out.println("1. Add Barang");
        System.out.println("2. View Barang");
        System.out.println("3. Beli Barang");
        System.out.println("4. Exit");
        System.out.print("Pilihan Anda: ");
        int pilihan = scanner.nextInt();
        int pilihan2 = 0;
        String namabeli = "";
        int jumlahbeli = 0;
        int hargabarang = 0;

        ArrayList<Barang> listBarang = new ArrayList<Barang>();
        ArrayList<Barang> listBarangBeli = new ArrayList<Barang>();

        while (true) {
            if (pilihan == 1) {
                Barang barangA = new Barang();
                System.out.print("Nama: ");
                barangA.setNama(scanner.next());
                System.out.print("Harga: ");
                barangA.setHarga(scanner.nextInt());
                System.out.print("Stok: ");
                barangA.setStok(scanner.nextInt());
                listBarang.add(barangA);
            }
            if (pilihan == 2) {
                for (int i = 0; i < listBarang.size(); i++) {
                    System.out.println(listBarang.get(i).toString());
                }
            }
            if (pilihan == 3) {
                System.out.println(".:Menu.:");
                System.out.println("1. Add Barang yang Dibeli");
                System.out.println("2. Delete Barang yang Dibeli");
                System.out.println("3. Bayar");
                System.out.println("4. Kembali");
                System.out.print("Pilihan Anda: ");
                pilihan2 = scanner.nextInt();

                while (true) {
                    if (pilihan2 == 1) {
                        System.out.println("Barang Kami: ");
                        for (int i = 0; i < listBarang.size(); i++) {
                            System.out.println(listBarang.get(i).toString());
                        }

                        System.out.print("Nama Barang yang Ingin Dibeli: ");
                        namabeli = scanner.next();
                        System.out.print("Jumlah Barang yang Ingin Dibeli: ");
                        jumlahbeli = scanner.nextInt();
                        int adanama = 0;

                        for (Barang searchbarang : listBarang) {
                            if (searchbarang.getNama().equals(namabeli)) {
                                if (searchbarang.getStok() < jumlahbeli) {
                                    System.out.println("Stok Barang Tidak Mencukupi");
                                    adanama = 1;
                                    break;
                                } else {
                                    Barang barangsimpan = new Barang(searchbarang.getNama(), searchbarang.getHarga(), jumlahbeli);
                                    listBarangBeli.add(barangsimpan);
                                    searchbarang.setStok(searchbarang.getStok() - jumlahbeli);
                                    hargabarang = hargabarang + (jumlahbeli * searchbarang.getHarga());
                                    adanama = 1;
//                                    for (int i = 0; i < listBarangBeli.size(); i++) {
//                                        System.out.println(listBarangBeli.get(i).toString());
//                                    }
//                                    for (int i = 0; i < listBarang.size(); i++) {
//                                        System.out.println(listBarang.get(i).toString());
//                                    }

                                }
                            }
                        }
                        if (adanama == 0) {
                            System.out.println("Nama Barang Tidak Ditemukan");
                        }
                    }
                    if (pilihan2 == 2) {
                        if (namabeli == "") {
                            System.out.println("Anda Belum Memasukkan Barang Apapun ke Keranjang Belanja");
                        } else {
                            System.out.println("Barang yang Anda Masukkan ke Keranjang: ");
                            for (int i = 0; i < listBarangBeli.size(); i++) {
                                System.out.println(listBarangBeli.get(i).toString());
                            }
                            System.out.print("Masukkan Nama Barang yang Batal Anda Beli: ");
                            String namabatal = scanner.next();

                            int ceknama = 0;
                            for (Barang searchbarang1 : listBarangBeli) {
                                if (searchbarang1.getNama().equals(namabatal)) {
                                    hargabarang = hargabarang - (searchbarang1.getStok() * searchbarang1.getHarga());
                                    listBarangBeli.remove(searchbarang1);
                                    ceknama = 1;
                                    break;
                                }
                            }
                            if (ceknama == 0) {
                                System.out.println("Nama Barang Tidak Ditemukan");
                            }
                        }
                    }
                    if (pilihan2 == 3) {
                        System.out.println("Total Harga Barang Saat Ini: " + hargabarang);
                        System.out.print("Masukkan Jumlah Uang yang Anda Bayarkan: ");
                        int uangbayar = scanner.nextInt();
                        if (uangbayar < hargabarang) {
                            System.out.println("Tolong Kalau Uangnya Gak Cukup Jangan Beli Ya");
                        } else {
                            int kembalian = uangbayar - hargabarang;
                            System.out.println("Total Kembalian Anda Adalah: " + kembalian);
                            System.out.println("Terima Kasih Telah Berbelanja di Toko Kami");
                            listBarangBeli.clear();
                            break;
                        }
                    }
                    if (pilihan2 == 4) {
                        break;
                    }
                    System.out.println(".:Menu.:");
                    System.out.println("1. Add Barang yang Dibeli");
                    System.out.println("2. Delete Barang yang Dibeli");
                    System.out.println("3. Bayar");
                    System.out.println("4. Kembali");
                    System.out.print("Pilihan Anda: ");
                    pilihan2 = scanner.nextInt();
                }

            }//Beli
            if (pilihan == 4) {
                System.out.println("Bye Bye");
                break;
            }

            System.out.println(".:Menu.:");
            System.out.println("1. Add Barang");
            System.out.println("2. View Barang");
            System.out.println("3. Beli Barang");
            System.out.println("4. Exit");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
        }//while menu 1

    }//Main

}
