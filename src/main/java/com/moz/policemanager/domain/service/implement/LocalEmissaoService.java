package com.moz.policemanager.domain.service.implement;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.policemanager.domain.dto.LocalEmissaoDto;
import com.moz.policemanager.domain.entity.LocalEmissao;
import com.moz.policemanager.domain.entity.Localidade;
import com.moz.policemanager.domain.repository.LocalEmissaoRepository;
import com.moz.policemanager.domain.repository.LocalidadeRepository;
import com.moz.policemanager.domain.service.LocalEmissaoServiceResource;
import com.moz.policemanager.domain.utils.GenerationCode;
import com.moz.policemanager.ui.request.LocalEmissaoRequest;

@Service
public class LocalEmissaoService implements LocalEmissaoServiceResource{

	@Autowired
	private LocalidadeRepository localidadeRepository;
	
	@Autowired
	private LocalEmissaoRepository repository;
	
	@Override
	public LocalEmissao create(LocalEmissaoRequest localEmissaoRequest) {
		GenerationCode codeResource = new GenerationCode();
		
		Optional<Localidade> localidade = localidadeRepository
				.findByLocalidadeCode(localEmissaoRequest.getLocalidade()
						.getLocalidadeCode());
		
		if(localidade.isPresent()) {
			localEmissaoRequest.setLocalidade(localidade.get());
			LocalEmissao localEmissao = fromRequestToEntity(localEmissaoRequest);
			localEmissao.setLocalEmissaoCode(codeResource.getCodeResource(30));
			return repository.save(localEmissao);
		}
		localEmissaoRequest.setLocalidade(localidade.get());
		return fromRequestToEntity(localEmissaoRequest);
	}
	
	private LocalEmissao fromRequestToEntity(LocalEmissaoRequest localEmissaoRequest) {
		
		LocalEmissaoDto localEmissaoDto = new LocalEmissaoDto();
		BeanUtils.copyProperties(localEmissaoRequest, localEmissaoDto);
		
		LocalEmissao returnValue = new LocalEmissao();
		BeanUtils.copyProperties(localEmissaoDto, returnValue);
		
		return returnValue;
	}

	
}










