package com.igti.dominio.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.igti.dominio.app.custom.IValorDominioRepositoryCustom;
import com.igti.dominio.app.domain.ValorDominio;


public interface ValorDominioRepository extends JpaRepository<ValorDominio, Integer> {
	
 
}
