package naocare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Brend;
import model.Kategorija;
import model.Naocare;

public interface NaocareRepository extends JpaRepository<Naocare, Integer> {

	public List<Naocare> findByBrend(Brend b);
	
	public List<Naocare> findByKategorija(Kategorija k);
	
	@Query("select n from Naocare n where n.cena between :cenaOd and :cenaDo order by n.cena")
	public List<Naocare> getNaocareZaOpsegCena(@Param("cenaOd") double cenaOd, @Param("cenaDo") double cenaDo);
	
	@Query("select n from Naocare n where n.slika = null")
	public List<Naocare> getNaocareBezSlike();
}
