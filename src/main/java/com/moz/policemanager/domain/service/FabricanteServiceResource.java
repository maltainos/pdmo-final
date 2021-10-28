package com.moz.policemanager.domain.service;

import java.util.List;

import com.moz.policemanager.ui.request.FabricanteRequest;
import com.moz.policemanager.ui.response.FabricanteRest;

public interface FabricanteServiceResource {
	
	public List<FabricanteRest> list();
	public FabricanteRest searchById(Long id);
	public FabricanteRest searchByCode(String code);
	public FabricanteRest create(FabricanteRequest fabricanteRequest);
	public boolean delete(Long id);
	public FabricanteRest update(FabricanteRequest fabricanteRequest, Long id);

}
