package com.co.canchasintetica.microservicio.aplicacion.utils;

public class UtilResponse<T> {
	
private T value;
	
	public UtilResponse(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
