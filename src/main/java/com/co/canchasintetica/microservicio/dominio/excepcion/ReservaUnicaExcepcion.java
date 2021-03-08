package com.co.canchasintetica.microservicio.dominio.excepcion;

public class ReservaUnicaExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ReservaUnicaExcepcion(String msg) {
		super(msg);
	}

}
