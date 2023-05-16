package naocare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import model.NaocareshopKorisnik;
import naocare.repositories.NaocareshopKorisnikRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	NaocareshopKorisnikRepository nkr;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		NaocareshopKorisnik user = nkr.findByUsername(username);
		
		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setUsername(user.getUsername());
		userDetails.setPassword(user.getPassword());
		userDetails.setUloge(user.getNaocareshopUlogas());
		
		return userDetails;
	}
}
