package com.igti.dominio.app.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igti.dominio.app.domain.Dominio;
import com.igti.dominio.app.service.DominioService;

@RestController
@RequestMapping(value="/dominios")
public class DominioApiController {

	
	@Autowired
	private DominioService dominioService;
	
	
	@RequestMapping(value="/{codigoDominio}", method=RequestMethod.GET)
	public ResponseEntity<Dominio> find(@PathVariable Integer codigoDominio) {
		Dominio obj = dominioService.find(codigoDominio);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Dominio obj) {
		
		obj = dominioService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{codigoDominio}").buildAndExpand(obj.getCodigoDominio()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{codigoDominio}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Dominio obj, @PathVariable Integer codigoDominio) {
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
	public ResponseEntity <List<Dominio>> findAll() {
		List<Dominio> obj = dominioService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
}
