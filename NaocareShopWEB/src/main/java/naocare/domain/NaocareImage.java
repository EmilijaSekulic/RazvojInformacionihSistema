package naocare.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import model.Brend;
import model.Kategorija;
import model.Oblik;
import model.Staklo;

public class NaocareImage implements Serializable {

	private static final long serialVersionUID = 5837541344334189495L;
	
	private int idnaocare;
	private double cena;
	private String naziv;
	private Brend brend;
	private Kategorija kategorija;
	private Oblik oblik;
	private Staklo staklo;
	private MultipartFile slika;
	
	public NaocareImage() {
		
	}

	public int getIdnaocare() {
		return idnaocare;
	}

	public void setIdnaocare(int idnaocare) {
		this.idnaocare = idnaocare;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Brend getBrend() {
		return brend;
	}

	public void setBrend(Brend brend) {
		this.brend = brend;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Oblik getOblik() {
		return oblik;
	}

	public void setOblik(Oblik oblik) {
		this.oblik = oblik;
	}

	public Staklo getStaklo() {
		return staklo;
	}

	public void setStaklo(Staklo staklo) {
		this.staklo = staklo;
	}

	public MultipartFile getSlika() {
		return slika;
	}

	public void setSlika(MultipartFile slika) {
		this.slika = slika;
	}
}
