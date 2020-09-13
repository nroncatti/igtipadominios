package com.igti.dominio.app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igti.dominio.app.api.model.DominioType;
import com.igti.dominio.app.api.model.ValorDominioType;
import com.igti.dominio.app.domain.DominioConfiguracao;
import com.igti.dominio.app.repository.DominioConfiguracaoRepository;

@Service
public class DominioServiceImpl {
	
	@Autowired
	private DominioConfiguracaoRepository repository;
	
	public DominioType buscarDominioPorCodigo(Integer codigoDominio) {
		
	 	Optional<DominioType> obj = repository.findById(codigoDominio);
		
		return obj.orElse(null);
		
	}

}
