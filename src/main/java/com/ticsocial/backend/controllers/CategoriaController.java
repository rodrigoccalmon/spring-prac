package com.ticsocial.backend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ticsocial.backend.entities.Categoria;
import com.ticsocial.backend.services.CategoriaService;

@RestController
@RequestMapping(value = "api/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> findById(@PathVariable Integer id) {
		Optional<Categoria> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
