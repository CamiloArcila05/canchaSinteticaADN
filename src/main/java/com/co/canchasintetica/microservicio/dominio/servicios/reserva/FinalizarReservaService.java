package com.co.canchasintetica.microservicio.dominio.servicios.reserva;

import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.entidades.ValidadorExcepcionesUtil;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;

@Service
public class FinalizarReservaService {
	
	private ReservaRepository reservaRepository;
	private CanchaRepository canchaRepository;

		
		public FinalizarReservaService(ReservaRepository reservaRepository, CanchaRepository canchaRepository) {
			this.reservaRepository = reservaRepository;
			this.canchaRepository = canchaRepository;
		}
	
	public String finalizarReserva(int id, int valor) {
		Reserva reserva = reservaRepository.getReservaById(id);
		Cancha cancha = canchaRepository.getCanchaById(reserva.getCanchaId());
		
		ValidadorExcepcionesUtil.validarValorRestanteReserva(reserva, cancha, valor);
		
		reserva.setEstado("FINALIZADA");
		reserva.setValorTotal(valor);
		reservaRepository.actualizarReserva(reserva);
		return "La reserva ha sido finalizada";
	}


}
