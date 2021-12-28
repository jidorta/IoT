package com.microservicios.usuarios.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.usuarios.app.models.Usuario;
import com.microservicios.usuarios.app.repository.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService {
 
	 @Autowired 
	 private UsuarioRepository repository;
	 
	@Override
	public Iterable<Usuario> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
	
		return repository.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
	
		return repository.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
