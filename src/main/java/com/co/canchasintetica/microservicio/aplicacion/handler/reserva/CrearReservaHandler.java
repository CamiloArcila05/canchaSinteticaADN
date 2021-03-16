package com.co.canchasintetica.microservicio.aplicacion.handler.reserva;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.comun.ComandoRespuesta;
import com.co.canchasintetica.microservicio.aplicacion.comun.handlercomun.UtilHandlerResponse;
import com.co.canchasintetica.microservicio.aplicacion.factory.ReservaFactory;
import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.servicios.reserva.CrearReservaService;

@Component
public class CrearReservaHandler implements UtilHandlerResponse<ReservaEntity, ComandoRespuesta<Integer>>{

	private final ReservaFactory reservaFactory;
	private final CrearReservaService crearReservaService;

	public CrearReservaHandler(ReservaFactory reservaFactory, CrearReservaService crearReservaService) {
		this.reservaFactory = reservaFactory;
		this.crearReservaService = crearReservaService;
	}

	public ComandoRespuesta<Integer> exec(ReservaEntity reservaEntity) {
		Reserva reserva = this.reservaFactory.create(reservaEntity);
		return new ComandoRespuesta<>(crearReservaService.crearReserva(reserva).getId());
	}
	
}
