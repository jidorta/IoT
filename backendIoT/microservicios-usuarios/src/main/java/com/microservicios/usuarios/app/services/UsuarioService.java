package com.microservicios.usuarios.app.services;

import java.util.Optional;

import com.microservicios.usuarios.app.models.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario>findAll();
	
	public Optional<Usuario>findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);

}
