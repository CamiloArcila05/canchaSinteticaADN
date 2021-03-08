package com.co.canchasintetica.microservicio.aplicacion.handler.reserva;

import java.util.List;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.dominio.servicios.reserva.ListarReservaService;

@Component
public class ListarReservaHandler {

	private final ListarReservaService listarReservaService;

	public ListarReservaHandler(ListarReservaService listarReservaService) {
		this.listarReservaService = listarReservaService;
	}

	public List<ReservaEntity> exec() {
		return listarReservaService.listarReservas();
	}
	
}
