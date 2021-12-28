package com.microservicios.usuarios.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.microservicios.usuarios.app.models.Usuario;
import com.microservicios.usuarios.app.services.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	
	
	@GetMapping
	public ResponseEntity<?>listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>ver(@PathVariable Long id){
		Optional<Usuario> o  = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}

	
	
	
	@PostMapping
	public ResponseEntity<?>crear(@RequestBody Usuario usuario){
		Usuario usuarioDb = service.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDb);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?>editar(@RequestBody Usuario usuario, @PathVariable Long id){
		Optional<Usuario> o  = service.findById(id);
	if (o.isEmpty()) {
		return ResponseEntity.notFound().build();
	}
	Usuario usuariodb = o.get();
	
	usuariodb.setNombre(usuario.getNombre());
	usuariodb.setApellido(usuario.getApellido());
	return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuariodb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
