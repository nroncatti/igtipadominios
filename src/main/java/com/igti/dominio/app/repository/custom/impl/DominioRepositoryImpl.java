package com.igti.dominio.app.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.hibernate.type.IntegerType;

import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.igti.dominio.app.custom.IDominioRepositoryCustom;
import com.igti.dominio.app.domain.Generico;
import com.igti.dominio.app.model.Dominio;


@Repository
public class DominioRepositoryImpl implements IDominioRepositoryCustom{
	
	@PersistenceContext
	private EntityManager entityManager;
	

	
	public List<Dominio> findByValoresPorCodigo(Integer codigoDominio) throws Exception{
		
		Generico reference = entityManager.find(Generico.class, codigoDominio);
		
		if (reference == null) {
			throw new Exception("Não Encontrado");
			
		}else {
				
				String selectGenericoRow = getSqlFindByCodigoDominio(reference);
				Query query = entityManager.createNativeQuery(selectGenericoRow);
				
				
				
				query.unwrap(NativeQuery.class)
				//.addScalar("codigoDominio", IntegerType.INSTANCE)
				.addScalar("codigo")
				.addScalar("nome");
			
				
				//.setResultTransformer(Transformers.aliasToBean(Dominio.class));
				
				List<Dominio> retorno = new ArrayList<Dominio>();
				
				List<Object[]> list = query.getResultList();
				if(list != null) {
					for(Object[] objectArray : list ) {
						Dominio dominio = new Dominio((Integer)objectArray[0], (String)objectArray[1]);
						retorno.add(dominio);
					
					
					}
				}

	
				return retorno;
			}		
	}
	
	private String getSqlFindByCodigoDominio(Generico reference) {
		final StringBuilder stringBuilder = new StringBuilder(200);
		
		stringBuilder.append("SELECT ");
		stringBuilder.append(reference.getCodigoDominio());
		stringBuilder.append(" as codigoDominio, generico.");
		stringBuilder.append(reference.getNomeCodigoFisico());
		stringBuilder.append(" as codigo, generico.");
		stringBuilder.append(reference.getNomeColunaFisco());
		stringBuilder.append(" as nome ");
		stringBuilder.append("FROM ");
		stringBuilder.append(reference.getNomeTabelaFisico());
		stringBuilder.append(" generico");
		//stringBuilder.append(" WHERE generico.");
		//stringBuilder.append(reference.getCodigoDominio());
		//stringBuilder.append("= 1");
		//stringBuilder.append("= codigoDominio");
		//stringBuilder.append(" order by nomeLogico asc");
		
		return stringBuilder.toString();
	}

}
