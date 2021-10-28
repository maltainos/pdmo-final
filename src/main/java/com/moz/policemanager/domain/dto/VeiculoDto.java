package com.moz.policemanager.domain.dto;

public class VeiculoDto {

	private Long id;
	private String mark;
	private String color;
	private String placCar;
	private String veiculoCode;
	private ModeloDto modeloDto;
	private FabricanteDto fabricanteDto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVeiculoCode() {
		return veiculoCode;
	}
	public void setVeiculoCode(String veiculoCode) {
		this.veiculoCode = veiculoCode;
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
	
	public ModeloDto getModeloDto() {
		return modeloDto;
	}
	public void setModeloDto(ModeloDto modeloDto) {
		this.modeloDto = modeloDto;
	}
	
	public FabricanteDto getFabricanteDto() {
		return fabricanteDto;
	}
	public void setFabricanteDto(FabricanteDto fabricanteDto) {
		this.fabricanteDto = fabricanteDto;
	}
}
