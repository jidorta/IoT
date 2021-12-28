package com.microservicios.usuarios.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservicios.usuarios.app.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
