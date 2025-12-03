package com.example.demospringboot.entity;

import jakarta.persistence.Entity;

@Entity
public class Mahasiswa extends Orang{
    private String nim;
    private String jurusan;

    public Mahasiswa(){}
    public Mahasiswa(String nama ,String nim , String jurusan){
        super(nama);
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }


    @Override
    public String getInfoOrang() {
    return "Orang";
}

}
