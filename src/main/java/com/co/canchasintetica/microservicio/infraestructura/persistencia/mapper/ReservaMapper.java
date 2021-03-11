package com.co.canchasintetica.microservicio.infraestructura.persistencia.mapper;

import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.CanchaEntity;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.ReservaEntity;


public class ReservaMapper {
	
	
	private ReservaMapper() {
	}

	private static final ReservaMapper INSTANCE = new ReservaMapper();

	public static ReservaMapper getInstance() {
		return INSTANCE;
	}
	
	
	public Reserva toDomain(ReservaEntity reservaEntity) {
		Reserva reservaDomain = new Reserva(
				reservaEntity.getId(),
				reservaEntity.getId_cancha().getId(),
				reservaEntity.getNombre_solicita(),
				reservaEntity.getFecha(),
				reservaEntity.getHora(),
				reservaEntity.getEstado(),
				reservaEntity.getValor_abono(),
				reservaEntity.getValor_total());
		return reservaDomain;
	}
	
	public com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity toReservaEntityResponse(ReservaEntity reservEntity) {
		com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity reservaEntityInfraestructura 
		= new com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity(
				reservEntity.getId(),
				reservEntity.getId_cancha().getId(),
				reservEntity.getNombre_solicita(),
				reservEntity.getFecha(),
				reservEntity.getHora(),
				reservEntity.getEstado(),
				reservEntity.getValor_abono(),
				reservEntity.getValor_total());
		return reservaEntityInfraestructura;
	}

	public ReservaEntity toEntity(Reserva reservaDoamin, CanchaEntity canchaEntity) {
		ReservaEntity reservaEntity = new ReservaEntity();
		reservaEntity.setId(reservaDoamin.getId());
		reservaEntity.setNombre_solicita(reservaDoamin.getNombreSolicita());
		reservaEntity.setFecha(reservaDoamin.getFecha());
		reservaEntity.setHora(reservaDoamin.getHora());
		reservaEntity.setValor_abono(reservaDoamin.getValorAbono());
		reservaEntity.setValor_total(reservaDoamin.getValorTotal());
		reservaEntity.setId_cancha(canchaEntity);
		reservaEntity.setEstado(reservaDoamin.getEstado());
		return reservaEntity;
	}

}
