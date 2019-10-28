package com.sec.sec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sec.sec.repository.Permissao;
import com.sec.sec.repository.PermissaoRepository;
import com.sec.sec.repository.Usuario;
import com.sec.sec.repository.UsuarioRepository;

@SpringBootApplication
public class SecApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Permissao> permissoes = new ArrayList<>();
		Permissao cadastro = new Permissao(1L, "ROLE_CADASTRO");
		Permissao pesquisa = new Permissao(2L, "ROLE_PESQUISA");
		permissoes.add(pesquisa);
		permissaoRepository.save(pesquisa);
		permissoes.add(cadastro);
		permissaoRepository.save(cadastro);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senha = encoder.encode("admin");
		System.out.println(senha);
		
		Usuario usuario = new Usuario(null, "Saulo", "admin@admin.com", senha, true, permissoes);
	
		userRepository.save(usuario);
		
		System.out.println(usuario.toString());
	}

}
