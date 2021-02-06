package com.igti.dominio.app.dto;

import java.io.Serializable;

import com.igti.dominio.app.domain.Generico;
import com.igti.dominio.app.model.Dominio;


public class GenericoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String  nomeLogico;
		
	public GenericoDTO() {
		
	}

	public GenericoDTO(Integer codigo, String nomeLogico) {
		super();
		this.codigo = codigo;
		this.nomeLogico = nomeLogico;
	}

	public GenericoDTO(Generico obj) {
		
		codigo = obj.getCodigoDominio();
		nomeLogico = obj.getNomeLogico();
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public String getNomeLogico() {
		return nomeLogico;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public void setNomeLogico(String nomeLogico) {
		this.nomeLogico = nomeLogico;
	}

}
