package com.co.canchasintetica.microservicio.aplicacion.handler.reserva;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.factory.ReservaFactory;
import com.co.canchasintetica.microservicio.aplicacion.utils.UtilResponse;
import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.servicios.reserva.CrearReservaService;

@Component
public class CrearReservaHandler {

	private final ReservaFactory factory;
	private final CrearReservaService crearReservaService;

	public CrearReservaHandler(ReservaFactory factory, CrearReservaService crearReservaService) {
		this.factory = factory;
		this.crearReservaService = crearReservaService;
	}

	public UtilResponse<String> exec(ReservaEntity entity) {
		Reserva reserva = this.factory.create(entity);
		return new UtilResponse<>(crearReservaService.crearReserva(reserva));
	}
	
}
