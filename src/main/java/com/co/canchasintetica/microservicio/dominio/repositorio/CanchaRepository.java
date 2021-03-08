package com.co.canchasintetica.microservicio.dominio.repositorio;

import java.util.List;

import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;

public interface CanchaRepository {
	
	/**
	 * M�todo que registra una nueva cancha en la BD
	 * 
	 * @param cancha a registrar
	 * @return id de la cancha registrada
	 */
	public Cancha crearCancha(Cancha cancha);
	
	
	/**
	 * M�todo que actualiza una  cancha en la BD
	 * 
	 * @param domain de cancha con los datos nuevos
	 */
	public void actualizarCancha(Cancha cancha);
	
	
	/**
	 * M�todo que lista todos las canchas registradas en la BD
	 * @return canchas registradas
	 */
	public List<CanchaEntity> listarCanchas();
	
	
	/**
	 * M�todo que retorna una cancha en base a un id
	 * @return cancha registrada
	 */
	public Cancha getCanchaById(int id);

}
