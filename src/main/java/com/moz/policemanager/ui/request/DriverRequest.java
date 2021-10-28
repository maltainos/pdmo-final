package com.moz.policemanager.ui.request;

public class DriverRequest {
	
	private String nome;
	private String apelido;
	private String documentoId;
	private String cartaConducao;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	
	public String getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(String documentoId) {
		this.documentoId = documentoId;
	}
	
	
	public String getCartaConducao() {
		return cartaConducao;
	}
	public void setCartaConducao(String cartaConducao) {
		this.cartaConducao = cartaConducao;
	}	
}
