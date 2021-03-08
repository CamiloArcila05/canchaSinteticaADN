package com.co.canchasintetica.microservicio.infraestructura.controladores;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.CancelarReservaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.CrearReservaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.FinalizarReservaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ListarReservaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity;
import com.co.canchasintetica.microservicio.aplicacion.utils.UtilResponse;

@RestController
@RequestMapping("/reserva")
@Api(tags = { "Controlador para la gestion de las reservas" })
public class ReservaController {
	
	private CrearReservaHandler crearReservaHandler;
	private ListarReservaHandler listarReservaHandler;
	private CancelarReservaHandler cancelarReservaHandler;
	private FinalizarReservaHandler finalizarReservaHandler;


	@Autowired
	public ReservaController(CrearReservaHandler crearReservaHandler, 
			ListarReservaHandler listarReservaHandler, CancelarReservaHandler cancelarReservaHandler, FinalizarReservaHandler finalizarReservaHandler) {
		this.crearReservaHandler = crearReservaHandler;
		this.listarReservaHandler = listarReservaHandler;
		this.cancelarReservaHandler = cancelarReservaHandler;
		this.finalizarReservaHandler = finalizarReservaHandler;
	}
	
	
	@ApiOperation("Registrar Reserva")
	@PostMapping("/registrar-reserva")
	public UtilResponse<String> post(@RequestBody ReservaEntity entity, HttpServletResponse response) {
		UtilResponse<String> jsonRtaHandler;
		try {
			jsonRtaHandler = crearReservaHandler.exec(entity);
		} catch (Exception e) {
			jsonRtaHandler = new UtilResponse<>(e.getMessage());
		}
		return jsonRtaHandler;
    }
	
	@ApiOperation("Cancelar reserva")
	@PutMapping("/cancelar-reserva")
	public UtilResponse<String> cancelar(@RequestParam int id, HttpServletResponse response) {
		UtilResponse<String> jsonRtaHandler;
		try {
			jsonRtaHandler = cancelarReservaHandler.exec(id);
		} catch (Exception e) {
			jsonRtaHandler = new UtilResponse<>(e.getMessage());
		}
		return jsonRtaHandler;
    }
	
	@ApiOperation("Finalizar reserva")
	@PutMapping("/finalizar-reserva")
	public UtilResponse<String> finalizar(@RequestParam int id, @RequestParam int valor ,HttpServletResponse response) {
		UtilResponse<String> jsonRtaHandler;
		try {
			jsonRtaHandler = finalizarReservaHandler.exec(id, valor);
		} catch (Exception e) {
			jsonRtaHandler = new UtilResponse<>(e.getMessage());
		}
		return jsonRtaHandler;
    }
	
	@ApiOperation("Listar reservas")
	@GetMapping("/listar-reservas")
	public List<ReservaEntity> get() {
		return this.listarReservaHandler.exec();
	}
	
}
