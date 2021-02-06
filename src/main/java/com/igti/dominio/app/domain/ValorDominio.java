package com.igti.dominio.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VALOR_DOMINIO")
public class ValorDominio {
	
	
	@Id
	private Integer codigo = null;
	private String nome;
	private Integer codigoGenerico = null;


	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigoGenerico() {
		return codigoGenerico;
	}

	public void setCodigoGenerico(Integer codigoGenerico) {
		this.codigoGenerico = codigoGenerico;
	}

	
}
