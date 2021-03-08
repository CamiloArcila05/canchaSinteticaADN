package com.co.canchasintetica.microservicio.dominio.entidades;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Reserva {
	
	
	private int id;
	private int canchaId;
	private String nombreSolicita;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String hora;
	private String estado;
	private int valorAbono;
	private int valorTotal;
	
	public Reserva() {
		
	}
	
	
	public Reserva(int id, int canchaId, String nombreSolicita, LocalDate fecha, String hora, String estado,
			int valorAbono, int valorTotal) {
		this.id = id;
		
		ValidadorExcepcionesUtil.validarCampoValor(canchaId);
		this.canchaId = canchaId;
		
		ValidadorExcepcionesUtil.validarCamposVacios(nombreSolicita);
		this.nombreSolicita = nombreSolicita;
		
		ValidadorExcepcionesUtil.validarCamposVacios(fecha);
		this.fecha = fecha;
		
		ValidadorExcepcionesUtil.validarCamposVacios(hora);
		this.hora = hora;
		
		ValidadorExcepcionesUtil.validarCamposVacios(estado);
		this.estado = estado;
		
		ValidadorExcepcionesUtil.validarCampoValor(valorAbono);
		this.valorAbono = valorAbono;
		this.valorTotal = valorTotal;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
