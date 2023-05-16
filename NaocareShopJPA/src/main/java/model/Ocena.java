package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ocena database table.
 * 
 */
@Entity
@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idocena;

	private String komentar;

	//bi-directional many-to-one association to Naocare
	@ManyToOne
	private Naocare naocare;

	private double ocena;

	public Ocena() {
	}

	public int getIdocena() {
		return this.idocena;
	}

	public void setIdocena(int idocena) {
		this.idocena = idocena;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public double getOcena() {
		return this.ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public Naocare getNaocare() {
		return this.naocare;
	}

	public void setNaocare(Naocare naocare) {
		this.naocare = naocare;
	}

}