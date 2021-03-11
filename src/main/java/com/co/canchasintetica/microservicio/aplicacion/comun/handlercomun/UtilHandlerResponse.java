package com.co.canchasintetica.microservicio.aplicacion.comun.handlercomun;

import org.springframework.transaction.annotation.Transactional;

public interface UtilHandlerResponse<C, R> {

	@Transactional
	R exec(C command);
}