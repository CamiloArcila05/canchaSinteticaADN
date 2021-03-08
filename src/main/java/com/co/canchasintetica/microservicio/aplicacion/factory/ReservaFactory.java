package com.co.canchasintetica.microservicio.aplicacion.factory;

import org.springframework.stereotype.Component;


import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity;


@Component
public class ReservaFactory {

	public Reserva create(ReservaEntity entity) {
		return new Reserva(entity.getId(), entity.getId_cancha(), entity.getNombreSolicita(), 
				entity.getFecha(), entity.getHora(), entity.getEstado(), entity.getValorAbono(), entity.getValorTotal() );
	}
}
