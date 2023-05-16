package naocare.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.NaocareshopKorisnik;
import model.NaocareshopUloga;
import naocare.repositories.NaocareshopKorisnikRepository;
import naocare.repositories.NaocareshopUlogaRepository;

@Controller
@RequestMapping(value = "/auth")
public class LoginController {

	@Autowired
	NaocareshopKorisnikRepository nkr;
	
	@Autowired
	NaocareshopUlogaRepository nur;
	
	@ModelAttribute("uloge")
	public void getUloge(Model m) {
		
		List<NaocareshopUloga> uloge = nur.findAll();	
		m.addAttribute("uloge", uloge);
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		
		return "login";
	}
	
	@RequestMapping(value = "/pocetna", method = RequestMethod.GET)
	public String getPocetna() {
		
		return "pocetna";
	}
	
	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String deniedPage() {
		
		return "access_denied";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String newUser(Model m) {
		
		NaocareshopKorisnik k = new NaocareshopKorisnik();
		m.addAttribute("korisnik", k);
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("korisnik") NaocareshopKorisnik k) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		k.setPassword(passwordEncoder.encode(k.getPassword()));
		
		// datoj ulozi dodajemo novog korisnika
		for(NaocareshopUloga u : k.getNaocareshopUlogas()) {
			u.addKorisnik(k);
		}
		
		nkr.save(k);
		
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		return "redirect:/auth/loginPage";
	}
}
