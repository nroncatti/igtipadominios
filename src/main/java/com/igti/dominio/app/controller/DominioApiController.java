package com.igti.dominio.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igti.dominio.app.api.DominiosApi;
import com.igti.dominio.app.api.model.DominioPaginadoType;
import com.igti.dominio.app.api.model.DominioType;
import com.igti.dominio.app.api.model.ValorDominioType;

@RestController
public class DominioApiController implements DominiosApi{
	
	/**
	 * Constantes serao inclusas aqui
	 */
	
	private static final String CAMPO_OBRIGATORIO = "Campo Obrigatório";
	
	private static final String PATH = "/{id}";

	@Override
	@RequestMapping(value = "/v1/dominios/{codigoDominio}", produces = { MediaType.APPLICATION_JSON_VALUE },
	consumes = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<DominioType> buscarDominioPorCodigo(final Integer codigoDominio) {
		return null;
	
	}

	@Override
	public ResponseEntity<DominioType> criarDominios(DominioType body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DominioPaginadoType> dominiosGet(String nome, String orderByType, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DominioType> atualizarDominio(Integer codigoDominio, @Valid DominioType body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<ValorDominioType>> buscarValoresPorCodigo(Integer codigoDominio) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
