package com.co.canchasintetica.microservicio.aplicacion.comun;

public class ComandoRespuesta<T> {

    private T valor;

    public ComandoRespuesta(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }
}

