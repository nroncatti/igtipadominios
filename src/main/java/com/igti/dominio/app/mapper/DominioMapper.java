package com.igti.dominio.app.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Configuration;

import com.igti.dominio.app.api.model.DominioType;
import com.igti.dominio.app.domain.DominioConfiguracao;

@Configuration
public class DominioMapper {
	
	public ModelMapper modelMapper() {
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		final PropertyMap<DominioConfiguracao, DominioType> dominioToDominioType = new PropertyMap<DominioConfiguracao, DominioType>() {
			
			@Override
			protected void configure() {
				map().setCodigoDominio(source.getCodigo());
				map().setNomeFisicoDominioConfiguracao(source.getNomeTabelaFisico());
				map().setNomeLogicoConfiguracao(source.getNomeLogico());
				map().setNomeFisicoTabelConfiguracao(source.getNomeTabelaFisico());
				
			}
		};
		modelMapper.addMappings(dominioToDominioType);
		return modelMapper;
	}

}
