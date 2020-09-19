package com.igti.dominio.app.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.igti.dominio.app.domain.DominioConfiguracao;
import com.igti.dominio.app.repository.DominioConfiguracaoRepository;

@Named
@Transactional
public class DominioServiceImpl implements IDominioService {
	
	@Inject
	private DominioConfiguracaoRepository dominioRespository;
	
	@Override
	public DominioConfiguracao findById(Integer codigoDominio) {
		// TODO Auto-generated method stub
		return dominioRespository.findById(codigoDominio).orElse(null);
	}
	
	/*
	 * @Autowired private DominioConfiguracaoRepository repository;
	 * 
	 * public DominioType buscarDominioPorCodigo(Integer codigoDominio) {
	 * 
	 * Optional<DominioType> obj = repository.findById(codigoDominio);
	 * 
	 * return obj.orElse(null);
	 * 
	 * }
	 */
	
	

}
