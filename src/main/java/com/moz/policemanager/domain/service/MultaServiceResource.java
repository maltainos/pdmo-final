package com.moz.policemanager.domain.service;

import java.util.List;

import com.moz.policemanager.ui.request.MultaRequest;
import com.moz.policemanager.ui.response.MultaRest;

public interface MultaServiceResource {

	public List<MultaRest> list();
	public MultaRest searchByCode(Long id);
	public MultaRest create(MultaRequest multaRequest);
	public MultaRest update(MultaRest multaRest, Long id);
}
