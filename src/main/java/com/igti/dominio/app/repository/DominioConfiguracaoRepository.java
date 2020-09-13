package com.igti.dominio.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igti.dominio.app.api.model.DominioType;
import com.igti.dominio.app.api.model.ValorDominioType;
import com.igti.dominio.app.domain.DominioConfiguracao;

@Repository
public interface DominioConfiguracaoRepository extends JpaRepository<DominioType, Integer> {

}
