package com.co.canchasintetica.microservicio.dominio.excepcion;

public class ValidarFinalizarReservaExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidarFinalizarReservaExcepcion(String msg) {
		super(msg);
	}

}
