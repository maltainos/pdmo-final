package com.moz.policemanager.ui.response;

import com.moz.policemanager.domain.entity.Categoria;

public class ModeloRest {

	private String descricao;
	private String modeloCode;
	private Categoria categoria;
	
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
