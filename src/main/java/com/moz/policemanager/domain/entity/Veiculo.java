package com.moz.policemanager.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "veiculos")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 30)
	private String veiculoCode;
	
	@NotBlank
	@Size(max = 60)
	@Column(length = 60, nullable = false)
	private String mark;
	
	@NotBlank
	@Size(max = 60)
	@Column(length = 60, nullable = false)
	private String color;
	
	@NotBlank
	@Size(max = 12)
	@Column(length = 12, nullable = false, unique = true)
	private String placCar;
	
	@ManyToOne
	private Modelo modelo;
	
	@ManyToOne
	private Fabricante fabricante;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getPlacCar() {
		return placCar;
	}
	public void setPlacCar(String placCar) {
		this.placCar = placCar;
	}

	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public String getVeiculoCode() {
		return veiculoCode;
	}
	public void setVeiculoCode(String veiculoCode) {
		this.veiculoCode = veiculoCode;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}	
}





