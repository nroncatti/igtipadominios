package com.igti.dominio.app.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igti.dominio.app.domain.Generico;
import com.igti.dominio.app.dto.GenericoDTO;
import com.igti.dominio.app.dto.ValorDominioDto;
import com.igti.dominio.app.model.Dominio;
import com.igti.dominio.app.service.DominioService;

@RestController
@RequestMapping(value="/dominios")
public class DominioApiController {

	@Inject
	private DominioService dominioService;
	
	
	@RequestMapping(value="/{codigoDominio}", method=RequestMethod.GET)
	public ResponseEntity<Generico> find(@PathVariable Integer codigoDominio) {
		Generico obj = dominioService.find(codigoDominio);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Generico obj) {
		
		obj = dominioService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{codigoDominio}").buildAndExpand(obj.getCodigoDominio()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{codigoDominio}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Generico obj, @PathVariable Integer codigoDominio) {
		obj = dominioService.update(obj);
		return ResponseEntity.noContent().build();
	}

	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{codigoDominio}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer codigoDominio) {
		dominioService.delete(codigoDominio);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity <List<GenericoDTO>> findAll() {
		List<Generico> obj = dominioService.findAll();
		List<GenericoDTO> listDto = obj.stream().map(objeto -> new GenericoDTO(objeto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/paged", method=RequestMethod.GET)
	public ResponseEntity <Page<Generico>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linePerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="direction", defaultValue="ASC") String direction, 
			@RequestParam(value="orderBy", defaultValue="nomeLogico") String orderBy) {
		Page<Generico> obj = dominioService.findPage(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/v1/{codigoDominio}/valores", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<List<Dominio>> findValoresDominios(@PathVariable Integer codigoDominio) throws Exception {

		List<Dominio> valorDominio = null;

		if (codigoDominio == null) {
			throw new Exception("Campo obrigatório");
		} else {

			valorDominio = dominioService.findValoresDominios(codigoDominio);
		}
		return new ResponseEntity<>(valorDominio, HttpStatus.OK);

	}
	
	@RequestMapping(value="/valores",
	method=RequestMethod.POST)
	public ResponseEntity<ValorDominioDto> cadastrarValorDominio(@RequestBody ValorDominioDto body) {
		
		ValorDominioDto response = dominioService.insertValorDominio(body);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/valores/{codigoValorDominio}",
	method=RequestMethod.PUT)
	public ResponseEntity<ValorDominioDto> atualizarValorDominio(@PathVariable final Integer codigoValorDominio,
			@RequestBody ValorDominioDto body) {
		
		final ValorDominioDto response = dominioService.atualizarValorDominio(body, codigoValorDominio);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
