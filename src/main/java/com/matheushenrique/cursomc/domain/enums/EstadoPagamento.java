package com.matheushenrique.cursomc.domain.enums;

import lombok.Getter;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private Integer codigo;
	private String descricao;

	private EstadoPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static EstadoPagamento toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (EstadoPagamento item : EstadoPagamento.values()) {
			if (codigo.equals(item.getCodigo())) {
				return item;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}

}
