package com.igti.dominio.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
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
	private String  nomeTabelaFisico;
	private String  nomeLogico;
	private String 	nomeCodigoFisico;
	private String  nomeColunaFisco;

	
	public DominioConfiguracao(Integer codigo, String nomeTabelaFisico, String nomeLogico, String nomeCodigoFisico, 
			String nomeColunaFisico) {
		super();
		this.codigo = codigo;
		this.nomeTabelaFisico = nomeTabelaFisico;
		this.nomeLogico = nomeLogico;
		this.nomeCodigoFisico = nomeCodigoFisico;
		this.nomeColunaFisco = nomeColunaFisico;
	}

	@Column(name="CODIGO", nullable=false, updatable=false, precision=5, scale=0)
	public Integer getCodigo() {
		return codigo;
	}

	@Column(name="NOMETABELAFISICO", nullable=false, length=20)
	public String getNomeTabelaFisico() {
		return nomeTabelaFisico;
	}

	@Column(name="NOMELOGICO", nullable=false, length=50)
	public String getNomeLogico() {
		return nomeLogico;
	}

	@Column(name="NOMECODIGOFISICO", nullable=false, length=30)
	public String getNomeCodigoFisico() {
		return nomeCodigoFisico;
	}

	@Column(name="NOMECOLUNAFISICO", nullable=false, length=30)
	public String getNomeColunaFisco() {
		return nomeColunaFisco;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public void setNomeTabelaFisico(String nomeTabelaFisico) {
		this.nomeTabelaFisico = nomeTabelaFisico;
	}


	public void setNomeLogico(String nomeLogico) {
		this.nomeLogico = nomeLogico;
	}


	public void setNomeCodigoFisico(String nomeCodigoFisico) {
		this.nomeCodigoFisico = nomeCodigoFisico;
	}


	public void setNomeColunaFisco(String nomeColunaFisco) {
		this.nomeColunaFisco = nomeColunaFisco;
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
