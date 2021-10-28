package com.moz.policemanager.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inflacoes")
public class Inflacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 30)
	private String inflacaoCode;
	
	@Enumerated(EnumType.STRING)
	private TipoInflacao tipoInflacao;
	
	@Column(nullable = false)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoInflacao getTipoInflacao() {
		return tipoInflacao;
	}

	public void setTipoInflacao(TipoInflacao tipoInflacao) {
		this.tipoInflacao = tipoInflacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInflacaoCode() {
		return inflacaoCode;
	}

	public void setInflacaoCode(String inflacaoCode) {
		this.inflacaoCode = inflacaoCode;
	}

}










