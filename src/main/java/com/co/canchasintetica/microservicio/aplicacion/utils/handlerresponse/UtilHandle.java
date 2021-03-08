package com.co.canchasintetica.microservicio.aplicacion.utils.handlerresponse;

import org.springframework.transaction.annotation.Transactional;

public interface UtilHandle<C> {
	
	@Transactional
	void exec(C command);

}
