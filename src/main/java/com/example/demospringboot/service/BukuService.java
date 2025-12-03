package com.example.demospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospringboot.entity.Buku;
import com.example.demospringboot.repository.BukuRepository;


@Service
public class BukuService {

    @Autowired
    private BukuRepository bukuRepository;
 
    public List<Buku> getAllBuku() {
    return bukuRepository.findAll();
}

    public Buku addBuku(Buku obj) {
    Long id = null;
    obj.setId(id);
    return bukuRepository.save(obj);
}

public Buku getBukuById(long id) {
    return bukuRepository.findById(id).orElse(null);
}

public Buku findBuku (long id){
    return bukuRepository.findById(id).orElse(null);
}

public Buku updateBuku(long id, Buku obj) {
    obj.setId(id);
    return bukuRepository.save(obj);
}

public void deleteBuku(long id) {
    bukuRepository.deleteById(id);
}
}   