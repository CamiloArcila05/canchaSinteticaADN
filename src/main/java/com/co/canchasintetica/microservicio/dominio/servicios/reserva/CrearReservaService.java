package com.co.canchasintetica.microservicio.dominio.servicios.reserva;

import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.entidades.ValidadorExcepcionesUtil;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;

@Service
public class CrearReservaService {
	
private ReservaRepository reservaRepository;
private CanchaRepository canchaRepository;

	
	public CrearReservaService(ReservaRepository reservaRepository, CanchaRepository canchaRepository) {
		this.reservaRepository = reservaRepository;
		this.canchaRepository = canchaRepository;
	}
	
	public String crearReserva(Reserva reserva) {
	
		Cancha cancha = canchaRepository.getCanchaById(reserva.getCanchaId());
		Reserva reservaAux = reservaRepository.getReservaByCanchaIdAndFechaAndHoraAndEstado(
				reserva.getCanchaId(), reserva.getFecha(), reserva.getHora(), reserva.getEstado());
		ValidadorExcepcionesUtil.validarUnicaReserva(reservaAux);
		ValidadorExcepcionesUtil.validarValorAbono(reserva, cancha);
	
		return "La reserva del señor(a): " 
		+ reservaRepository.crearReserva(reserva).getNombreSolicita() 
				+ " ha sido creada." ;
	}

}
