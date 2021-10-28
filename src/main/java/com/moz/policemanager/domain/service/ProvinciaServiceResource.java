package com.moz.policemanager.domain.service;

import java.util.List;

import com.moz.policemanager.ui.request.ProvinciaRequest;
import com.moz.policemanager.ui.response.ProvinciaRest;

public interface ProvinciaServiceResource {
	
	public List<ProvinciaRest> list();
	public ProvinciaRest searchProvincia(Long id);
	public ProvinciaRest createProvincia(ProvinciaRequest provinciaRequest);
	public boolean deleteProvincia(Long id);
	public ProvinciaRest updateProvincia(ProvinciaRequest provinciaRequest, Long id);

}
