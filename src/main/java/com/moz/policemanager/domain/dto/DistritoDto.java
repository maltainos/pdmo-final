package com.moz.policemanager.domain.dto;

import com.moz.policemanager.domain.entity.Provincia;

public class DistritoDto {
	
	private Long id;
	private String nome;
	private Provincia provincia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
