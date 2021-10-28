package com.moz.policemanager.domain.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.policemanager.domain.dto.ProvinciaDto;
import com.moz.policemanager.domain.entity.Provincia;
import com.moz.policemanager.domain.repository.ProvinciaRepository;
import com.moz.policemanager.domain.service.ProvinciaServiceResource;
import com.moz.policemanager.ui.request.ProvinciaRequest;
import com.moz.policemanager.ui.response.ProvinciaRest;

@Service
public class ProvinciaService implements ProvinciaServiceResource{
	
	@Autowired
	private ProvinciaRepository repository;

	@Override
	public List<ProvinciaRest> list() {

		List<ProvinciaRest> returnValue = new ArrayList<ProvinciaRest>();
		
		List<Provincia> provincias = repository.findAll();
		
		for(Provincia provincia : provincias) {
			
			ProvinciaDto provinciaDto = new ProvinciaDto();
			BeanUtils.copyProperties(provincia, provinciaDto);
			
			ProvinciaRest provinciaRest = new ProvinciaRest();
			BeanUtils.copyProperties(provinciaDto, provinciaRest);
	
			returnValue.add(provinciaRest);
		}
		return returnValue;
	}

	@Override
	public ProvinciaRest searchProvincia(Long id) {
		Optional<Provincia> findValue = repository.findById(id);
		
		if(findValue.isPresent()) {
			
			Provincia provincia = findValue.get();
			ProvinciaDto provinciaDto = new ProvinciaDto();
			BeanUtils.copyProperties(provincia, provinciaDto);
			
			ProvinciaRest returnValue = new ProvinciaRest();
			BeanUtils.copyProperties(provinciaDto, returnValue);
			
			return returnValue;
		}
		return null;
	}

	@Override
	public ProvinciaRest createProvincia(ProvinciaRequest provinciaRequest) {
		
		ProvinciaDto provinciaDto = new ProvinciaDto();
		BeanUtils.copyProperties(provinciaRequest, provinciaDto);
		
		Provincia provincia =  new Provincia();
		BeanUtils.copyProperties(provinciaDto, provincia);
		
		provincia = repository.save(provincia);
		BeanUtils.copyProperties(provincia, provinciaDto);
		
		ProvinciaRest returnValue = new ProvinciaRest();
		BeanUtils.copyProperties(provinciaDto, returnValue);
		
		return returnValue;
	}

	@Override
	public boolean deleteProvincia(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public ProvinciaRest updateProvincia(ProvinciaRequest provinciaRequest, Long id) {
		if(repository.existsById(id)) {
			ProvinciaDto provinciaDto = new ProvinciaDto();
			BeanUtils.copyProperties(provinciaRequest, provinciaDto);
			provinciaDto.setId(id);
			
			Provincia provincia =  new Provincia();
			BeanUtils.copyProperties(provinciaDto, provincia);
			
			provincia = repository.save(provincia);
			BeanUtils.copyProperties(provincia, provinciaDto);
			
			ProvinciaRest returnValue = new ProvinciaRest();
			BeanUtils.copyProperties(provinciaDto, returnValue);
			return returnValue;
		}
		return null;
	}
	
}








