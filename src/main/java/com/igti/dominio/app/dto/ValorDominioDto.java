package com.igti.dominio.app.dto;

import java.io.Serializable;

import com.igti.dominio.app.domain.Generico;
import com.igti.dominio.app.domain.ValorDominio;


public class ValorDominioDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String  nome;
	private Integer codigoGenerico;
	
	
	public ValorDominioDto() {
		
	}
	
	public ValorDominioDto(Integer codigo, String nome, Integer codigoGenerico) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.codigoGenerico = codigoGenerico;
	}


	public ValorDominioDto(ValorDominio obj) {
		
		codigo = obj.getCodigo();
		nome = obj.getNome();
		codigoGenerico = obj.getCodigoGenerico();
	}
	
	public Integer getCodigoDominio() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public void setNomeLogico(String nome) {
		this.nome = nome;
	}

	public Integer getCodigoGenerico() {
		return codigoGenerico;
	}

	public void setCodigoGenerico(Integer codigoGenerico) {
		this.codigoGenerico = codigoGenerico;
	}

}
