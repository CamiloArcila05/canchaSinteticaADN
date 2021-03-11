package com.co.canchasintetica.microservicio.aplicacion.handler.cancha;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.comun.handlercomun.UtilHandlerResponse;
import com.co.canchasintetica.microservicio.aplicacion.comun.ComandoRespuesta;
import com.co.canchasintetica.microservicio.aplicacion.factory.CanchaFactory;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.servicios.cancha.ActualizarCanchaService;

@Component
public class ActualizarCanchaHandler implements UtilHandlerResponse<CanchaEntity, ComandoRespuesta<Integer>>{
	
	private final CanchaFactory canchaFactory;
	private final ActualizarCanchaService actualizarCanchaService;

	public ActualizarCanchaHandler(CanchaFactory canchaFactory, ActualizarCanchaService actualizarCanchaService) {
		this.canchaFactory = canchaFactory;
		this.actualizarCanchaService = actualizarCanchaService;
	}

	public ComandoRespuesta<Integer> exec(CanchaEntity canchaEntity) {
		Cancha cancha = this.canchaFactory.create(canchaEntity);
		actualizarCanchaService.actualizarCancha(cancha);
		return new ComandoRespuesta<>(cancha.getId());
	}

}
