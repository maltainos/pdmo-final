package com.moz.policemanager.domain.dto;

import com.moz.policemanager.domain.entity.Categoria;

public class ModeloDto {
	
	private Long id;
	private String modeloCode;
	private String descricao;
	private Categoria categoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModeloCode() {
		return modeloCode;
	}
	public void setModeloCode(String modeloCode) {
		this.modeloCode = modeloCode;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
