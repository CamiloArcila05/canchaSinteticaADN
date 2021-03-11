package com.co.canchasintetica.microservicio.aplicacion.handler.reserva;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.comun.ComandoRespuesta;
import com.co.canchasintetica.microservicio.dominio.servicios.reserva.FinalizarReservaService;

@Component
public class FinalizarReservaHandler {

	private final FinalizarReservaService finalizarReservaService;

	public FinalizarReservaHandler(FinalizarReservaService finalizarReservaService) {
		this.finalizarReservaService = finalizarReservaService;
	}

	public ComandoRespuesta<Integer> exec(int idReserva, int valorAPagar) {
		finalizarReservaService.finalizarReserva(idReserva, valorAPagar);
		return new ComandoRespuesta<>(valorAPagar);
	}
	
}
