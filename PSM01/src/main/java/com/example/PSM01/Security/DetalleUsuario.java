package com.example.PSM01.Security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetalleUsuario implements UserDetailsService{
	@Autowired
	private IOperador iope;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Operador> reg=iope.findBynicope(username);
		if (reg.isPresent()) {
			Operador objus=reg.get();
			return User.builder()
					.username(objus.getNicope())
					.password((passwordEncoder()).encode(objus.getPasope()))
					.roles(objus.getRolope())
					.build();
		}
		else {
			throw new UsernameNotFoundException("Usuario no Existe....!");
		}		
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(this);
		return provider;
	}


	
}
