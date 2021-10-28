package com.moz.policemanager.domain.service;

import java.util.List;

import com.moz.policemanager.ui.request.DistritoRequest;
import com.moz.policemanager.ui.response.DistritoRest;

public interface DistritoServiceResource {
	
	public List<DistritoRest> list();
	public DistritoRest search(Long id);
	public DistritoRest create(DistritoRequest distritoRequest);
	public boolean delete(Long id);
	public DistritoRest update(DistritoRequest distritoRequest, Long id);
}
