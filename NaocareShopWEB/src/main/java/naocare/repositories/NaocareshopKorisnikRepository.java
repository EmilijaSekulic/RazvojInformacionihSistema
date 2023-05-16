package naocare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.NaocareshopKorisnik;

public interface NaocareshopKorisnikRepository extends JpaRepository<NaocareshopKorisnik, Integer> {

	NaocareshopKorisnik findByUsername(String username);
}
