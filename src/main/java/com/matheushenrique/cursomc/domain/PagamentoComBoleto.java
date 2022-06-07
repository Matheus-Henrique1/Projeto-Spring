package com.matheushenrique.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.matheushenrique.cursomc.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento ) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	
}
