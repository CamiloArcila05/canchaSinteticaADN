package com.co.canchasintetica.microservicio.dominio.servicios.reserva;



import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.excepcion.ReservaUnicaExcepcion;
import com.co.canchasintetica.microservicio.dominio.excepcion.ValidarFinalizarReservaExcepcion;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;

@Service
public class CrearReservaService {
	
	private static final String RESERVA_UNICA = "Ya existe una reserva en esa fecha y en esa hora para esta cancha";
	private static final String VALOR_ABONO_MINIMO = "El valor del abono debe superar el 10% del valor de alquier de la cancha";
	private static final float PORCENTAJE_MINIMO_ABONO = 0.10f;
	
private ReservaRepository reservaRepository;
private CanchaRepository canchaRepository;

	
	public CrearReservaService(ReservaRepository reservaRepository, CanchaRepository canchaRepository) {
		this.reservaRepository = reservaRepository;
		this.canchaRepository = canchaRepository;
	}
	
	public Reserva crearReserva(Reserva reserva) {
	
		Cancha cancha = canchaRepository.getCanchaById(reserva.getCanchaId());
		Reserva reservaAnteriror = reservaRepository.getReservaByCanchaIdAndFechaAndHoraAndEstado(
				reserva.getCanchaId(), reserva.getFecha(), reserva.getHora(), reserva.getEstado());
		
		
		validarUnicaReserva(reservaAnteriror);
		validarValorAbono(reserva, cancha);
	
		return reservaRepository.crearReserva(reserva);
	}
	
	
	public static void validarUnicaReserva(Reserva reservaAnteriror) {
		if (reservaAnteriror != null) {
			throw new ReservaUnicaExcepcion(RESERVA_UNICA);
		}
	}
	
	public static void validarValorAbono(Reserva reserva, Cancha cancha) {
		int porcentajeAbonoMinimo = Math.round(reserva.obtenerValorCancha(cancha) * PORCENTAJE_MINIMO_ABONO);
		if (reserva.getValorAbono() < porcentajeAbonoMinimo) {
			throw new ValidarFinalizarReservaExcepcion(VALOR_ABONO_MINIMO);
		}
	}
	
}
