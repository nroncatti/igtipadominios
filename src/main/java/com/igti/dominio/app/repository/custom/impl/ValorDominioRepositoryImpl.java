package com.igti.dominio.app.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.query.NativeQuery;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import com.igti.dominio.app.domain.Generico;
import com.igti.dominio.app.dto.ValorDominioDto;
import com.igti.dominio.app.model.Dominio;


@Repository
public class ValorDominioRepositoryImpl {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Dominio> findByValoresPorCodigo(Integer codigo) throws Exception {

		Dominio reference = entityManager.find(Dominio.class, codigo);

		if (reference == null) {
			throw new Exception("Não Encontrado");

		} else {

			String selectGenericoRow = getSqlFindByCodigoDominio(reference);
			Query query = entityManager.createNativeQuery(selectGenericoRow);

			query.unwrap(NativeQuery.class)

					.addScalar("codigo").addScalar("nome");

			List<Dominio> retorno = new ArrayList<Dominio>();

			List<Object[]> list = query.getResultList();
			if (list != null) {
				for (Object[] objectArray : list) {
					Dominio dominio = new Dominio((Integer) objectArray[0], (String) objectArray[1]);
					retorno.add(dominio);

				}
			}

			return retorno;
		}
	}
		
	private String getSqlFindByCodigoDominio(Dominio reference) {
		final StringBuilder stringBuilder = new StringBuilder(200);
		
		stringBuilder.append("SELECT ");
		stringBuilder.append(reference.getCodigo());
		stringBuilder.append(" as codigoDominio, dominio.");
		stringBuilder.append(reference.getNome());
		
		return stringBuilder.toString();
	}
	

	public ValorDominioDto cadastrar (final Optional<Generico> generico, final ValorDominioDto body) {
		
		final Integer codigoValorDominio = getNewCodigoValorDominio(generico);
		
		String queryInsertValorDominio = getSqlInsertValorDominioRow(generico);
		
		Query query = entityManager.createNativeQuery(queryInsertValorDominio);
		
		query.setParameter("codigo", codigoValorDominio);
		query.setParameter("nome", body.getNome().trim());

		query.executeUpdate();
		
		return body;
	
	}
	
	public ValorDominioDto atualizarValorDominio(final ValorDominioDto body, final Integer codigoValorDominio)
	{
		Generico reference = entityManager.find(Generico.class, codigoValorDominio);
		
		if (reference == null) {
			String ex = "Valor de referencia nulo";
			throw new IllegalArgumentException(ex);
		}
		else {
			
			String queryUpdateValorDominio = getSqlUpdateDominioRow(reference, body);
			Query query = entityManager.createNativeQuery(queryUpdateValorDominio);
			
			query.setParameter("codigo", body.getCodigoDominio());
			query.setParameter("nome", body.getNome());
			query.executeUpdate();
		}
		
		return body;
	}
	
	private Integer getNewCodigoValorDominio(final Optional<Generico> generico) {
		
		StringBuilder sql = new StringBuilder(200);
		sql.append("SELECT MAX(");
		sql.append(generico.get().getNomeCodigoFisico());
		sql.append(") FROM ");
		sql.append(generico.get().getNomeTabelaFisico());
		
		Integer codigoValorDominio = 0;
		final Object result = entityManager.createNativeQuery(sql.toString()).getSingleResult();
		if(result != null) {
			codigoValorDominio = Integer.parseInt(result.toString());
		}
		
		codigoValorDominio = codigoValorDominio + 1;
		return codigoValorDominio;	
	}
	
	public String getSqlInsertValorDominioRow(final Optional<Generico> generico) {
		StringBuilder sql = new StringBuilder(200);
		
		sql.append("INSERT INTO ");
		sql.append(generico.get().getNomeTabelaFisico());
		sql.append(" VALUES (");
		sql.append(":codigo");
		sql.append(", ");
		sql.append(":nome )");
		
		return sql.toString();
		}
	
	public ValorDominioDto findByID(final Generico reference, final Integer codigoValorDominio) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append(reference.getCodigoDominio());
		sql.append(" as codigoDominio ");
		sql.append(" FROM ");
		sql.append(reference.getNomeTabelaFisico());
		sql.append(" dominio WHERE dominio. ");
		sql.append(reference.getNomeCodigoFisico());
		sql.append(" = :codigo ");
		
		ValorDominioDto result = null;
		
		Query query = entityManager.createNativeQuery(sql.toString());
		query.setParameter("codigoDominio", codigoValorDominio);

		query.setParameter("codigo", result.getCodigoDominio());
		query.setParameter("nome", result.getNome());
		
		List<ValorDominioDto> retorno = query.getResultList();
		if(!retorno.isEmpty()) {
			result = retorno.get(0);
		}
		
		return result;
		
	}
	
	public String getSqlUpdateDominioRow(final Generico generico, final ValorDominioDto body) {
		StringBuilder sql = new StringBuilder(200);
	 	
		sql.append("UPDATE ");
		sql.append(generico.getNomeTabelaFisico());
		sql.append(" SET ");
		sql.append(generico.getNomeColunaFisco());
		sql.append(" = ");
		sql.append(":nome ");
		sql.append(" WHERE ");
		sql.append(generico.getNomeCodigoFisico());
		sql.append(" = ");
		sql.append(":codigo");
		
		return sql.toString();
	}

}
