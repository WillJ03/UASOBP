package com.example.demospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospringboot.entity.Mahasiswa;
import com.example.demospringboot.repository.MahasiswaRepository;


@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;
 
    public List<Mahasiswa> getAllMahasiswa() {
    return mahasiswaRepository.findAll();
}

    public Mahasiswa addMahasiswa(Mahasiswa obj) {
    Long id = null;
    obj.setId(id);
    return mahasiswaRepository.save(obj);
}

public Mahasiswa findMahasiswa (long id){
        return mahasiswaRepository.findById(id).orElse(null);
}

public Mahasiswa getMahasiswaById(long id) {
    return mahasiswaRepository.findById(id).orElse(null);
}

public Mahasiswa updateMahasiswa(long id, Mahasiswa obj) {
    obj.setId(id);
    return mahasiswaRepository.save(obj);
}

public void deleteMahasiswa(long id) {
    mahasiswaRepository.deleteById(id);
}
}   