package com.example.annuaire.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.annuaire.entities.Adresse;
import com.example.annuaire.entities.Carnet;
import com.example.annuaire.entities.Civilite;
import com.example.annuaire.services.AdresseService;
import com.example.annuaire.services.CarnetService;
import com.example.annuaire.services.CompteService;

public class CarnetDao {
	private final AdresseService adresseService;
	private final CarnetService carnetService;
	private final CompteService compteService;

	@Autowired
	public CarnetDao(AdresseService adresseService, CarnetService carnetService, CompteService compteService) {
		super();
		this.adresseService = adresseService;
		this.carnetService = carnetService;
		this.compteService = compteService;
	}

	public List<Adresse> getAllAdresses() {
		Carnet fred = new Carnet(null, Civilite.MONSIEUR, "Pouye", "Johny", "1960-10-18", "0123458970",
				"pouye@yahoo.fr", "75015", "Paris");
		Adresse adresse = new Adresse();
		adresse.setNumber(7);
		adresse.setPostcode(59700);
		adresse.setStreet("rue des cotonniers");
		adresse.setTown("Marcq-en-Baroeul");
		List<Adresse> adresses = new ArrayList<Adresse>();
		adresses.add(adresse);
		fred.setAdresses(adresses);
		adresseService.add(adresse);
		return adresseService.getAll();
	}
}
