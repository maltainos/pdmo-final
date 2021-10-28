package com.moz.policemanager.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "models")
public class Modelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 30)
	private String modeloCode;
	
	@NotBlank
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getModeloCode() {
		return modeloCode;
	}
	public void setModeloCode(String modeloCode) {
		this.modeloCode = modeloCode;
	}
	@Override
	public String toString() {
		return "Modelo [id=" + id + ", modeloCode=" + modeloCode + ", descricao=" + descricao + ", categoria="
				+ categoria + "]";
	}
	
}
