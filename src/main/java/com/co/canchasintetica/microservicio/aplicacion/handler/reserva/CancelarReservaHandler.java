package com.co.canchasintetica.microservicio.aplicacion.handler.reserva;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.utils.UtilResponse;
import com.co.canchasintetica.microservicio.dominio.servicios.reserva.CancelarReservaService;

@Component
public class CancelarReservaHandler {

	private final CancelarReservaService cancelarReservaService;

	public CancelarReservaHandler(CancelarReservaService cancelarReservaService) {
		this.cancelarReservaService = cancelarReservaService;
	}

	public UtilResponse<String> exec(int id) {
		return new UtilResponse<>(cancelarReservaService.cancelarReserva(id));
	}
	
}
