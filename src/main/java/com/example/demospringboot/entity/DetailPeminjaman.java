package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class DetailPeminjaman{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String noPeminjaman;

    @ManyToOne
    @JoinColumn(name = "mahasiswaID")
    private Mahasiswa mahasiswa;

    @ManyToOne
    @JoinColumn(name = "bukuID")
    private Buku buku;

    @ManyToOne
    @JoinColumn(name = "transaksiID")
    private TransaksiPeminjaman transaksiPeminjaman;

    
    public DetailPeminjaman(){}
    public DetailPeminjaman(String noPeminjaman){
        this.noPeminjaman = noPeminjaman;
    }

    public void setMahasiswa(Mahasiswa mahasiswa){ 
        this.mahasiswa = mahasiswa; 
    }
    public Mahasiswa getMahasiswa(){ 
        return mahasiswa; 
    }
    
    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Buku getBuku() {
    return buku;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public void setNoPeminjaman(String noPeminjaman) {
        this.noPeminjaman = noPeminjaman;
    }

    public String getNoPeminjaman() {
        return noPeminjaman;
    }

    public TransaksiPeminjaman getTransaksiPeminjaman() {
        return transaksiPeminjaman;
    }

    public void setTransaksiPeminjaman(TransaksiPeminjaman transaksi) {
        this.transaksiPeminjaman = transaksi;
    }

}
