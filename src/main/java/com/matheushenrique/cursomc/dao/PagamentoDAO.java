package com.matheushenrique.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheushenrique.cursomc.domain.Pagamento;

@Repository
public interface PagamentoDAO extends JpaRepository<Pagamento, Integer> {

}
