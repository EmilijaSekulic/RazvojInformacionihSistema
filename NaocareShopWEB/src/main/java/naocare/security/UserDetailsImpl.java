package naocare.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import model.NaocareshopUloga;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 2081918229049511173L;
	private String username;
	private String password;
	private Set<NaocareshopUloga> uloge;
	
	@Override
	public Collection<SimpleGrantedAuthority> getAuthorities() {
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		for(NaocareshopUloga u : uloge) {
			
			authorities.add(new SimpleGrantedAuthority("ROLE_" + u.getNaziv()));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	public Set<NaocareshopUloga> getUloge() {
		
		return uloge;
	}

	public void setUloge(Set<NaocareshopUloga> uloge) {
		
		this.uloge = uloge;
	}

	public void setUsername(String username) {
		
		this.username = username;
	}

	public void setPassword(String password) {
		
		this.password = password;
	}
}
