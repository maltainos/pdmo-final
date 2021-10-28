package com.moz.policemanager.ui.request;

import com.moz.policemanager.domain.entity.Fabricante;
import com.moz.policemanager.domain.entity.Modelo;

public class VeiculoRequest {
	
	private String mark;
	private String color;
	private String placCar;
	private Modelo modeloRequest;
	private Fabricante fabricanteRequest;
	
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
	public Modelo getModeloRequest() {
		return modeloRequest;
	}
	public void setModeloRequest(Modelo modeloRequest) {
		this.modeloRequest = modeloRequest;
	}
	public Fabricante getFabricanteRequest() {
		return fabricanteRequest;
	}
	public void setFabricanteRequest(Fabricante fabricanteRequest) {
		this.fabricanteRequest = fabricanteRequest;
	}
	@Override
	public String toString() {
		return "VeiculoRequest [mark=" + mark + ", color=" + color + ", placCar=" + placCar + ", modeloRequest="
				+ modeloRequest + ", fabricanteRequest=" + fabricanteRequest + "]";
	}
}
