package com.co.canchasintetica.microservicio.aplicacion.handler.cancha;

import java.util.List;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.dominio.servicios.cancha.ListarCanchasService;

@Component
public class ListarCanchasHandler {
	
	private final ListarCanchasService listarCanchasService;

	public ListarCanchasHandler(ListarCanchasService listarCanchasService) {
		this.listarCanchasService = listarCanchasService;
	}

	public List<CanchaEntity> exec() {
		return listarCanchasService.listasCanchas();
	}

}
