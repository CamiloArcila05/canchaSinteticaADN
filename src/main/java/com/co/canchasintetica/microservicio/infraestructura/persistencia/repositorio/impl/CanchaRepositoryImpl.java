package com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.CanchaEntity;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.mapper.CanchaMapper;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.jpa.CanchaRepositoryJpa;

@Component
public class CanchaRepositoryImpl implements CanchaRepository {

	@Autowired
	private CanchaRepositoryJpa jpa;

	private static final CanchaMapper mapper = CanchaMapper.getInstance();
	
	@Override
	public Cancha crearCancha(Cancha cancha) {
		CanchaEntity entity = mapper.toEntity(cancha);
		return mapper.toDomain(jpa.save(entity)); 
	}

	@Override
	public void actualizarCancha(Cancha cancha) {
		CanchaEntity entity = mapper.toEntity(cancha);
		jpa.save(entity);
	}

	@Override
	public List<com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity> listarCanchas() {
		return jpa.listarCanchas();
	}

	@Override
	public Cancha getCanchaById(int id) {
		CanchaEntity entity = jpa.getById(id);
		return mapper.toDomain(entity);
	}


}
