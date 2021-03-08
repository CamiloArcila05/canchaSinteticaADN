package com.co.canchasintetica.microservicio.infraestructura.controladores;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.ActualizarCanchaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity;
import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CrearCanchaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.ListarCanchasHandler;
import com.co.canchasintetica.microservicio.aplicacion.utils.UtilResponse;

@RestController
@RequestMapping("/cancha")
@Api(tags = { "Controlador para la gestion de las canchas" })
public class CanchaController {
	
	private CrearCanchaHandler crearCanchaHandler;
	private ListarCanchasHandler listarCanchasHandler;
	private ActualizarCanchaHandler actualizarCanchaHandler;

	@Autowired
	public CanchaController(CrearCanchaHandler crearCanchaHandler, ListarCanchasHandler listarCanchasHandler,
			ActualizarCanchaHandler actualizarCanchaHandler) {
		this.crearCanchaHandler = crearCanchaHandler;
		this.listarCanchasHandler = listarCanchasHandler;
		this.actualizarCanchaHandler = actualizarCanchaHandler;
	}
	
	
	@ApiOperation("Registrar Cancha")
	@PostMapping("/registrar-cancha")
	public UtilResponse<String> post(@RequestBody CanchaEntity entity, HttpServletResponse response) {
		UtilResponse<String> jsonRtaHandler;
		try {
			jsonRtaHandler = crearCanchaHandler.exec(entity);
		} catch (Exception e) {
			jsonRtaHandler = new UtilResponse<>(e.getMessage());
		}
		return jsonRtaHandler;
    }
	
	@ApiOperation("Actualizar Cancha")
	@PutMapping("/actualizar-cancha")
	public UtilResponse<String> put(@RequestBody CanchaEntity entity, HttpServletResponse response) {
		UtilResponse<String> jsonRtaHandler;
		try {
			jsonRtaHandler = actualizarCanchaHandler.exec(entity);
		} catch (Exception e) {
			jsonRtaHandler = new UtilResponse<>(e.getMessage());
		}
		return jsonRtaHandler;
    }
	
	
	@ApiOperation("Listar canchas")
	@GetMapping("/listar-canchas")
	public List<CanchaEntity> get() {
		return this.listarCanchasHandler.exec();
	}
}
