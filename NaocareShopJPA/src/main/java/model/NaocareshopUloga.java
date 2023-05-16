package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the naocareshop_uloga database table.
 * 
 */
@Entity
@Table(name="naocareshop_uloga")
@NamedQuery(name="NaocareshopUloga.findAll", query="SELECT n FROM NaocareshopUloga n")
public class NaocareshopUloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduloga;

	private String naziv;

	//bi-directional many-to-many association to NaocareshopKorisnik
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="naocareshop_uloga_has_naocareshop_korisnik"
		, joinColumns={
			@JoinColumn(name="NAOCARESHOP_ULOGA_IDULOGA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="NAOCARESHOP_KORISNIK_IDKORISNIK")
			}
		)
	private Set<NaocareshopKorisnik> naocareshopKorisniks = new HashSet<NaocareshopKorisnik>();

	public NaocareshopUloga() {
	}

	public int getIduloga() {
		return this.iduloga;
	}

	public void setIduloga(int iduloga) {
		this.iduloga = iduloga;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<NaocareshopKorisnik> getNaocareshopKorisniks() {
		return this.naocareshopKorisniks;
	}

	public void setNaocareshopKorisniks(Set<NaocareshopKorisnik> naocareshopKorisniks) {
		this.naocareshopKorisniks = naocareshopKorisniks;
	}

	public void addKorisnik(NaocareshopKorisnik k) {
		this.naocareshopKorisniks.add(k);
	}
}