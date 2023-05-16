package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the oblik database table.
 * 
 */
@Entity
@NamedQuery(name="Oblik.findAll", query="SELECT o FROM Oblik o")
public class Oblik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idoblik;

	@Column(name="NAZIV_OBLIKA")
	private String nazivOblika;

	//bi-directional many-to-one association to Naocare
	@OneToMany(mappedBy="oblik")
	private List<Naocare> naocares = new ArrayList<Naocare>();

	public Oblik() {
	}

	public int getIdoblik() {
		return this.idoblik;
	}

	public void setIdoblik(int idoblik) {
		this.idoblik = idoblik;
	}

	public String getNazivOblika() {
		return this.nazivOblika;
	}

	public void setNazivOblika(String nazivOblika) {
		this.nazivOblika = nazivOblika;
	}

	public List<Naocare> getNaocares() {
		return this.naocares;
	}

	public void setNaocares(List<Naocare> naocares) {
		this.naocares = naocares;
	}

	public Naocare addNaocare(Naocare naocare) {
		getNaocares().add(naocare);
		naocare.setOblik(this);

		return naocare;
	}

	public Naocare removeNaocare(Naocare naocare) {
		getNaocares().remove(naocare);
		naocare.setOblik(null);

		return naocare;
	}

}