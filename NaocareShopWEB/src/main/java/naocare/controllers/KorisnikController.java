package naocare.controllers;


import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Brend;
import model.Dodatak;
import model.Kategorija;
import model.Naocare;
import model.NaocareshopKorisnik;
import model.Ocena;
import model.Porudzbina;
import naocare.repositories.BrendRepository;
import naocare.repositories.DodatakRepository;
import naocare.repositories.KategorijaRepository;
import naocare.repositories.NaocareRepository;
import naocare.repositories.NaocareshopKorisnikRepository;
import naocare.repositories.OcenaRepository;
import naocare.repositories.PorudzbinaRepository;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value = "/korisnici")
public class KorisnikController {
	
	@Autowired
	NaocareRepository nr;

	@Autowired
	OcenaRepository or;
	
	@Autowired
	DodatakRepository dor;
	
	@Autowired
	PorudzbinaRepository pr;
	
	@Autowired
	BrendRepository br;
	
	@Autowired
	KategorijaRepository kr;
	
	@Autowired
	NaocareshopKorisnikRepository nkr;
	
	
	// ----------------------- prikaz slike za izabrani model naocara -------------------------------------
	@RequestMapping(value = "/prikazNaocara", method = RequestMethod.GET)
	public String prikazNaocara(Integer idNaocara, HttpServletResponse response, Model m) throws Exception {
		
		Naocare naocare = nr.findById(idNaocara).get();
		byte[] slika = naocare.getSlika();
		
		if(slika != null) {
			
			response.setContentType("image/jpeg");
			m.addAttribute("slika", Base64.getEncoder().encodeToString(slika));
		
		} else {
			m.addAttribute("poruka", "Nazalost, trenutno ne postoji slika za izabrani model naocara...");
		}
		
		return "stranice/PrikazSlike";
     }
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// -------------------- ostavljanje komentara za odabrani model naocara --------------------------------
	@RequestMapping(value = "/ostaviKomentar", method = RequestMethod.GET)
	public String getKomentar(Integer idNaocara, HttpServletRequest request) {
		
		Naocare naocare = nr.findById(idNaocara).get();
		request.getSession().setAttribute("naocare", naocare);
		
		return "unos/DodajKomentar";
	}
	
