package com.moz.policemanager.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fabricantes")
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 30)
	private String fabricanteCode;
	
	@NotBlank
	@Size(max = 60)
	@Column(length = 60, nullable = false, unique = true)
	private String nome;
	
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
	public String getFabricanteCode() {
		return fabricanteCode;
	}
	public void setFabricanteCode(String fabricanteCode) {
		this.fabricanteCode = fabricanteCode;
	}
	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", fabricanteCode=" + fabricanteCode + ", nome=" + nome + "]";
	}
	
}
