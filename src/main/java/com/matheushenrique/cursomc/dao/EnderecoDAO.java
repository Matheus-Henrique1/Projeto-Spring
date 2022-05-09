package com.matheushenrique.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.matheushenrique.cursomc.domain.Endereco;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco, Integer> {

}
