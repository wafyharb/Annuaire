package com.example.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.annuaire.entities.Carnet;
import com.example.annuaire.repositories.CarnetRepository;

@Service
public class CarnetService {
	@Autowired
	private CarnetRepository cr;

	public List<Carnet> getAll() {
     return cr.findAll();
	}
}
