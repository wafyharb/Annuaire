package com.example.annuaire.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class home {
	/*@GetMapping("/")// root 
	@ResponseBody// ce que Je te renvoie c'est vraiment ce qui va l'afficher
	public String index() {
		String s = "<h1>Hello From index Method<h1>";
		return s;
	}
	@GetMapping("/test")//url avec laquel on va acceder a index
	//public String index2(HttpServletRequest req) en Pure JEE
	
	public String index2(@RequestParam(required=false, defaultValue="Sorry there is no paramaters") String name, Model model )// les parametres doivent avoir les mm noms que dans la requette
	{
		//System.out.println(req.getParameter("name")); en JEE
		//System.out.println(name);
		model.addAttribute("name", name);
		return "index";
	}*/
}
