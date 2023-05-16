package naocare.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Dodatak;
import model.Naocare;
import model.Ocena;
import naocare.repositories.DodatakRepository;
import naocare.repositories.NaocareRepository;
import naocare.repositories.OcenaRepository;

@Controller
@RequestMapping("/ucesnici")
public class UcesnikController {

	@Autowired
	NaocareRepository nr;
	
	@Autowired
	OcenaRepository or;
	
	@Autowired
	DodatakRepository dr;
	
	@ModelAttribute("naocare")
	public List<Naocare> getNaocare(){
		
		return nr.findAll();
	}
	
	
	// ------------------------ prikaz modela naocara -----------------------------------------------------
	@RequestMapping(value = "/getPonude", method = RequestMethod.GET)
	public String getPonude(HttpServletRequest request){
		
		List<Naocare> naocare = nr.findAll();
		request.getSession().setAttribute("naocare", naocare);
		
		return "stranice/PrikazPonuda";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// -------------------- prikaz dodataka -----------------------------------------------------------------
	@RequestMapping(value = "/getDodaci", method = RequestMethod.GET)
	public String getDodaci(HttpServletRequest request){
		
		List<Dodatak> dodaci = dr.findAll();
		request.getSession().setAttribute("dodaci", dodaci);
		
		return "stranice/PrikazDodataka";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ------------------------------------------------------------------------------------------------------

	@ModelAttribute("ocene")
	public List<Ocena> getOcene(){
		
		return or.findAll();
	}
	// ------------------------------------------------------------------------------------------------------

	
	// ------------------------------ prikaz komentara i ocena ----------------------------------------------
	@RequestMapping(value = "/prikaziOcene", method = RequestMethod.GET)
	public String prikazOcena(HttpServletRequest request) {
		
		List<Ocena> ocene = or.findAll();
		request.getSession().setAttribute("ocene", ocene);
		
		return "stranice/PrikazOcena";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------
}

