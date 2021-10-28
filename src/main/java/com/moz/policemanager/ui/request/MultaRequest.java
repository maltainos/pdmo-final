package com.moz.policemanager.ui.request;

import java.math.BigInteger;
import java.util.List;

import com.moz.policemanager.domain.entity.Inflacao;
import com.moz.policemanager.domain.entity.LocalEmissao;
import com.moz.policemanager.domain.entity.StatusMulta;

public class MultaRequest {

	private DriverRequest driver;
	private VeiculoRequest veiculo;
	private UserRequest user;
	private List<Inflacao> inflacao;
	private BigInteger valorMultado;
	private String descricao;
	private StatusMulta statusMulta;
	private LocalEmissao localEmissao;
	
	public DriverRequest getDriver() {
		return driver;
	}
	public void setDriver(DriverRequest driver) {
		this.driver = driver;
	}
	
	public VeiculoRequest getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(VeiculoRequest veiculo) {
		this.veiculo = veiculo;
	}
	
	public UserRequest getUser() {
		return user;
	}
	public void setUser(UserRequest user) {
		this.user = user;
	}
	
	public List<Inflacao> getInflacao() {
		return inflacao;
	}
	public void setInflacao(List<Inflacao> inflacao) {
		this.inflacao = inflacao;
	}
	
	public BigInteger getValorMultado() {
		return valorMultado;
	}
	public void setValorMultado(BigInteger valorMultado) {
		this.valorMultado = valorMultado;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public StatusMulta getStatusMulta() {
		return statusMulta;
	}
	public void setStatusMulta(StatusMulta statusMulta) {
		this.statusMulta = statusMulta;
	}
	
	public LocalEmissao getLocalEmissao() {
		return localEmissao;
	}
	public void setLocalEmissao(LocalEmissao localEmissao) {
		this.localEmissao = localEmissao;
	}
}
