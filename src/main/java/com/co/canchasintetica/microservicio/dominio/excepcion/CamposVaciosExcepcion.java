package com.co.canchasintetica.microservicio.dominio.excepcion;

public class CamposVaciosExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CamposVaciosExcepcion(String msg) {
		super(msg);
	}

}