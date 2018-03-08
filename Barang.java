/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introjava;

/**
 *
 * @author SI
 */
public class Barang {
    private String nama;
    private int harga;
    private int stok;
    
    public Barang() {
        nama = "";
        stok = 0;
        harga = 0;
    }
    
    /**
     * 
     * @param nama
     * @param harga
     * @param stok 
     */
    
    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() { //Mengeprint semua data di dalamnya
        return "Barang{" + "nama=" + nama + ", harga=" + harga + ", stok=" + stok + '}';
    }
    
}

//Pakai alt+insert untuk buat constructor dan get set otomatis
//Buat comment menggunakan /** + enter