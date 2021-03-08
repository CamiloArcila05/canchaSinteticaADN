package com.co.canchasintetica.microservicio.aplicacion.handler.cancha;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.factory.CanchaFactory;
import com.co.canchasintetica.microservicio.aplicacion.utils.UtilResponse;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.servicios.cancha.CrearCanchaService;

@Component
public class CrearCanchaHandler {
	
	private final CanchaFactory factory;
	private final CrearCanchaService crearCanchaService;

	public CrearCanchaHandler(CanchaFactory factory, CrearCanchaService crearCanchaService) {
		this.factory = factory;
		this.crearCanchaService = crearCanchaService;
	}

	public UtilResponse<String> exec(CanchaEntity entity) {
		Cancha cancha = this.factory.create(entity);
		return new UtilResponse<>(crearCanchaService.craerCancha(cancha));
	}

}
