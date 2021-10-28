package com.moz.policemanager.ui.request;

import com.moz.policemanager.domain.entity.Provincia;

public class DistritoRequest {

	private String nome;
	private Provincia provincia;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
}
