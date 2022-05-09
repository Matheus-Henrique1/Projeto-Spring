package com.matheushenrique.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheushenrique.cursomc.dao.ClienteDAO;
import com.matheushenrique.cursomc.domain.Cliente;
import com.matheushenrique.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteDAO.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
