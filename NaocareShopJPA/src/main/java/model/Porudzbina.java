package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the porudzbina database table.
 * 
 */
@Entity
@NamedQuery(name="Porudzbina.findAll", query="SELECT p FROM Porudzbina p")
public class Porudzbina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idporudzbine;

	private String adresa;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_ISPORUKE")
	private Date datumIsporuke;

	private String email;

	@Column(name="NACIN_PLACANJA")
	private String nacinPlacanja;

	private String narucilac;

	@Column(name="UKUPNA_CENA")
	private double ukupnaCena;

	//bi-directional many-to-many association to Naocare
	@ManyToMany
	@JoinTable(
		name="porudzbina_has_naocare"
		, joinColumns={
			@JoinColumn(name="PORUDZBINA_IDPORUDZBINE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="NAOCARE_IDNAOCARE")
			}
		)
	private List<Naocare> naocares = new ArrayList<Naocare>();

	//bi-directional many-to-many association to Dodatak
	@ManyToMany
	@JoinTable(
		name="dodatak_has_porudzbina"
		, joinColumns={
			@JoinColumn(name="PORUDZBINA_IDPORUDZBINE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="DODATAK_IDDODATAK")
			}
		)
	private List<Dodatak> dodataks = new ArrayList<Dodatak>();

	public Porudzbina() {
	}

	public int getIdporudzbine() {
		return this.idporudzbine;
	}

	public void setIdporudzbine(int idporudzbine) {
		this.idporudzbine = idporudzbine;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getDatumIsporuke() {
		return this.datumIsporuke;
	}

	public void setDatumIsporuke(Date datumIsporuke) {
		this.datumIsporuke = datumIsporuke;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNacinPlacanja() {
		return this.nacinPlacanja;
	}

	public void setNacinPlacanja(String nacinPlacanja) {
		this.nacinPlacanja = nacinPlacanja;
	}

	public String getNarucilac() {
		return this.narucilac;
	}

	public void setNarucilac(String narucilac) {
		this.narucilac = narucilac;
	}

	public double getUkupnaCena() {
		return this.ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public List<Naocare> getNaocares() {
		return this.naocares;
	}

	public void setNaocares(List<Naocare> naocares) {
		this.naocares = naocares;
	}

	public List<Dodatak> getDodataks() {
		return this.dodataks;
	}

	public void setDodataks(List<Dodatak> dodataks) {
		this.dodataks = dodataks;
	}

	public void addNaocare(Naocare naocare) {

		this.getNaocares().add(naocare);
	}
	
	public void addDodatak(Dodatak dodatak) {
		
		this.getDodataks().add(dodatak);
	}
}