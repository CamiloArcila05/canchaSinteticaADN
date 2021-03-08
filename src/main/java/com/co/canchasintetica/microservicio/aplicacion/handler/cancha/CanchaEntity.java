package com.co.canchasintetica.microservicio.aplicacion.handler.cancha;

public class CanchaEntity {
	
	private int id;
	private String nombre;
	private String descripcion;
	private String estado;
	private int valorDia;
	private int valorNoche;
	
	public CanchaEntity() {
		
	}
	
	public CanchaEntity(int id, String nombre, String descripcion, String estado, int valorDia, int valorNoche) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.valorDia = valorDia;
		this.valorNoche = valorNoche;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getValorDia() {
		return valorDia;
	}

	public void setValorDia(int valorDia) {
		this.valorDia = valorDia;
	}

	public int getValorNoche() {
		return valorNoche;
	}

	public void setValorNoche(int valorNoche) {
		this.valorNoche = valorNoche;
	}

	@Override
	public String toString() {
		return "Cancha [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", valorDia=" + valorDia + ", valorNoche=" + valorNoche + "]";
	}

}
