package com.matheushenrique.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.matheushenrique.cursomc.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento ) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	
}
