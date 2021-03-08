package com.co.canchasintetica.microservicio.aplicacion.utils.handlerresponse;

import org.springframework.transaction.annotation.Transactional;

public interface UtilHandleResponse<C , R> {
	
	@Transactional
	R exec(C command);

}
