package com.moz.policemanager.domain.service;

import java.util.List;

import com.moz.policemanager.domain.entity.Veiculo;
import com.moz.policemanager.ui.request.VeiculoRequest;
import com.moz.policemanager.ui.response.VeiculoRest;

public interface VeiculoServiceResource {

	List<VeiculoRest> list();
	VeiculoRest search(Long id);
	VeiculoRest create(VeiculoRequest veiculoRequest);
	boolean delete(Long id);
	VeiculoRest update(VeiculoRequest veiculoRequest, Long id);
	Veiculo createAndApplyMulta(VeiculoRequest veiculo);
}
