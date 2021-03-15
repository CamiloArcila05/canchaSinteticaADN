package com.co.canchasintetica.microservicio.dominio.servicios.reserva;



import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.excepcion.ValidarFinalizarReservaExcepcion;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;

@Service
public class FinalizarReservaService {
	
	private static final String VALOR_FINALIZAR_RESERVA = "El valor ingresado es inferior al valor que resta por pago";
	private static final String ESTADO_FINALIZADA = "FINALIZADA";

	
	private ReservaRepository reservaRepository;
	private CanchaRepository canchaRepository;

		
		public FinalizarReservaService(ReservaRepository reservaRepository, CanchaRepository canchaRepository) {
			this.reservaRepository = reservaRepository;
			this.canchaRepository = canchaRepository;
		}
	
	public void finalizarReserva(int reservaId, int valorIngresado) {
		Reserva reservaFinalizar = reservaRepository.getReservaById(reservaId);
		Cancha canchaSeleccionada = canchaRepository.getCanchaById(reservaFinalizar.getCanchaId());
		
		validarValorRestanteReserva(reservaFinalizar, canchaSeleccionada, valorIngresado);
		
		reservaFinalizar.setEstado(ESTADO_FINALIZADA);
		reservaFinalizar.setValorTotal(valorIngresado + reservaFinalizar.getValorAbono());
		reservaRepository.actualizarReserva(reservaFinalizar);
	}

	
	public static void validarValorRestanteReserva(Reserva reservaFinalizar,
			Cancha canchaSeleccionada, int valorIngresado) {
		
		int valorCancha = reservaFinalizar.obtenerValorCancha(canchaSeleccionada);
	    int valorRestante = valorCancha - reservaFinalizar.getValorAbono();	
		if (valorRestante > valorIngresado) {
			throw new ValidarFinalizarReservaExcepcion(VALOR_FINALIZAR_RESERVA);
		}
	}

}
