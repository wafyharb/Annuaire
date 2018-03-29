package com.example.annuaire.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.annuaire.entities.Compte;
import com.example.annuaire.repositories.CompteRepository;
@Service
public class CompteService {

	private final CompteRepository cr;
	@Autowired
	public CompteService(CompteRepository cr)
	{
		this.cr=cr;
	}
	public List<Compte> getAll() {
		return cr.findAll();
	}

	public void add(Compte c) {
		cr.save(c);
	}

	public void delete(Compte c) {
		cr.delete(c);
	}

	public Compte findById(Long id) {
		if (cr.findById(id).isPresent())
			return cr.findById(id).get();
		return null;
	}

	public void update( Compte compte) {
		Optional<Compte> co = cr.findById(compte.getId());		
		if (co.isPresent()) {
			
			cr.save(co.get());
		}

	}
	public void deleteById(Long id)
	{
		cr.deleteById(id);
	}
	

}
