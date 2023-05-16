package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the kategorija database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorija.findAll", query="SELECT k FROM Kategorija k")
public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkategorije;

	@Column(name="NAZIV_KATEGORIJE")
	private String nazivKategorije;

	//bi-directional many-to-one association to Naocare
	@OneToMany(mappedBy="kategorija")
	private List<Naocare> naocares = new ArrayList<Naocare>();

	public Kategorija() {
	}

	public int getIdkategorije() {
		return this.idkategorije;
	}

	public void setIdkategorije(int idkategorije) {
		this.idkategorije = idkategorije;
	}

	public String getNazivKategorije() {
		return this.nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

	public List<Naocare> getNaocares() {
		return this.naocares;
	}

	public void setNaocares(List<Naocare> naocares) {
		this.naocares = naocares;
	}

	public Naocare addNaocare(Naocare naocare) {
		getNaocares().add(naocare);
		naocare.setKategorija(this);

		return naocare;
	}

	public Naocare removeNaocare(Naocare naocare) {
		getNaocares().remove(naocare);
		naocare.setKategorija(null);

		return naocare;
	}

}