package com.moz.policemanager.domain.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;


import com.moz.policemanager.domain.entity.Driver;
import com.moz.policemanager.domain.entity.Inflacao;
import com.moz.policemanager.domain.entity.LocalEmissao;
import com.moz.policemanager.domain.entity.StatusMulta;
import com.moz.policemanager.domain.entity.User;
import com.moz.policemanager.domain.entity.Veiculo;

public class MultaDto {
	
	private Long id;
	private String multaCode;
	private Driver driver;
	private Veiculo veiculo;
	private User user;
	private List<Inflacao> inflacao;
	private BigDecimal valorMultado;
	private String descricao;
	private StatusMulta statusMulta;
	private LocalEmissao localEmissao;
	private OffsetDateTime dataEmissao;
	private OffsetDateTime dataPagamento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMultaCode() {
		return multaCode;
	}
	public void setMultaCode(String multaCode) {
		this.multaCode = multaCode;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Inflacao> getInflacao() {
		return inflacao;
	}
	public void setInflacao(List<Inflacao> inflacao) {
		this.inflacao = inflacao;
	}
	public BigDecimal getValorMultado() {
		return valorMultado;
	}
	public void setValorMultado(BigDecimal valorMultado) {
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
	public OffsetDateTime getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(OffsetDateTime dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public OffsetDateTime getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(OffsetDateTime dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}
