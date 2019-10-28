package com.sec.sec.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sec.sec.repository.Usuario;
import com.sec.sec.repository.UsuarioRepository;

@Service
public class UserDatailsServicePer implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("email: " + email);
		Optional<Usuario> usOptional = repository.findByEmail(email);
		Usuario usuario = usOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha invalidos"));
		return new User(email, usuario.getSenha(), addAuthorities(usuario));
	}

	private Collection<? extends GrantedAuthority> addAuthorities(Usuario usuario) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		usuario.getPermissoes()
				.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));
		return authorities;
	}

}