	@RequestMapping(value = "/dodajKomentar", method = RequestMethod.POST)
	public String dodajKomentar(Double ocena, String komentar, HttpServletRequest request, Model m) {

		Naocare n = (Naocare) request.getSession().getAttribute("naocare");

		Ocena o = new Ocena();
		o.setOcena(ocena);
		o.setKomentar(komentar);
		o.setNaocare(n);
		
		Ocena oc = or.save(o);
		
		m.addAttribute("ocena", oc);
		m.addAttribute("porukaOcena", "Komentar i ocena za odabrani model naocara su uspesno dodati!");
		
		return "unos/DodajKomentar";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ------------------------------------------------------------------------------------------------------
	@ModelAttribute("naocare")
	public List<Naocare> getNaocare(){
		
		return nr.findAll();
	}
	
	@ModelAttribute("dodaci")
	public List<Dodatak> getDodaci(){
		
		return dor.findAll();
	}
	
	@ModelAttribute("brendovi")
	public List<Brend> getBrendovi(){
		
		return br.findAll();
	}
	
	@ModelAttribute("kategorije")
	public List<Kategorija> getKategorije(){
		
		return kr.findAll();
	}
	// ------------------------------------------------------------------------------------------------------

	
	// ------------------------------- prikaz brendova ------------------------------------------------------
	@RequestMapping(value = "/getBrendovi", method = RequestMethod.GET)
	public String pretragaPoBrendu() {
		
		return "stranice/PretragaPoBrendu";
	}
	
	@RequestMapping(value = "/prikaziNaocareBrenda", method = RequestMethod.GET)
	public String getNaocareBrenda(Integer brend, HttpServletRequest request, Model m) {
		
		Brend brendP = br.findById(brend).get();
		List<Naocare> naocareBrenda = nr.findByBrend(brendP);
		
		if(naocareBrenda.size() == 0) {
			m.addAttribute("nemaPonuda", "Nazalost, trenutno ne postoje modeli naocara izabranog brenda u ponudi...");
		}
		
		request.getSession().setAttribute("naocareBrenda", naocareBrenda);
		
		return "stranice/PrikazBrendova";
	}
	
	@RequestMapping(value = "/prikazSlike", method = RequestMethod.GET)
	public String prikazSlike(Integer idNaocara, HttpServletResponse response, Model m) throws Exception {
		
		Naocare naocare = nr.findById(idNaocara).get();
		byte[] slika = naocare.getSlika();
		
		if(slika != null) {
			response.setContentType("image/jpeg");
			m.addAttribute("slika", Base64.getEncoder().encodeToString(slika));
		
		} else {
			m.addAttribute("poruka", "Nazalost, trenutno ne postoji slika za izabran model naocara....");
		}
		
		return "stranice/PrikazBrendova";
     }
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ----------------------------- prikaz kategorija ------------------------------------------------------
	@RequestMapping(value = "/getKategorije", method = RequestMethod.GET)
	public String pretragaPoKategoriji() {
		
		return "stranice/PretragaPoKategoriji";
	}
	
	@RequestMapping(value = "/prikaziNaocareIzabraneKategorije", method = RequestMethod.GET)
	public String getNaocareIzabraneKategorije(Integer kategorija, HttpServletRequest request, Model m) {
		
		
		Kategorija k = kr.findById(kategorija).get();
		List<Naocare> naocareIzabraneKategorije = nr.findByKategorija(k);
		
		if(naocareIzabraneKategorije.size() == 0) {
			m.addAttribute("nemaPonuda", "Nazalost, trenutno ne postoje modeli naocara izabrane kategorije u ponudi...");
		}
		
		request.getSession().setAttribute("naocareIzabraneKat", naocareIzabraneKategorije);
		return "stranice/PrikazKategorija";
	}
	
	
	@RequestMapping(value = "/prikazSlikeZaKat", method = RequestMethod.GET)
	public String prikazSlikeZaKat(Integer idNaocara, HttpServletResponse response, Model m) throws Exception {
		
		Naocare naocare = nr.findById(idNaocara).get();
		byte[] slika = naocare.getSlika();
		
		if(slika != null) {
			response.setContentType("image/jpeg");
			m.addAttribute("slika", Base64.getEncoder().encodeToString(slika));
		
		} else {	
			m.addAttribute("poruka", "Nazalost, trenutno ne postoji slika za izabrani model naocara...");
		}
		
		return "stranice/PrikazKategorija";
     }
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ---------------------------- porucivanje naocara -----------------------------------------------------
	@RequestMapping(value = "/kreirajPorudzbinu", method = RequestMethod.GET)
	public String getPorudzbina() {
		
		return "unos/UnosPorudzbine";
	}
	
	@RequestMapping(value = "/savePorudzbina", method = RequestMethod.POST)
	public String kreirajPorudzbinu(Integer[] naocare, String email, String adresa,
			                         Date datumIsporuke, String nacinPlacanja, Integer[] dodaci, Model m) {
		
		
		Porudzbina porudzbina = new Porudzbina();
		double ukupnaCena = 0;
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		
		NaocareshopKorisnik korisnik = nkr.findByUsername(username);
		
		//porudzbina.setNarucilac(narucilac);
		porudzbina.setNarucilac(korisnik.getIme() + " " + korisnik.getPrezime());
		porudzbina.setAdresa(adresa);
		porudzbina.setEmail(email);
		porudzbina.setDatumIsporuke(datumIsporuke);
		porudzbina.setNacinPlacanja(nacinPlacanja);
		
		
		for(Integer n : naocare) {
				
			Naocare naocareI = nr.findById(n).get();
			ukupnaCena += naocareI.getCena();
				
			porudzbina.addNaocare(naocareI);
		}
		
		if(dodaci != null) {
			
			for(Integer d : dodaci) {
				
				Dodatak dodatak = dor.findById(d).get();
				ukupnaCena += dodatak.getCena();	
				
				porudzbina.addDodatak(dodatak);
				dodatak.getPorudzbinas().add(porudzbina);
			}			
		}
		
		porudzbina.setUkupnaCena(ukupnaCena);
		
		Porudzbina por = pr.save(porudzbina);
		
		m.addAttribute("porudzbina", por);
		m.addAttribute("porukaPorudzbina", "Vasa porudzbina je uspesno sacuvana!");
		
		return "unos/UnosPorudzbine";
	}
	// ------------------------------------------------------------------------------------------------------

	// --------------------------- metoda za datum ----------------------------------------------------------
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ---------------------------- izvestaj ----------------------------------------------------------------
	@RequestMapping(value = "/getZadatiRasponCena", method = RequestMethod.GET)
	public String getZadateDatume() {
		
		return "stranice/ZadataCenaNaocara";
	}

	
	@RequestMapping(value = "/getZadateCene", method = RequestMethod.GET)
	public void getZadateCene(double cenaOd, double cenaDo, HttpServletResponse response) throws Exception {
		
		List<Naocare> naocare = nr.getNaocareZaOpsegCena(cenaOd, cenaDo);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(naocare);
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/NaocareUOpseguCena.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cenaOd", cenaOd);
		params.put("cenaDo", cenaDo);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		
		response.setContentType("application/x-download");
		response.setHeader("Content-disposition", "attachment; fileName = NaocareUOpseguCena.pdf");
		
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------
}
