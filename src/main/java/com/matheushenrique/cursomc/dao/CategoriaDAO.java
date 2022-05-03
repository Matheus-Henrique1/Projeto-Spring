package com.matheushenrique.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheushenrique.cursomc.domain.Categoria;

@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Integer> {

	
	
}
