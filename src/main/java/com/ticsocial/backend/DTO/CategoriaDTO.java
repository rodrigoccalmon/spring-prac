package com.ticsocial.backend.DTO;

import com.ticsocial.backend.entities.Categoria;

public class CategoriaDTO {

	private Integer id;
	private String nomeCategoria;
	private String descricaoCategoria;

	public CategoriaDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nomeCategoria = obj.getNomeCategoria();
		descricaoCategoria = obj.getDescricaoCategoria();
	}
}
