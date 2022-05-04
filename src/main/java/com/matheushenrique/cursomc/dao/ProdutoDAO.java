package com.matheushenrique.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheushenrique.cursomc.domain.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

}
