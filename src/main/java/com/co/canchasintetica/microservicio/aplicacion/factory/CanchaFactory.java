package com.co.canchasintetica.microservicio.aplicacion.factory;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity;


@Component
public class CanchaFactory {

	public Cancha create(CanchaEntity entity) {
		return new Cancha(entity.getId(), entity.getNombre(), 
				entity.getDescripcion(), entity.getEstado(), entity.getValorDia(), entity.getValorNoche());
	}
}
