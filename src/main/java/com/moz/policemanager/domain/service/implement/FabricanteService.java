package com.moz.policemanager.domain.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.policemanager.domain.dto.FabricanteDto;
import com.moz.policemanager.domain.entity.Fabricante;
import com.moz.policemanager.domain.repository.FabricanteRepository;
import com.moz.policemanager.domain.service.FabricanteServiceResource;
import com.moz.policemanager.domain.utils.GenerationCode;
import com.moz.policemanager.ui.request.FabricanteRequest;
import com.moz.policemanager.ui.response.FabricanteRest;

@Service
public class FabricanteService implements FabricanteServiceResource {
	
	@Autowired
	private FabricanteRepository repository;

	@Override
	public List<FabricanteRest> list() {
		List<FabricanteRest> returnValue = new ArrayList<>();
		List<Fabricante> fabricantes = repository.findAll();
		
		for(Fabricante modelo: fabricantes)
			returnValue.add(fromEntityToRest(modelo));
		
		return returnValue;
	}

	@Override
	public FabricanteRest searchById(Long id) {
		Optional<Fabricante> findValue = repository.findById(id);
		if(findValue.isPresent())
			return fromEntityToRest(findValue.get());
		return null;
	}

	@Override
	public FabricanteRest searchByCode(String code) {
		Optional<Fabricante> modelo = repository.findByFabricanteCode(code);
		if(modelo.isPresent())
			return fromEntityToRest(modelo.get());
		return null;
	}

	@Override
	public FabricanteRest create(FabricanteRequest fabricanteRequest) {
		Fabricante fabricante = fromRequestToEntity(fabricanteRequest);
		GenerationCode codeResource = new GenerationCode();
		fabricante.setFabricanteCode(codeResource.getCodeResource(30));
		return fromEntityToRest(repository.save(fabricante));
	}

	@Override
	public boolean delete(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public FabricanteRest update(FabricanteRequest fabricanteRequest, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public FabricanteRest fromEntityToRest(Fabricante fabricante){
		FabricanteDto fabricanteDto = new FabricanteDto();
		BeanUtils.copyProperties(fabricante, fabricanteDto);
		FabricanteRest returnValue = new FabricanteRest();
		BeanUtils.copyProperties(fabricanteDto, returnValue);
		return returnValue;
	}
	
	public Fabricante fromRequestToEntity(FabricanteRequest fabricanteRequest){
		FabricanteDto fabricanteDto = new FabricanteDto();
		BeanUtils.copyProperties(fabricanteRequest, fabricanteDto);
		
		Fabricante returnValue = new Fabricante();
		BeanUtils.copyProperties(fabricanteDto, returnValue);
		return returnValue;
	}

}












