package com.moz.policemanager.domain.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "multas")
public class Multa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 30)
	private String multaCode;
	
	@ManyToOne
	private Driver driver;
	
	@ManyToOne
	private Veiculo veiculo;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	private List<Inflacao> inflacao;
	
	@Column(nullable = false)
	private BigDecimal valorMultado;
	
	@Column(nullable = false)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusMulta statusMulta;
	
	@ManyToOne
	private LocalEmissao localEmissao;
	
	private OffsetDateTime dataEmissao;
	private OffsetDateTime dataPagamento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
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
	public String getMultaCode() {
		return multaCode;
	}
	public void setMultaCode(String multaCode) {
		this.multaCode = multaCode;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public LocalEmissao getLocalEmissao() {
		return localEmissao;
	}
	public void setLocalEmissao(LocalEmissao localEmissao) {
		this.localEmissao = localEmissao;
	}
}






