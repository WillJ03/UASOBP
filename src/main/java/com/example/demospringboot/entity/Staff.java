package com.example.demospringboot.entity;

import jakarta.persistence.Entity;

@Entity
public class Staff extends Orang{
    private String divisi;

    public Staff(){}
    public Staff(String nama , String divisi){
        super(nama);
        this.divisi = divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public String getDivisi() {
        return divisi;
    }

    @Override
    public String getInfoOrang() {
    return "Orang";
}

}
