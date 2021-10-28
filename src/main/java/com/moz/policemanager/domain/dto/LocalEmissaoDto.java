package com.moz.policemanager.domain.dto;

import com.moz.policemanager.domain.entity.Localidade;

public class LocalEmissaoDto {
	
	private Long id;
	private String localEmissaoCode;
	private Localidade localidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocalEmissaoCode() {
		return localEmissaoCode;
	}
	public void setLocalEmissaoCode(String localEmissaoCode) {
		this.localEmissaoCode = localEmissaoCode;
	}
	public Localidade getLocalidade() {
		return localidade;
	}
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
	
	
}
