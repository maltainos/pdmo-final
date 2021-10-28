package com.moz.policemanager.domain.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.policemanager.domain.dto.DistritoDto;
import com.moz.policemanager.domain.entity.Distrito;
import com.moz.policemanager.domain.repository.DistritoRepository;
import com.moz.policemanager.domain.service.DistritoServiceResource;
import com.moz.policemanager.ui.request.DistritoRequest;
import com.moz.policemanager.ui.response.DistritoRest;

@Service
public class DistritoService implements DistritoServiceResource{
	
	@Autowired
	private DistritoRepository repository;

	@Override
	public List<DistritoRest> list() {
		
		List<DistritoRest> returnValue = new ArrayList<DistritoRest>();
		
		List<Distrito> distritos = repository.findAll();
		
		for(Distrito distrito : distritos) {
			
			DistritoDto distritoDto = new DistritoDto();
			BeanUtils.copyProperties(distrito, distritoDto);
			
			DistritoRest distritoRest = new DistritoRest();
			BeanUtils.copyProperties(distritoDto, distritoRest);
	
			returnValue.add(distritoRest);
		}
		return returnValue;
	}

	@Override
	public DistritoRest search(Long id) {
		Optional<Distrito> findValue = repository.findById(id);
		
		if(findValue.isPresent()) {
			
			Distrito distrito = findValue.get();
			DistritoDto distritoDto = new DistritoDto();
			BeanUtils.copyProperties(distrito, distritoDto);
			
			DistritoRest returnValue = new DistritoRest();
			BeanUtils.copyProperties(distritoDto, returnValue);
			
			return returnValue;
		}
		return null;
	}

	@Override
	public DistritoRest create(DistritoRequest provinciaRequest) {
		
		DistritoDto distritoDto = new DistritoDto();
		BeanUtils.copyProperties(provinciaRequest, distritoDto);
		
		Distrito distrito =  new Distrito();
		BeanUtils.copyProperties(distritoDto, distrito);
		
		distrito = repository.save(distrito);
		BeanUtils.copyProperties(distrito, distritoDto);
		
		DistritoRest returnValue = new DistritoRest();
		BeanUtils.copyProperties(distritoDto, returnValue);
		
		return returnValue;
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
	public DistritoRest update(DistritoRequest distritoRequest, Long id) {
		if(repository.existsById(id)) {
			DistritoDto distritoDto = new DistritoDto();
			BeanUtils.copyProperties(distritoRequest, distritoDto);
			distritoDto.setId(id);
			
			Distrito distrito =  new Distrito();
			BeanUtils.copyProperties(distritoDto, distrito);
			
			distrito = repository.save(distrito);
			BeanUtils.copyProperties(distrito, distritoDto);
		
			DistritoRest returnValue = new DistritoRest();
			BeanUtils.copyProperties(distritoDto, returnValue);
			return returnValue;
		}
		return null;
	}

}






