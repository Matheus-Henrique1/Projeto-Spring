package com.matheushenrique.cursomc.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheushenrique.cursomc.dao.PedidoDAO;
import com.matheushenrique.cursomc.domain.Cliente;
import com.matheushenrique.cursomc.domain.Pedido;
import com.matheushenrique.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoDAO pedidoDAO;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = pedidoDAO.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()));

	}
}