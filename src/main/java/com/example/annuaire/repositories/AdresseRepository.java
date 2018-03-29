package com.example.annuaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.annuaire.entities.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Long> {

}
