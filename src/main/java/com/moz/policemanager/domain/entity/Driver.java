package com.moz.policemanager.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drivers")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 30)
	private String driverCode;
	
	@NotBlank
	@Size(max = 60)
	@Column(length = 20, nullable = false)
	private String nome;
	
	@NotBlank
	@Size(max = 20)
	@Column(length = 20, nullable = false)
	private String apelido;
	
	@NotBlank
	@Size(max = 60)
	@Column(length = 60, nullable = false, unique = true)
	private String documentoId;
	
	@NotBlank
	@ManyToMany
	private List<Veiculo> veiculos;
	
	
	@NotBlank
	@Size(max = 15)
	@Column(length = 15, nullable = false, unique = true)
	private String cartaConducao;
	
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
	
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public String getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(String documentoId) {
		this.documentoId = documentoId;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public String getCartaConducao() {
		return cartaConducao;
	}
	public void setCartaConducao(String cartaConducao) {
		this.cartaConducao = cartaConducao;
	}
	public String getDriverCode() {
		return driverCode;
	}
	public void setDriverCode(String driverCode) {
		this.driverCode = driverCode;
	}
}
