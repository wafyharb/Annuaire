package com.example.annuaire.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.annuaire.entities.Carnet;
import com.example.annuaire.repositories.CarnetRepository;
@Service
public class CarnetService {

	private final CarnetRepository cr;
	@Autowired
	public CarnetService(CarnetRepository cr)
	{
		this.cr=cr;
	}
	public List<Carnet> getAll() {
		return cr.findAll();
	}

	public void add(Carnet c) {
		cr.save(c);
	}

	public void delete(Carnet c) {
		cr.delete(c);
	}

	public Carnet findById(Long id) {
		if (cr.findById(id).isPresent())
			return cr.findById(id).get();
		return null;
	}

	public void update( Carnet carnet) {
		Optional<Carnet> co = cr.findById(carnet.getId());		
		if (co.isPresent()) {
			
			cr.save(co.get());
		}

	}
	public void deleteById(Long id)
	{
		cr.deleteById(id);
	}
	

}
