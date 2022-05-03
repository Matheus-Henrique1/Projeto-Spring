package com.matheushenrique.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheushenrique.cursomc.dao.CategoriaDAO;
import com.matheushenrique.cursomc.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = categoriaDAO.findById(id);
		 return obj.orElse(null);
	}
	
}
