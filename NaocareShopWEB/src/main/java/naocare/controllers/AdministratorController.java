package naocare.controllers;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import model.Brend;
import model.Dodatak;
import model.Kategorija;
import model.Naocare;
import model.Oblik;
import model.Ocena;
import model.Porudzbina;
import model.Staklo;
import naocare.domain.NaocareImage;
import naocare.repositories.BrendRepository;
import naocare.repositories.DodatakRepository;
import naocare.repositories.KategorijaRepository;
import naocare.repositories.NaocareRepository;
import naocare.repositories.OblikRepository;
import naocare.repositories.OcenaRepository;
import naocare.repositories.PorudzbinaRepository;
import naocare.repositories.StakloRepository;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value = "/administrator")
public class AdministratorController {

	@Autowired
	KategorijaRepository kr;
	
	@Autowired
	BrendRepository br;
	
	@Autowired
	OblikRepository or;
	
	@Autowired
	StakloRepository sr;
	
	@Autowired
	NaocareRepository nr;
	
	@Autowired
	DodatakRepository doR;
	
	@Autowired
	OcenaRepository ocR;
	
	@Autowired
	PorudzbinaRepository pr;
	
	
	// -------------------- stranica za unos podataka vezanih za naocare ------------------------------------
		@RequestMapping(value = "/unosNoviteta", method = RequestMethod.GET)
		public String getNoviteti() {
			
			return "unos/UnosNoviteta";
		}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------
		
		
	
	// --------------- dodavanje nove kategorije naocara --------------------------------------------------
	@RequestMapping(value = "/unosKategorije", method = RequestMethod.GET)
	public String unosKategorije() {
		
		return "unos/UnosKategorije";
	}
	
