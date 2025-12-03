package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;   

import com.example.demospringboot.entity.TransaksiPeminjaman;


public interface TransaksiPeminjamanRepository extends JpaRepository<TransaksiPeminjaman, Long>{}