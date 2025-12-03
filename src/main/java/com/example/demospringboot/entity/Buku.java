package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Buku implements StatusPeminjaman{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String judul;
    private String penulis;
    private String kategori;


    public Buku(){}
    public Buku(String judul , String penulis , String kategori , Long id){
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
    }

    
    public void setJudul(String judul){
        this.judul = judul;
    }
    
    public String getJudul() {
        return judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    @Override public String getStatus(){ 
        return "Occupied"; 
    }


}