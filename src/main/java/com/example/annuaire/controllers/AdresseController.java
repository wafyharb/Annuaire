package com.example.annuaire.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.annuaire.entities.Adresse;
import com.example.annuaire.entities.Carnet;
import com.example.annuaire.entities.Civilite;
import com.example.annuaire.services.AdresseService;
import com.example.annuaire.services.CarnetService;

@Controller
public class AdresseController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final AdresseService adresseService;
	private final CarnetService carnetService;

	@Autowired
	public AdresseController(AdresseService adresseService, CarnetService carnetService) {

		this.adresseService = adresseService;
		this.carnetService = carnetService;
	}

	@GetMapping("/adresses")
	public List<Carnet> getAllCarnets() {
		Carnet fred = new Carnet(null, Civilite.MONSIEUR, "Pouye", "Johny", "1960-10-18", "0123458970",
				"pouye@yahoo.fr", "75015", "Paris");
		Adresse adresse = new Adresse();
		adresse.setNumber(7);
		adresse.setPostcode(59700);
		adresse.setStreet("rue des cotonniers");
		adresse.setTown("Marcq-en-Baroeul");
		fred.getAdresses().add(adresse);
		adresseService.add(adresse);
		carnetService.add(fred);
		return carnetService.getAll();
	}
}
