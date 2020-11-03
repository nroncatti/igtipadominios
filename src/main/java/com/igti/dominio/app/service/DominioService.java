package com.igti.dominio.app.service;


import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.igti.dominio.app.dao.DominioRepository;
import com.igti.dominio.app.domain.Dominio;
import com.igti.dominio.app.exceptions.DataIntegrityException;

@Service
public class DominioService{
	
	
	@Autowired
	private DominioRepository dominioRepository;

	public Dominio find(Integer codigoDominio) {

		/*
		 * UserSS user = UserService.authenticated(); if (user == null ||
		 * !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) { throw new
		 * AuthorizationException("Acesso negado"); }
		 */

		Dominio obj = dominioRepository.findOne(codigoDominio);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + codigoDominio + ", Tipo: " + Dominio.class.getName(), null);
		}
		return obj;
	}
	
	public Dominio insert(Dominio obj) {
		obj.setCodigoDominio(null);
		obj = dominioRepository.save(obj);
		return obj;
	}
	
	public Dominio update(Dominio obj) {
		Dominio newObj = find(obj.getCodigoDominio());
		updateData(newObj, obj);
		return dominioRepository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			dominioRepository.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há domínios relacionados");
		}
	}
	
	private void updateData(Dominio newObj, Dominio obj) {
		newObj.setNomeCodigoFisico(obj.getNomeCodigoFisico());
		newObj.setNomeColunaFisco(obj.getNomeColunaFisco());
		newObj.setNomeLogico(obj.getNomeLogico());
		newObj.setNomeTabelaFisico(obj.getNomeTabelaFisico());
	}
	
	public List<Dominio> findAll() {
		return dominioRepository.findAll();
	}
}
