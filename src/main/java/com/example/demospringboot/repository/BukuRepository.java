package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;   

import com.example.demospringboot.entity.Buku;


public interface BukuRepository extends JpaRepository<Buku, Long>{}