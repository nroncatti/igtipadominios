package com.igti.dominio.app.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "DominioConfiguracao")
public class DominioConfiguracao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String  nomeCodigoFisico;
	private String  nomeLogico;
	private String 	nomeFisico;
	
	public DominioConfiguracao(Integer codigo, String nomeCodigoFisico, String nomeLogico, String nomeFisico) {
		super();
		this.codigo = codigo;
		this.nomeCodigoFisico = nomeCodigoFisico;
		this.nomeLogico = nomeLogico;
		this.nomeFisico = nomeFisico;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNomeCodigoFisico() {
		return nomeCodigoFisico;
	}

	public String getNomeLogico() {
		return nomeLogico;
	}

	public String getNomeFisico() {
		return nomeFisico;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setNomeCodigoFisico(String nomeCodigoFisico) {
		this.nomeCodigoFisico = nomeCodigoFisico;
	}

	public void setNomeLogico(String nomeLogico) {
		this.nomeLogico = nomeLogico;
	}

	public void setNomeFisico(String nomeFisico) {
		this.nomeFisico = nomeFisico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DominioConfiguracao other = (DominioConfiguracao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
