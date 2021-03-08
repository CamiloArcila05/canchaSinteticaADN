package com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.CanchaEntity;


public interface CanchaRepositoryJpa extends CrudRepository<CanchaEntity, Integer>{
	
	@Query("select new com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity"
			+ "(c.id, c.nombre, c.descripcion, c.estado, c.valorDia, c.valorNoche) from "
			+ "CanchaEntity c")
	List<com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity> listarCanchas();
	
	@Query("select c from CanchaEntity c where c.id = :id")
	CanchaEntity getById(@Param("id") int id);

}
