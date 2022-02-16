package com.ticsocial.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticsocial.backend.DTO.CategoriaDTO;
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

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNomeCategoria(), objDto.getDescricaoCategoria());
	}

	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
}
