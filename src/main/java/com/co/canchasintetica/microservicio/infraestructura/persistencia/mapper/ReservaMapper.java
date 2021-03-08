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
	
	
	public Reserva toDomain(ReservaEntity entity) {
		Reserva domain = new Reserva();
		domain.setId(entity.getId());
		domain.setNombreSolicita(entity.getNombre_solicita());
		domain.setFecha(entity.getFecha());
		domain.setHora(entity.getHora());
		domain.setValorAbono(entity.getValor_abono());
		domain.setValorTotal(entity.getValor_total());
		domain.setCanchaId(entity.getId_cancha().getId());
		domain.setEstado(entity.getEstado());
		return domain;
	}
	
	public com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity toReservaEntityResponse(ReservaEntity entity) {
		com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity domain 
		= new com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity();
		domain.setId(entity.getId());
		domain.setNombreSolicita(entity.getNombre_solicita());
		domain.setFecha(entity.getFecha());
		domain.setHora(entity.getHora());
		domain.setValorAbono(entity.getValor_abono());
		domain.setValorTotal(entity.getValor_total());
		domain.setId_cancha(entity.getId_cancha().getId());
		domain.setEstado(entity.getEstado());
		return domain;
	}

	public ReservaEntity toEntity(Reserva domain, CanchaEntity cancha) {
		
		ReservaEntity entity = new ReservaEntity();
		entity.setId(domain.getId());
		entity.setNombre_solicita(domain.getNombreSolicita());
		entity.setFecha(domain.getFecha());
		entity.setHora(domain.getHora());
		entity.setValor_abono(domain.getValorAbono());
		entity.setValor_total(domain.getValorTotal());
		entity.setId_cancha(cancha);
		entity.setEstado(domain.getEstado());
		return entity;
	}

}
