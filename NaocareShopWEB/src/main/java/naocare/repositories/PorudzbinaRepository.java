package naocare.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Porudzbina;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Integer> {

	@Query("select p from Porudzbina p where p.datumIsporuke between :datumOd and :datumDo order by p.datumIsporuke")
	public List<Porudzbina> getNaocareZaZadatiInterval(@Param("datumOd") Date datumOd, @Param("datumDo") Date datumDo);
}
