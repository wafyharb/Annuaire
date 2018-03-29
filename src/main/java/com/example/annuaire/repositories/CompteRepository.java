package com.example.annuaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.annuaire.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {

}