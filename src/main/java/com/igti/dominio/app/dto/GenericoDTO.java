package com.igti.dominio.app.dto;

import java.io.Serializable;

import com.igti.dominio.app.domain.Generico;
import com.igti.dominio.app.model.Dominio;


public class GenericoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String  nome;
	
	
	public GenericoDTO() {
		
	}
	
	public GenericoDTO(Dominio obj) {
		
		codigo = obj.getCodigo();
		nome = obj.getNome();
	}
	
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

}
