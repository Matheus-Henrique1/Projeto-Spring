package com.matheushenrique.cursomc.domain;

import com.matheushenrique.cursomc.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoComCartao extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas ) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
		
	}

}
