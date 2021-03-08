package com.co.canchasintetica.microservicio.aplicacion.handler.cancha;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.factory.CanchaFactory;
import com.co.canchasintetica.microservicio.aplicacion.utils.UtilResponse;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.servicios.cancha.ActualizarCanchaService;

@Component
public class ActualizarCanchaHandler {
	
	private final CanchaFactory factory;
	private final ActualizarCanchaService actualizarCanchaService;

	public ActualizarCanchaHandler(CanchaFactory factory, ActualizarCanchaService actualizarCanchaService) {
		this.factory = factory;
		this.actualizarCanchaService = actualizarCanchaService;
	}

	public UtilResponse<String> exec(CanchaEntity entity) {
		Cancha cancha = this.factory.create(entity);
		actualizarCanchaService.actualizarCancha(cancha);
		return new UtilResponse<>("La informacion de la cancha ha sido actualizada");
	}

}
