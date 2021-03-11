package com.co.canchasintetica.microservicio.aplicacion.handler.reserva;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservaEntity {
	
	
	private Integer id;
	private Integer canchaId;
	private String nombreSolicita;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String hora;
	private String estado;
	private Integer valorAbono;
	private Integer valorTotal;
	
	
	public ReservaEntity(Integer id, Integer canchaId, String nombreSolicita, LocalDate fecha, String hora, String estado,
			Integer valorAbono, Integer valorTotal) {
		this.id = id;
		this.canchaId = canchaId;
		this.nombreSolicita = nombreSolicita;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.valorAbono = valorAbono;
		this.valorTotal = valorTotal;
	}
	
	public ReservaEntity() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getCanchaId() {
		return canchaId;
	}

	public void setCanchaId(int canchaId) {
		this.canchaId = canchaId;
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
	public Integer getValorAbono() {
		return valorAbono;
	}
	public void setValorAbono(Integer valorAbono) {
		this.valorAbono = valorAbono;
	}
	public Integer getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

}
