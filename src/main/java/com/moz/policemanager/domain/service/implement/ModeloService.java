package com.moz.policemanager.domain.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.policemanager.domain.dto.ModeloDto;
import com.moz.policemanager.domain.entity.Modelo;
import com.moz.policemanager.domain.repository.ModeloRepository;
import com.moz.policemanager.domain.service.ModeloServiceResource;
import com.moz.policemanager.domain.utils.GenerationCode;
import com.moz.policemanager.ui.request.ModeloRequest;
import com.moz.policemanager.ui.response.ModeloRest;

@Service
public class ModeloService implements ModeloServiceResource {
	
	@Autowired
	private ModeloRepository repository;

	@Override
	public List<ModeloRest> list() {
		
		List<ModeloRest> returnValue = new ArrayList<>();
		List<Modelo> modelos = repository.findAll();
		
		for(Modelo modelo: modelos)
			returnValue.add(fromEntityToRest(modelo));
		
		return returnValue;
	}

	@Override
	public ModeloRest searchById(Long id) {
		Optional<Modelo> modelo = repository.findById(id);
		if(modelo.isPresent())
			return fromEntityToRest(modelo.get());
		return null;
	}

	@Override
	public ModeloRest searchByCode(String code) {
		Optional<Modelo> modelo = repository.findByModeloCode(code);
		if(modelo.isPresent())
			return fromEntityToRest(modelo.get());
		return null;
	}

	@Override
	public ModeloRest create(ModeloRequest modeloRequest) {
		Modelo modelo = fromRequestToEntity(modeloRequest);
		GenerationCode codeResource = new GenerationCode();
		modelo.setModeloCode(codeResource.getCodeResource(30));
		return fromEntityToRest(repository.save(modelo));
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
	public ModeloRest update(ModeloRequest modeloloRequest, Long id) {
		
		return null;
	}
	
	public ModeloRest fromEntityToRest(Modelo modelo){
		ModeloDto modeloDto = new ModeloDto();
		BeanUtils.copyProperties(modelo, modeloDto);
		ModeloRest modeloRest = new ModeloRest();
		BeanUtils.copyProperties(modeloDto, modeloRest);
		return modeloRest;
	}
	
	public Modelo fromRequestToEntity(ModeloRequest modeloRequest){
		ModeloDto modeloDto = new ModeloDto();
		BeanUtils.copyProperties(modeloRequest, modeloDto);
		
		Modelo modelo = new Modelo();
		BeanUtils.copyProperties(modeloDto, modelo);
		return modelo;
	}

	
}













