package com.co.canchasintetica.microservicio.infraestructura.persistencia.mapper;

import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.CanchaEntity;


public class CanchaMapper {
	
	private CanchaMapper() {
	}

	private static final CanchaMapper INSTANCE = new CanchaMapper();

	public static CanchaMapper getInstance() {
		return INSTANCE;
	}
	
	
	public Cancha toDomain(CanchaEntity entity) {
		Cancha domain = new Cancha();
		domain.setId(entity.getId());
		domain.setNombre(entity.getNombre());
		domain.setDescripcion(entity.getDescripcion());
		domain.setEstado(entity.getEstado());
		domain.setValorDia(entity.getValorDia());
		domain.setValorNoche(entity.getValorNoche());
		return domain;
	}

	public CanchaEntity toEntity(Cancha domain) {
		CanchaEntity entity = new CanchaEntity();
		entity.setId(domain.getId());
		entity.setNombre(domain.getNombre());
		entity.setDescripcion(domain.getDescripcion());
		entity.setValorDia(domain.getValorDia());
		entity.setValorNoche(domain.getValorNoche());
		entity.setEstado(domain.getEstado());
		return entity;
	}

}
