package com.matheushenrique.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.matheushenrique.cursomc.domain.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer>{

}
