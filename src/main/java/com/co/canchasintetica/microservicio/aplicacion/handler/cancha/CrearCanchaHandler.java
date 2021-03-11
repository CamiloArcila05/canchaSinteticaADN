package com.co.canchasintetica.microservicio.aplicacion.handler.cancha;

import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.aplicacion.comun.ComandoRespuesta;
import com.co.canchasintetica.microservicio.aplicacion.comun.handlercomun.UtilHandlerResponse;
import com.co.canchasintetica.microservicio.aplicacion.factory.CanchaFactory;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.servicios.cancha.CrearCanchaService;

@Component
public class CrearCanchaHandler implements UtilHandlerResponse<CanchaEntity, ComandoRespuesta<Integer>>{
	
	private final CanchaFactory canchaFactory;
	private final CrearCanchaService crearCanchaService;

	public CrearCanchaHandler(CanchaFactory canchaFactory, CrearCanchaService crearCanchaService) {
		this.canchaFactory = canchaFactory;
		this.crearCanchaService = crearCanchaService;
	}

	public ComandoRespuesta<Integer> exec(CanchaEntity canchaEntity) {
		Cancha cancha = this.canchaFactory.create(canchaEntity);
		return new ComandoRespuesta<>(crearCanchaService.craerCancha(cancha).getId());
	}

}
