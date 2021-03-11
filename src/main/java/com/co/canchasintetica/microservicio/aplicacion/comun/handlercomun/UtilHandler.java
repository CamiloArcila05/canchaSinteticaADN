package com.co.canchasintetica.microservicio.aplicacion.comun.handlercomun;

import org.springframework.transaction.annotation.Transactional;

public interface UtilHandler<C> {

	@Transactional
	void exec(C command);
}