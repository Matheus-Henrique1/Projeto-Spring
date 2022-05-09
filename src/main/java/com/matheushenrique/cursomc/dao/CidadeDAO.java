package com.matheushenrique.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.matheushenrique.cursomc.domain.Cidade;

@Repository
public interface CidadeDAO extends JpaRepository<Cidade, Integer> {

}
