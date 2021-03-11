package com.co.canchasintetica.microservicio.aplicacion.factory;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity;


@Component
public class CanchaFactory {

	public Cancha create(CanchaEntity canchaEntity) {
		return new Cancha(canchaEntity.getId(), canchaEntity.getNombre(), 
				canchaEntity.getDescripcion(), canchaEntity.getEstado(), canchaEntity.getValorDia(), 
				canchaEntity.getValorNoche());
	}
}
