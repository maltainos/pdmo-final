package com.moz.policemanager.ui.request;

import com.moz.policemanager.domain.entity.Categoria;

public class ModeloRequest {
	
	private String descricao;
	private Categoria categoria;
	
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
