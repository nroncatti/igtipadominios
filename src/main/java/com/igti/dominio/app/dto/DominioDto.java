package com.igti.dominio.app.dto;

import java.io.Serializable;

import com.igti.dominio.app.domain.Generico;


public class DominioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codigoDominio;
	private String  nomeLogico;
	
	
	public DominioDTO() {
		
	}
	
	public DominioDTO(Generico obj) {
		
		codigoDominio = obj.getCodigoDominio();
		nomeLogico = obj.getNomeLogico();
	}
	
	public Integer getCodigoDominio() {
		return codigoDominio;
	}
	public String getNomeLogico() {
		return nomeLogico;
	}
	public void setCodigoDominio(Integer codigoDominio) {
		this.codigoDominio = codigoDominio;
	}
	public void setNomeLogico(String nomeLogico) {
		this.nomeLogico = nomeLogico;
	}

}
