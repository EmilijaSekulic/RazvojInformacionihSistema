package naocare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/auth/**").permitAll()
		.antMatchers("/","/loginPage").permitAll()
		.antMatchers("/ucesnici/**").hasAnyRole("ADMINISTRATOR", "KORISNIK")
		.antMatchers("/korisnici/**").hasRole("KORISNIK")
		.antMatchers("/administrator/**").hasRole("ADMINISTRATOR")
		.and()
		.formLogin()
		.loginPage("/auth/loginPage")
		.loginProcessingUrl("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.defaultSuccessUrl("/auth/pocetna").and()
		.exceptionHandling().accessDeniedPage("/access_denied.jsp")
		.and().csrf().disable()
		.logout()
		.logoutSuccessUrl("/");	
	}
}
