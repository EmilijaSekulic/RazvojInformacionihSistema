package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the naocare database table.
 * 
 */
@Entity
@NamedQuery(name="Naocare.findAll", query="SELECT n FROM Naocare n")
public class Naocare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idnaocare;

	private double cena;

	private String naziv;

	//bi-directional many-to-one association to Brend
	@ManyToOne
	private Brend brend;

	//bi-directional many-to-one association to Kategorija
	@ManyToOne
	private Kategorija kategorija;

	//bi-directional many-to-one association to Oblik
	@ManyToOne
	private Oblik oblik;

	//bi-directional many-to-one association to Staklo
	@ManyToOne
	private Staklo staklo;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="naocare")
	private List<Ocena> ocenas = new ArrayList<Ocena>();

	//bi-directional many-to-many association to Porudzbina
	@ManyToMany(mappedBy="naocares")
	private List<Porudzbina> porudzbinas = new ArrayList<Porudzbina>();

	@Lob
	private byte[] slika;

	public Naocare() {
	}

	public int getIdnaocare() {
		return this.idnaocare;
	}

	public void setIdnaocare(int idnaocare) {
		this.idnaocare = idnaocare;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Brend getBrend() {
		return this.brend;
	}

	public void setBrend(Brend brend) {
		this.brend = brend;
	}

	public Kategorija getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Oblik getOblik() {
		return this.oblik;
	}

	public void setOblik(Oblik oblik) {
		this.oblik = oblik;
	}

	public Staklo getStaklo() {
		return this.staklo;
	}

	public void setStaklo(Staklo staklo) {
		this.staklo = staklo;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setNaocare(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setNaocare(null);

		return ocena;
	}

	public List<Porudzbina> getPorudzbinas() {
		return this.porudzbinas;
	}

	public void setPorudzbinas(List<Porudzbina> porudzbinas) {
		this.porudzbinas = porudzbinas;
	}

	public byte[] getSlika() {
		return slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}
}