package com.co.canchasintetica.microservicio.aplicacion.handler.reserva;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.comun.handlercomun.UtilHandler;
import com.co.canchasintetica.microservicio.dominio.servicios.reserva.CancelarReservaService;

@Component
public class CancelarReservaHandler implements UtilHandler<Integer>{

	private final CancelarReservaService cancelarReservaService;

	public CancelarReservaHandler(CancelarReservaService cancelarReservaService) {
		this.cancelarReservaService = cancelarReservaService;
	}

	@Override
	public void  exec(Integer idReserva) {
		cancelarReservaService.cancelarReserva(idReserva);
	}
	
}
