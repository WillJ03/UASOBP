package com.example.demospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospringboot.entity.DetailPeminjaman;
import com.example.demospringboot.repository.DetailPeminjamanRepository;


@Service
public class DetailPeminjamanService {

    @Autowired
    private DetailPeminjamanRepository detailPeminjamanRepository;
 
    public List<DetailPeminjaman> getAllDetailPeminjaman() {
    return detailPeminjamanRepository.findAll();
}

    public DetailPeminjaman addDetailPeminjaman(DetailPeminjaman obj) {
    Long id = null;
    obj.setId(id);
    return detailPeminjamanRepository.save(obj);
}

public DetailPeminjaman getDetailPeminjamanById(long id) {
    return detailPeminjamanRepository.findById(id).orElse(null);
}

public DetailPeminjaman findDetailPeminjaman (long id){
    return detailPeminjamanRepository.findById(id).orElse(null);
}

public DetailPeminjaman updateDetailPeminjaman(long id, DetailPeminjaman obj) {
    obj.setId(id);
    return detailPeminjamanRepository.save(obj);
}

public void deleteDetailPeminjaman(long id) {
    detailPeminjamanRepository.deleteById(id);
}
}   