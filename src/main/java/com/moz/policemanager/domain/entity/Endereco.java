package com.moz.policemanager.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enderecos")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 30)
	private String enderecoCode;
	
	@Column(nullable = false, length = 100)
	private String bairro;
	
	@Column(nullable = false, length = 4)
	private Integer rua;
	
	@Column(nullable = false, length = 4)
	private Integer numeroCasa;
	
	@ManyToOne
	private Localidade localidade;
	
	@ManyToOne
	private Driver driver;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getRua() {
		return rua;
	}

	public void setRua(Integer rua) {
		this.rua = rua;
	}

	public Integer getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(Integer numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public String getEnderecoCode() {
		return enderecoCode;
	}

	public void setEnderecoCode(String enderecoCode) {
		this.enderecoCode = enderecoCode;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}










