package com.matheushenrique.cursomc.resources.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StandarError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer Status;
	private String msg;
	private Long timeStamp;

}
