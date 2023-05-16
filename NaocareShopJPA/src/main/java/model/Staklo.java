package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the staklo database table.
 * 
 */
@Entity
@NamedQuery(name="Staklo.findAll", query="SELECT s FROM Staklo s")
public class Staklo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idstaklo;

	@Column(name="VRSTA_STAKLA")
	private String vrstaStakla;

	//bi-directional many-to-one association to Naocare
	@OneToMany(mappedBy="staklo")
	private List<Naocare> naocares = new ArrayList<Naocare>();

	public Staklo() {
	}

	public int getIdstaklo() {
		return this.idstaklo;
	}

	public void setIdstaklo(int idstaklo) {
		this.idstaklo = idstaklo;
	}

	public String getVrstaStakla() {
		return this.vrstaStakla;
	}

	public void setVrstaStakla(String vrstaStakla) {
		this.vrstaStakla = vrstaStakla;
	}

	public List<Naocare> getNaocares() {
		return this.naocares;
	}

	public void setNaocares(List<Naocare> naocares) {
		this.naocares = naocares;
	}

	public Naocare addNaocare(Naocare naocare) {
		getNaocares().add(naocare);
		naocare.setStaklo(this);

		return naocare;
	}

	public Naocare removeNaocare(Naocare naocare) {
		getNaocares().remove(naocare);
		naocare.setStaklo(null);

		return naocare;
	}

}