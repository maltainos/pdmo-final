package com.moz.policemanager.ui.response;

import com.moz.policemanager.domain.entity.Provincia;

public class DistritoRest {

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
