package com.moz.policemanager.ui.response;

public class VeiculoRest {
	
	private String mark;
	private String color;
	private String placCar;
	private String veiculoCode;
	private ModeloRest modeloRest;
	private FabricanteRest fabricanteRest;
	
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
	
	public String getVeiculoCode() {
		return veiculoCode;
	}
	public void setVeiculoCode(String veiculoCode) {
		this.veiculoCode = veiculoCode;
	}
	
	public ModeloRest getModeloRest() {
		return modeloRest;
	}
	public void setModeloRest(ModeloRest modeloRest) {
		this.modeloRest = modeloRest;
	}
	
	public FabricanteRest getFabricanteRest() {
		return fabricanteRest;
	}
	public void setFabricanteRest(FabricanteRest fabricanteRest) {
		this.fabricanteRest = fabricanteRest;
	}
}
