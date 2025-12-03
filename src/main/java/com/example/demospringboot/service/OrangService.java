package com.example.demospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospringboot.entity.Orang;
import com.example.demospringboot.repository.OrangRepository;


@Service
public class OrangService {

    @Autowired
    private OrangRepository orangRepository;
 
    public List<Orang> getAllOrang() {
    return orangRepository.findAll();
}

public Orang addOrang(Orang obj) {
    // Jika id = 0 (default dari form), ubah ke null agar dianggap entitas baru
    if (obj.getId() != null && obj.getId() == 0) {
        obj.setId(null);
    }
    return orangRepository.save(obj);
}

public Orang findOrang (long id){
        return orangRepository.findById(id).orElse(null);
}

public Orang getOrangById(long id) {
    return orangRepository.findById(id).orElse(null);
}

public Orang updateOrang(long id, Orang obj) {
    obj.setId(id);
    return orangRepository.save(obj);
}

public void deleteOrang(long id) {
    orangRepository.deleteById(id);
}
}