package com.example.demospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospringboot.entity.TransaksiPeminjaman;
import com.example.demospringboot.repository.TransaksiPeminjamanRepository;


@Service
public class TransaksiPeminjamanService {

    @Autowired
    private TransaksiPeminjamanRepository transaksiPeminjamanRepository;
 
    public List<TransaksiPeminjaman> getAllTransaksiPeminjaman() {
    return transaksiPeminjamanRepository.findAll();
}

    public TransaksiPeminjaman addTransaksiPeminjaman(TransaksiPeminjaman obj) {
    Long id = null;
    obj.setId(id);
    return transaksiPeminjamanRepository.save(obj);
}

public TransaksiPeminjaman getTransaksiPeminjamanById(long id) {
    return transaksiPeminjamanRepository.findById(id).orElse(null);
}

public TransaksiPeminjaman findTransaksiPeminjaman(long id){
    return transaksiPeminjamanRepository.findById(id).orElse(null);
}

public TransaksiPeminjaman updateTransaksiPeminjaman(long id, TransaksiPeminjaman obj) {
    obj.setId(id);
    return transaksiPeminjamanRepository.save(obj);
}

public void deleteTransaksiPeminjaman(long id) {
    transaksiPeminjamanRepository.deleteById(id);
}



}