package com.moz.policemanager.domain.service;


import com.moz.policemanager.domain.entity.LocalEmissao;
import com.moz.policemanager.ui.request.LocalEmissaoRequest;

public interface LocalEmissaoServiceResource {
	
	public LocalEmissao create(LocalEmissaoRequest localEmissaoRequest);

}
