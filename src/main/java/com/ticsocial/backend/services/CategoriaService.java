package com.ticsocial.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticsocial.backend.entities.Categoria;
import com.ticsocial.backend.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> findById(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj;
	}
	public List<Categoria> findAll() {
		return repo.findAll();
	}
}
