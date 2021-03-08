package com.co.canchasintetica.microservicio.aplicacion.handler.reserva;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservaEntity {
	
	
	private int id;
	private int id_cancha;
	private String nombreSolicita;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String hora;
	private String estado;
	private int valorAbono;
	private int valorTotal;
	
	public ReservaEntity() {
		
	}
	
	public ReservaEntity(int id, int id_cancha, String nombreSolicita, LocalDate fecha, String hora, String estado,
			int valorAbono, int valorTotal) {
		this.id = id;
		this.id_cancha = id_cancha;
		this.nombreSolicita = nombreSolicita;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.valorAbono = valorAbono;
		this.valorTotal = valorTotal;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getId_cancha() {
		return id_cancha;
	}

	public void setId_cancha(int id_cancha) {
		this.id_cancha = id_cancha;
	}

	public String getNombreSolicita() {
		return nombreSolicita;
	}
	public void setNombreSolicita(String nombreSolicita) {
		this.nombreSolicita = nombreSolicita;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getValorAbono() {
		return valorAbono;
	}
	public void setValorAbono(int valorAbono) {
		this.valorAbono = valorAbono;
	}
	public int getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

}
