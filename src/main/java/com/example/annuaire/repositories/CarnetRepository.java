package com.example.annuaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.annuaire.entities.Carnet;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long> {

}