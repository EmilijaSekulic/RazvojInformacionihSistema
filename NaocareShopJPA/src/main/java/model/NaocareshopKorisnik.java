package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the naocareshop_korisnik database table.
 * 
 */
@Entity
@Table(name="naocareshop_korisnik")
@NamedQuery(name="NaocareshopKorisnik.findAll", query="SELECT n FROM NaocareshopKorisnik n")
public class NaocareshopKorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorisnik;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-many association to NaocareshopUloga
	@ManyToMany(mappedBy="naocareshopKorisniks", fetch=FetchType.EAGER)
	private Set<NaocareshopUloga> naocareshopUlogas = new HashSet<NaocareshopUloga>();

	public NaocareshopKorisnik() {
	}

	public int getIdkorisnik() {
		return this.idkorisnik;
	}

	public void setIdkorisnik(int idkorisnik) {
		this.idkorisnik = idkorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<NaocareshopUloga> getNaocareshopUlogas() {
		return this.naocareshopUlogas;
	}

	public void setNaocareshopUlogas(Set<NaocareshopUloga> naocareshopUlogas) {
		this.naocareshopUlogas = naocareshopUlogas;
	}
	
	public void addRole(NaocareshopUloga u) {
		this.naocareshopUlogas.add(u);
	}
}