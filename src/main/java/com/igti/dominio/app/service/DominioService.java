package com.igti.dominio.app.service;


import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.igti.dominio.app.domain.Generico;
import com.igti.dominio.app.domain.TipoSeguro;
import com.igti.dominio.app.exceptions.DataIntegrityException;
import com.igti.dominio.app.model.Dominio;
import com.igti.dominio.app.repository.DominioRepository;


@Named
@Transactional
public class DominioService{
	
	
	@Inject
	private DominioRepository dominioRepository;

	public Generico find(Integer codigoDominio) {

		/*
		 * UserSS user = UserService.authenticated(); if (user == null ||
		 * !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) { throw new
		 * AuthorizationException("Acesso negado"); }
		 */

		Optional<Generico> obj = dominioRepository.findById(codigoDominio);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + codigoDominio + ", Tipo: " + Generico.class.getName(), null);
		}
		return obj.orElse(null);
	}
	
	@Transactional
	public Generico insert(Generico obj) {
		obj.setCodigoDominio(null);
		obj = dominioRepository.save(obj);
		return obj;
	}
	
	public Generico update(Generico obj) {
		Generico newObj = find(obj.getCodigoDominio());
		updateData(newObj, obj);
		return dominioRepository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			dominioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há domínios relacionados");
		}
	}
	
	private void updateData(Generico newObj, Generico obj) {
		newObj.setNomeCodigoFisico(obj.getNomeCodigoFisico());
		newObj.setNomeColunaFisco(obj.getNomeColunaFisco());
		newObj.setNomeLogico(obj.getNomeLogico());
		newObj.setNomeTabelaFisico(obj.getNomeTabelaFisico());
	}
	
	public List<Generico> findAll() {
		return dominioRepository.findAll();
	}
	
	public Page<Generico> findPage (Integer page, Integer linesPerPage, String direction, String orderBy){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return dominioRepository.findAll(pageRequest);
	}
	
	public List<Dominio> findValoresDominios(Integer codigoDominio) throws Exception {
			
		return dominioRepository.findByValoresPorCodigo(codigoDominio);
	}
}