	@RequestMapping(value = "/saveKategorija", method = RequestMethod.POST)
	public String saveKategorija(Kategorija k, Model m) {
		
		Kategorija kat = kr.save(k);
		
		m.addAttribute("kategorija", kat);
		m.addAttribute("porukaKategorija", "Kategorija je uspesno dodata!");
		
		return "unos/UnosKategorije";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ------------------- unos novog brenda naocara --------------------------------------------------------
	@RequestMapping(value = "/unosBrenda", method = RequestMethod.GET)
	public String unosBrenda() {
		
		return "unos/UnosBrenda";
	}
	
	@RequestMapping(value = "/saveBrend", method = RequestMethod.POST)
	public String saveBrend(Brend b, Model m) {
		
		Brend brend = br.save(b);
		
		m.addAttribute("brend", brend);
		m.addAttribute("porukaBrend", "Brend je uspesno dodat!");
		
		return "unos/UnosBrenda";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ------------------ unos novog oblika za naocare ------------------------------------------------------
	@RequestMapping(value = "/unosOblika", method = RequestMethod.GET)
	public String unosOblika() {
		
		return "unos/UnosOblika";
	}
	
	@RequestMapping(value = "/saveOblik", method = RequestMethod.POST)
	public String saveOblik(Oblik o, Model m) {
		
		Oblik oblik = or.save(o);
		
		m.addAttribute("oblik", oblik);
		m.addAttribute("porukaOblik", "Novi oblik naocara je uspesno dodat!");
		
		return "unos/UnosOblika";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ----------------- unos nove vrste stakla za naocare --------------------------------------------------
	@RequestMapping(value = "/unosStakla", method = RequestMethod.GET)
	public String unosStakla() {
		
		return "unos/UnosStakla";
	}
	
	@RequestMapping(value = "/saveStaklo", method = RequestMethod.POST)
	public String saveStaklo(Staklo s, Model m) {
		
		Staklo staklo = sr.save(s);
		
		m.addAttribute("staklo", staklo);
		m.addAttribute("porukaStaklo", "Nova vrsta stakla za naocare je dodata!");
		
		return "unos/UnosStakla";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ----------------------- unos novog dodatka za naocare ------------------------------------------------
	@RequestMapping(value = "/unosDodatka", method = RequestMethod.GET)
	public String unosDodatka() {
		
		return "unos/UnosDodatka";
	}
	
	@RequestMapping(value = "/saveDodatak", method = RequestMethod.POST)
	public String saveDodatak(Dodatak dodatak, Model m) {
		
		//Dodatnaoprema oprema = dor.save(dodatna);
		Dodatak dod = doR.save(dodatak);
		
		m.addAttribute("dodatak", dod);
		m.addAttribute("porukaDodatak", "Novi dodatak za naocare je uspesno dodat!");
		
		return "unos/UnosDodatka";

	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ------------------------------------------------------------------------------------------------------

	@ModelAttribute("kategorije")
	public List<Kategorija> getKategorije(){
		
		return kr.findAll();
	}
	
	@ModelAttribute("brendovi")
	public List<Brend> getBrendovi(){
		
		return br.findAll();
	}
	
	@ModelAttribute("oblici")
	public List<Oblik> getOblici(){
		
		return or.findAll();
	}
	
	@ModelAttribute("stakla")
	public List<Staklo> getStakla(){
		
		return sr.findAll();
	}
	// ------------------------------------------------------------------------------------------------------
	
	
	// ------------ unos nove ponude naocara ----------------------------------------------------------------
	@RequestMapping(value = "/unosPonude", method = RequestMethod.GET)
	public String unosPonude() {
		
		return "unos/UnosNovePonude";
	}
	
	@RequestMapping(value = "/savePonuda")
	public String savePonuda(String naziv, Double cena, Integer kategorija, Integer brend,
							 Integer oblik, Integer staklo, Model m) {
		
		Kategorija k = kr.findById(kategorija).get();
		Brend b = br.findById(brend).get();
		Oblik o = or.findById(oblik).get();
		Staklo s = sr.findById(staklo).get();
		
		Naocare n = new Naocare();
		n.setNaziv(naziv);
		n.setCena(cena);
		n.setKategorija(k);
		n.setBrend(b);
		n.setOblik(o);
		n.setStaklo(s);
		
		Naocare naocare = nr.save(n);
		
		m.addAttribute("naocare", naocare);
		m.addAttribute("porukaNaocare", "Nov model naocara je dodat u ponudu!");
				
		return "unos/UnosNovePonude";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ---------------- dodavanje slike ponudama koje nemaju sliku ------------------------------------------
	@RequestMapping(value = "/unosSlike", method = RequestMethod.GET)
	public String unosSlike(HttpServletRequest request) {
		
		List<Naocare> naocare = nr.getNaocareBezSlike();
		request.getSession().setAttribute("naocare", naocare);
		
		return "unos/UnosSlike";
	}
	
	@RequestMapping(value = "/dodavanjeSlike", method = RequestMethod.GET)
	public String dodavanjeSlike(Integer idNaocara,HttpServletRequest request) {
		
		Naocare naocareBezSlike = nr.findById(idNaocara).get();
		request.getSession().setAttribute("naocareBezSlike", naocareBezSlike);
		
		return "unos/DodavanjeSlike";
	}
	
	@RequestMapping(value = "/unesiSliku", method = RequestMethod.POST)
	public String unesiSliku(MultipartFile slika, HttpServletRequest request, Model m) {
		
		if(slika != null) {
			
			String fileName = slika.getOriginalFilename();
			//String filePath;
			
			try {
				
				/*
				filePath = System.getProperty("user.dir");
				System.out.println("Putanja je: " + filePath);
				File imageFile = new File(filePath, fileName);
				*/
				
				File imageFile = new File("C:\\Users\\Emilija\\Desktop\\RisProjekat\\NaocareShopWEB\\src\\main\\webapp\\slikeUpload", fileName);
				imageFile.createNewFile();
				
				// cuvanje u bazi
				slika.transferTo(imageFile);
				
				Naocare naocareBezSlike = (Naocare) request.getSession().getAttribute("naocareBezSlike");	
				naocareBezSlike.setSlika(Files.readAllBytes(imageFile.toPath()));
				nr.save(naocareBezSlike);
				
				m.addAttribute("naocarePromenjene", naocareBezSlike);
				m.addAttribute("porukaOPromeni", "Dodata je slika za izabrani model naocara!");
				
			} catch(Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return "unos/DodavanjeSlike";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ------------------ unos novog modela naocara bez slike ----------------------------------------------
	@RequestMapping(value = "/unosPonudeSaSlikom", method = RequestMethod.GET)
	public String initialize(Model m) {
		
		m.addAttribute("naocareI", new NaocareImage());
		
		return "unos/UnosNaocaraImg";
	}
	
	@RequestMapping(value = "/saveNaocareImg")
	public String saveNaocare(Model m, @ModelAttribute("naocareI") NaocareImage naocareImage, HttpServletRequest request) {
		
		MultipartFile file = naocareImage.getSlika();
		
		if(file != null) {
			
			String fileName = file.getOriginalFilename();
			//String filePath;
			
			try {
				
				/*
				filePath = System.getProperty("user.dir");
				System.out.println("Putanja je: " + filePath);
				File imageFile = new File(filePath, fileName);
				*/
				
				File imageFile = new File("C:\\Users\\Emilija\\Desktop\\RisProjekat\\NaocareShopWEB\\src\\main\\webapp\\slikeUpload", fileName);
				imageFile.createNewFile();
				
				// cuvanje u bazi
				file.transferTo(imageFile);
				
				Naocare n = new Naocare();
				n.setNaziv(naocareImage.getNaziv());
				n.setCena(naocareImage.getCena());
				n.setKategorija(naocareImage.getKategorija());
				n.setBrend(naocareImage.getBrend());
				n.setStaklo(naocareImage.getStaklo());
				n.setOblik(naocareImage.getOblik());
				n.setSlika(Files.readAllBytes(imageFile.toPath()));
				
				Naocare naocare = nr.save(n);
				request.getSession().setAttribute("naocareSaSlikom", naocare);
	
				m.addAttribute("naocare", naocare);
				m.addAttribute("poruka", "Novi model naocara sa slikom je dodat!");
				
			} catch(Exception e) {
				
				e.printStackTrace();
			}
		}
	
		return "unos/UnosNaocaraImg";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------
	
	
	// --------------------------- brisanje komenatara za odabrane naocare ----------------------------------
	@RequestMapping(value = "/obrisiOcenu")
	public String obrisiOcenu(Integer idO, Model m) {
		
		Ocena o = ocR.findById(idO).get();
		ocR.delete(o);
		
		List<Ocena> ocene = ocR.findAll();
		m.addAttribute("ocene", ocene);
		
		return "stranice/PrikazOcena";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// --------------------- azuriranje podataka vezanih za naocare -----------------------------------------
	@RequestMapping(value = "/azuriranjePodataka", method = RequestMethod.GET)
	public String azuriranjePodataka(HttpServletRequest request) {
		
		List<Naocare> naocare = nr.findAll();
		request.getSession().setAttribute("naocare", naocare);
		
		return "stranice/AzuriranjePodataka";
	}	
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// -------------------------- azuriranje naziva za odabrane naocare -------------------------------------
	@RequestMapping(value = "/azuriranjeNaziva", method = RequestMethod.GET)
	public String azurirajNaziv(Integer idN, HttpServletRequest request) {
		
		Naocare n = nr.findById(idN).get();
		request.getSession().setAttribute("naocareNaziv", n);
		
		return "stranice/AzuriranjeNaziva";
	}
	
	@RequestMapping(value = "/saveNaziv", method = RequestMethod.POST)
	public String saveNaziv(String naziv, Model m, HttpServletRequest request) {
		
		
		Naocare n1 = (Naocare) request.getSession().getAttribute("naocareNaziv");
		n1.setNaziv(naziv);
		nr.save(n1);
		
		List<Naocare> naocare = nr.findAll();
		m.addAttribute("naocare", naocare);
		
		return "stranice/AzuriranjePodataka";
	}
	
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// -------------------------- azuriranje cene za odabrane naocare ---------------------------------------
	@RequestMapping(value = "/azuriranjeCene", method = RequestMethod.GET)
	public String azurirajCenu(Integer idN, HttpServletRequest request) {
		
		Naocare n = nr.findById(idN).get();
		request.getSession().setAttribute("naocareCena", n);
		
		return "stranice/AzuriranjeCene";
	}
	
	@RequestMapping(value = "/saveCena", method = RequestMethod.POST)
	public String saveNaziv(Double cena, Model m, HttpServletRequest request) {
		
		
		Naocare n2 = (Naocare) request.getSession().getAttribute("naocareCena");
		n2.setCena(cena);
		nr.save(n2);
		
		List<Naocare> naocare = nr.findAll();
		m.addAttribute("naocare", naocare);
		
		return "stranice/AzuriranjePodataka";
	}
	
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------


	// ----------------------- brisanje odabranog modela naocara iz ponude ----------------------------------
	@RequestMapping(value = "/uklanjanjePodataka", method = RequestMethod.GET)
	public String uklanjanje(Integer idN, Model m) {
		
		Naocare n = nr.findById(idN).get();
		
		List<Porudzbina> porudzbine = n.getPorudzbinas();
		for(Porudzbina p : porudzbine) {
			pr.delete(p);
		}
		
		List<Ocena> ocene = n.getOcenas();
		for(Ocena o : ocene) {
			ocR.delete(o);
		}
		
		nr.delete(n);
		
		List<Naocare> naocare = nr.findAll();
		m.addAttribute("naocare", naocare);
		
		return "stranice/AzuriranjePodataka";
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ---------------------------------- izvestaj ----------------------------------------------------------
	@RequestMapping(value = "/getZadateDatume", method = RequestMethod.GET)
	public String getZadateDatume() {
		
		return "stranice/ZadatiDatumNaocara";
	}

	
	@RequestMapping(value = "/getZadatiInterval")
	public void prikaziIzvestaj(Date datumOd, Date datumDo, HttpServletResponse response) throws Exception {
		
		List<Porudzbina> porudzbine = pr.getNaocareZaZadatiInterval(datumOd, datumDo);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(porudzbine);
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/NaocareSaZadatimDatumom.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
			
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("datumOd", datumOd);		
		params.put("datumDo", datumDo);

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		
		response.setContentType("application/x-download");
		response.setHeader("Content-disposition", "attachment; fileName = NaocareSaZadatimDatumomIsporuke.pdf");
		
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

	
	// ------------------------ metoda za datum -------------------------------------------------------------
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------

}
