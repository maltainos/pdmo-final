package com.moz.policemanager.domain.dto;

public class FabricanteDto {
	
	private Long id;
	private String fabricanteCode;
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFabricanteCode() {
		return fabricanteCode;
	}
	public void setFabricanteCode(String fabricanteCode) {
		this.fabricanteCode = fabricanteCode;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
