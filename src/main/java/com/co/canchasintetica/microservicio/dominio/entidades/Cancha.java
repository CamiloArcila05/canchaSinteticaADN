package com.co.canchasintetica.microservicio.dominio.entidades;

import com.co.canchasintetica.microservicio.dominio.excepcion.CamposVaciosExcepcion;

public class Cancha {
	
	private static final String IS_EMPTY = "";
	private static final String CAMPOS_VACIOS = "Por favor complete todos los datos solicitados";

	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String estado;
	private Integer valorDia;
	private Integer valorNoche;
	
	public Cancha(Integer id, String nombre, String descrip, String estado, Integer valorDia, Integer valorNoche) {
		
		this.id = id;
		
		validarCampoObligatorioTexto(nombre);
		this.nombre = nombre;
		
		validarCampoObligatorioTexto(descrip);
		this.descripcion = descrip;
		
		validarCampoObligatorioTexto(estado);
		this.estado = estado;
		
		validarCampoObligatorioNumerico(valorDia);
		this.valorDia = valorDia;
		
		validarCampoObligatorioNumerico(valorNoche);
		this.valorNoche = valorNoche;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getValorDia() {
		return valorDia;
	}

	public void setValorDia(Integer valorDia) {
		this.valorDia = valorDia;
	}

	public Integer getValorNoche() {
		return valorNoche;
	}

	public void setValorNoche(Integer valorNoche) {
		this.valorNoche = valorNoche;
	}

	@Override
	public String toString() {
		return "Cancha [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", valorDia=" + valorDia + ", valorNoche=" + valorNoche + "]";
	}
	
	private void validarCampoObligatorioTexto(String valorCampo) {
		if (valorCampo == null || valorCampo.equals(IS_EMPTY)) {
			throw new CamposVaciosExcepcion(CAMPOS_VACIOS);
		}
	}
	
	private void validarCampoObligatorioNumerico(Integer valorCampo) {
		if (valorCampo == null || valorCampo == 0) {
			throw new CamposVaciosExcepcion(CAMPOS_VACIOS);
		}
	}
	
}
