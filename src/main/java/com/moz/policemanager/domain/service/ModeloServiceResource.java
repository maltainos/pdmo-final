package com.moz.policemanager.domain.service;

import java.util.List;

import com.moz.policemanager.ui.request.ModeloRequest;
import com.moz.policemanager.ui.response.ModeloRest;

public interface ModeloServiceResource {

	public List<ModeloRest> list();
	public ModeloRest searchById(Long id);
	public ModeloRest searchByCode(String code);
	public ModeloRest create(ModeloRequest modeloloRequest);
	public boolean delete(Long id);
	public ModeloRest update(ModeloRequest modeloloRequest, Long id);
}
