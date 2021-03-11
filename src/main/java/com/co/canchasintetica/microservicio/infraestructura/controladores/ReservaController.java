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

import com.co.canchasintetica.microservicio.aplicacion.comun.ComandoRespuesta;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.CancelarReservaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.CrearReservaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.FinalizarReservaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ListarReservaHandler;
import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity;

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
	public ComandoRespuesta<Integer> crearReserva(@RequestBody ReservaEntity reservaEntity, HttpServletResponse response) {
		return crearReservaHandler.exec(reservaEntity);
    }
	
	@ApiOperation("Cancelar reserva")
	@PutMapping("/cancelar-reserva")
	public void cancelarReserva(@RequestParam int reservaId, HttpServletResponse response) {
	 cancelarReservaHandler.exec(reservaId);
    }
	
	@ApiOperation("Finalizar reserva")
	@PutMapping("/finalizar-reserva")
	public  ComandoRespuesta<Integer> finalizarReserva(@RequestParam int reservaId, @RequestParam int valorIngresado ,HttpServletResponse response) {
		return finalizarReservaHandler.exec(reservaId, valorIngresado);
    }
	
	@ApiOperation("Listar reservas")
	@GetMapping("/listar-reservas")
	public List<ReservaEntity> get() {
		return this.listarReservaHandler.exec();
	}
	
}
