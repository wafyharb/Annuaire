package com.example.annuaire.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annuaire.entities.Adresse;
import com.example.annuaire.entities.Carnet;
import com.example.annuaire.entities.Civilite;
import com.example.annuaire.entities.Compte;
import com.example.annuaire.services.AdresseService;
import com.example.annuaire.services.CarnetService;
import com.example.annuaire.services.CompteService;

@RestController // Retour en json et Controller attend un string le nom de la page
public class AdresseController implements Serializable {

	private static final long serialVersionUID = 1L;
	private final AdresseService adresseService;
	private final CarnetService carnetService;
	private final CompteService compteService;

	@Autowired
	public AdresseController(AdresseService adresseService, CarnetService carnetService, CompteService compteService) {

		this.adresseService = adresseService;
		this.carnetService = carnetService;
		this.compteService = compteService;
	}

	@GetMapping("/adresses")
	public List<Carnet> getAllCarnets() {
		Carnet fred = new Carnet(null, Civilite.MONSIEUR, "Pouye", "Johny", "1960-10-18", "0123458970","pouye@yahoo.fr", "75015", "Paris");
		Adresse adresse = new Adresse();
		adresse.setNumber(7);
		adresse.setPostcode(59700);
		adresse.setStreet("rue des cotonniers");
		adresse.setTown("Marcq-en-Baroeul");
		fred.getAdresses().add(adresse);
         /*
          * Compte compteF = new Compte(416525, "SG");
		    fred.getComptes().add(compteF);
            compteService.add(compteF);*/
        
		adresseService.add(adresse);
		carnetService.add(fred);
		return carnetService.getAll();
	}
}
