package com.igti.dominio.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igti.dominio.app.domain.Dominio;

@Repository
public interface DominioRepository extends JpaRepository<Dominio, Integer>{

}
