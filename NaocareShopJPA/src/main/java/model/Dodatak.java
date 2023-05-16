package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the dodatak database table.
 * 
 */
@Entity
@NamedQuery(name="Dodatak.findAll", query="SELECT d FROM Dodatak d")
public class Dodatak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddodatak;

	private double cena;

	@Column(name="NAZIV_DODATKA")
	private String nazivDodatka;

	//bi-directional many-to-many association to Porudzbina
	@ManyToMany(mappedBy="dodataks")
	private List<Porudzbina> porudzbinas = new ArrayList<Porudzbina>();

	public Dodatak() {
	}

	public int getIddodatak() {
		return this.iddodatak;
	}

	public void setIddodatak(int iddodatak) {
		this.iddodatak = iddodatak;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNazivDodatka() {
		return this.nazivDodatka;
	}

	public void setNazivDodatka(String nazivDodatka) {
		this.nazivDodatka = nazivDodatka;
	}

	public List<Porudzbina> getPorudzbinas() {
		return this.porudzbinas;
	}

	public void setPorudzbinas(List<Porudzbina> porudzbinas) {
		this.porudzbinas = porudzbinas;
	}
}