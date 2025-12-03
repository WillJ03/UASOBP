package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;   

import com.example.demospringboot.entity.Orang;


public interface OrangRepository extends JpaRepository<Orang, Long>{}