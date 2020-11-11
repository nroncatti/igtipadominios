package com.igti.dominio.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.igti.dominio.app.custom.IDominioRepositoryCustom;
import com.igti.dominio.app.domain.Generico;
import com.igti.dominio.app.domain.TipoSeguro;
import com.igti.dominio.app.model.Dominio;


public interface DominioRepository extends JpaRepository<Generico, Integer>, IDominioRepositoryCustom{
	
 
}
