package com.co.canchasintetica.microservicio.dominio.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

import com.co.canchasintetica.microservicio.dominio.excepcion.CamposVaciosExcepcion;


public class Reserva {
	
	
	private static final String IS_EMPTY = "";
	private static final String CAMPOS_VACIOS = "Por favor complete todos los datos solicitados";
	private static final Integer VALOR_HORA_MINIMA = 17;

	
	private Integer id;
	private Integer canchaId;
	private String nombreSolicita;
	private LocalDate fecha;
	private String hora;
	private String estado;
	private Integer valorAbono;
	private Integer valorTotal;
	
	public Reserva(Integer id, Integer canchaId, String nombreSolicita, LocalDate fecha, String hora, String estado,
			Integer valorAbono, Integer valorTotal) {
		this.id = id;
		
		validarCampoObligatorioNumerico(canchaId);
		this.canchaId = canchaId;
		
		validarCampoObligatorioTexto(nombreSolicita);
		this.nombreSolicita = nombreSolicita;
		
		validarCampoObligatorioTexto(fecha);
		this.fecha = fecha;
		
		validarCampoObligatorioTexto(hora);
		this.hora = hora;
		
		validarCampoObligatorioTexto(estado);
		this.estado = estado;
		
		validarCampoObligatorioNumerico(valorAbono);
		this.valorAbono = valorAbono;
		this.valorTotal = valorTotal;
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
	
	private void validarCampoObligatorioTexto(Object valorCampo) {
		if (valorCampo == null || valorCampo.equals(IS_EMPTY)) {
			throw new CamposVaciosExcepcion(CAMPOS_VACIOS);
		}
	}
	
	private void validarCampoObligatorioNumerico(Integer valorCampo) {
		if (valorCampo == null || valorCampo == 0) {
			throw new CamposVaciosExcepcion(CAMPOS_VACIOS);
		}
	}
	
	public int obtenerValorCancha(Cancha cancha) {
		int valorCancha = 0;
		LocalTime time = LocalTime.parse(this.hora);
		if (time.getHour() <= VALOR_HORA_MINIMA) {
			valorCancha = cancha.getValorDia();
		}

		if (time.getHour() > VALOR_HORA_MINIMA) {
			valorCancha = cancha.getValorNoche();
		}
		return valorCancha;
	}
	
}
