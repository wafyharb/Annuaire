package com.example.annuaire.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.annuaire.entities.Carnet;
import com.example.annuaire.services.CarnetService;

@RestController
public class CarnetController {
	@Autowired // instantiation d'un singleton
	private CarnetService cs;

	@GetMapping("/carnets")
	public List<Carnet> getAllCarnet() {
		return cs.getAll();
	}

	@RequestMapping(value = "/carnetshtml", method = RequestMethod.GET)
	public ModelAndView getAll() {
		ModelAndView mav = new ModelAndView("pages/carnets");
		mav.addObject("carnets", this.getAllCarnet());
		return mav;
	}
	@RequestMapping(value = "/getcarnet/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("pages/carnetAffiche.html");
		mav.addObject("carnet", cs.findById(id));
		return mav;
	}

	@GetMapping(value = "/carnet")
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("pages/formulairecarnet");
		mav.addObject("carnet", new Carnet());// en version th field pour validation formulaire
		return mav;
	}
  
	@RequestMapping(value ="/carnet", method = RequestMethod.POST)
	public ModelAndView add(@Validated Carnet carnet, BindingResult br) {
		if (br.hasErrors()) {
			return new ModelAndView("pages/formulairecarnet.html").addObject("carnet", carnet);
		}
		cs.add(carnet);
		return new ModelAndView("pages/carnetResultAjout.html").addObject("carnet", carnet);
	}

	@RequestMapping(value ="/carnet", method = RequestMethod.PUT)
	public ModelAndView update(@Validated Carnet carnet, BindingResult br) {

		if (br.hasErrors()) {
			return new ModelAndView("pages/formulairecarnet.html").addObject("carnet", carnet);
		}
		cs.update(carnet);

		return new ModelAndView("pages/carnetResultAjout.html").addObject("carnet", carnet);
	}

	@RequestMapping(value = "/carnet/{id}", method = RequestMethod.DELETE)
	public ModelAndView DelById(@PathVariable Long id) {
		cs.deleteById(id);
		return getAll();


	}
}
