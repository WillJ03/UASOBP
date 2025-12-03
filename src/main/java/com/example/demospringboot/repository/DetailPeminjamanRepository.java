package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;   

import com.example.demospringboot.entity.DetailPeminjaman;


public interface DetailPeminjamanRepository extends JpaRepository<DetailPeminjaman, Long>{}