package com.ticsocial.backend.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ticsocial.backend.DTO.CategoriaDTO;
import com.ticsocial.backend.entities.Categoria;
import com.ticsocial.backend.repositories.CategoriaRepository;
import com.ticsocial.backend.services.CategoriaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	@Autowired
	private CategoriaRepository repo;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "GET categoria via ID")
	public ResponseEntity<Optional<Categoria>> findById(@PathVariable Integer id) {
		Optional<Categoria> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto) {
		Categoria obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
