package com.igti.dominio.app.custom;

import java.util.List;

import org.springframework.stereotype.Component;

import com.igti.dominio.app.model.Dominio;

public interface IDominioRepositoryCustom {
	
	public List<Dominio> findByValoresPorCodigo(final Integer codigoDominio) throws Exception;

}
