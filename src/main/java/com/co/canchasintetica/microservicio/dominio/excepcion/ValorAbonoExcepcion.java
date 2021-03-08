package com.co.canchasintetica.microservicio.dominio.excepcion;

public class ValorAbonoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValorAbonoExcepcion(String msg) {
		super(msg);
	}

}
