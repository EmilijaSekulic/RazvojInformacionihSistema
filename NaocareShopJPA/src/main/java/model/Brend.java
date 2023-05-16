package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the brend database table.
 * 
 */
@Entity
@NamedQuery(name="Brend.findAll", query="SELECT b FROM Brend b")
public class Brend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbrend;

	@Column(name="IME_BRENDA")
	private String imeBrenda;

	//bi-directional many-to-one association to Naocare
	@OneToMany(mappedBy="brend")
	private List<Naocare> naocares = new ArrayList<Naocare>();

	public Brend() {
	}

	public int getIdbrend() {
		return this.idbrend;
	}

	public void setIdbrend(int idbrend) {
		this.idbrend = idbrend;
	}

	public String getImeBrenda() {
		return this.imeBrenda;
	}

	public void setImeBrenda(String imeBrenda) {
		this.imeBrenda = imeBrenda;
	}

	public List<Naocare> getNaocares() {
		return this.naocares;
	}

	public void setNaocares(List<Naocare> naocares) {
		this.naocares = naocares;
	}

	public Naocare addNaocare(Naocare naocare) {
		getNaocares().add(naocare);
		naocare.setBrend(this);

		return naocare;
	}

	public Naocare removeNaocare(Naocare naocare) {
		getNaocares().remove(naocare);
		naocare.setBrend(null);

		return naocare;
	}

}