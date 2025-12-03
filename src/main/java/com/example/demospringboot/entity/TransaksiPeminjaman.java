package com.example.demospringboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TransaksiPeminjaman{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String noTransaksi;
    
    @ManyToOne
        @JoinColumn(name = "mahasiswaID")
        private Mahasiswa mahasiswa;
    
        @ManyToOne
        @JoinColumn(name = "bukuID")
        private Buku buku;
    
        @OneToMany(mappedBy = "transaksiPeminjaman", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<DetailPeminjaman> details = new ArrayList<>();
    public TransaksiPeminjaman(){}
    public TransaksiPeminjaman(String noTransaksi){
        this.noTransaksi = noTransaksi;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
   
    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Buku getBuku() {
    return buku;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setMahasiswa(Mahasiswa mahasiswa){ 
        this.mahasiswa = mahasiswa; 
    }
    public Mahasiswa getMahasiswa(){ 
        return mahasiswa; 
    }

    public void setDetails(List<DetailPeminjaman> details){ 
        this.details = details; 
    }
    public List<DetailPeminjaman> getDetails(){ 
        return details; 
    }

    public void addDetail(DetailPeminjaman d){
        d.setTransaksiPeminjaman(this);
        this.details.add(d);
    }

}
