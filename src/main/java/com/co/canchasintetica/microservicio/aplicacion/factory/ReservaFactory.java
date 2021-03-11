package com.co.canchasintetica.microservicio.aplicacion.factory;

import org.springframework.stereotype.Component;


import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity;


@Component
public class ReservaFactory {

	public Reserva create(ReservaEntity reservaEntity) {
		return new Reserva(reservaEntity.getId(), reservaEntity.getCanchaId(), reservaEntity.getNombreSolicita(), 
				reservaEntity.getFecha(), reservaEntity.getHora(), reservaEntity.getEstado(), reservaEntity.getValorAbono(), 
				reservaEntity.getValorTotal() );
	}
}
