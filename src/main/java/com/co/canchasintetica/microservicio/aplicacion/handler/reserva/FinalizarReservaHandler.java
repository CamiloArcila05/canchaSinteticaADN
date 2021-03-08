package com.co.canchasintetica.microservicio.aplicacion.handler.reserva;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.utils.UtilResponse;
import com.co.canchasintetica.microservicio.dominio.servicios.reserva.FinalizarReservaService;

@Component
public class FinalizarReservaHandler {

	private final FinalizarReservaService finalizarReservaService;

	public FinalizarReservaHandler(FinalizarReservaService finalizarReservaService) {
		this.finalizarReservaService = finalizarReservaService;
	}

	public UtilResponse<String> exec(int id, int valor) {
		return new UtilResponse<>(finalizarReservaService.finalizarReserva(id, valor));
	}
	
}
