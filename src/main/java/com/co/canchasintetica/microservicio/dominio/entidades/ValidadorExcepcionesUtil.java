package com.co.canchasintetica.microservicio.dominio.entidades;

import java.time.LocalTime;

import com.co.canchasintetica.microservicio.dominio.excepcion.CamposVaciosExcepcion;
import com.co.canchasintetica.microservicio.dominio.excepcion.ReservaUnicaExcepcion;
import com.co.canchasintetica.microservicio.dominio.excepcion.ValidarFinalizarReservaExcepcion;
public class ValidadorExcepcionesUtil {
	
	private static final String IS_EMPTY = "";
	private static final String CAMPOS_VACIOS = "Por favor complete todos los datos solicitados";
	private static final String RESERVA_UNICA = "Ya existe una reserva en esa fecha y en esa hora para esta cancha";
	private static final String VALOR_ABONO_MINIMO = "El valor del abono debe superar el 10% del valor del alquier de la cancha";
	private static final String VALOR_FINALIZAR_RESERVA = "El valor ingresado es inferior al valor que resta por pago";
	
	public static void validarCamposVacios(Object value) {
		if (value == null || value.equals(IS_EMPTY)) {
			throw new CamposVaciosExcepcion(CAMPOS_VACIOS);
		}
	}
	
	public static void validarCampoValor(Integer value) {
		if (value == null || value == 0) {
			throw new CamposVaciosExcepcion(CAMPOS_VACIOS);
		}
	}
	
	public static void validarUnicaReserva(Reserva value) {
		if (value != null) {
			throw new ReservaUnicaExcepcion(RESERVA_UNICA);
		}
	}
	
	
	public static void validarValorRestanteReserva(Reserva value, Cancha cancha, int valorFinal) {
		
		int valorCancha = obtenerValorCancha(value, cancha);
	    int valorRestante = valorCancha - value.getValorAbono();	
		if (valorRestante > valorFinal) {
			throw new ValidarFinalizarReservaExcepcion(VALOR_FINALIZAR_RESERVA);
		}
	}
	
	public static void validarValorAbono(Reserva value, Cancha cancha) {
		int porcentajeAbonoMinimo = Math.round(obtenerValorCancha(value, cancha) * 0.10f);
		if (value.getValorAbono() < porcentajeAbonoMinimo) {
			throw new ValidarFinalizarReservaExcepcion(VALOR_ABONO_MINIMO);
		}
	}

	
	private static int obtenerValorCancha(Reserva value, Cancha cancha) {
		int valorCancha = 0;
		LocalTime time = LocalTime.parse(value.getHora());
		if (time.getHour() <= 17) {
			valorCancha = cancha.getValorDia();
		}

		if (time.getHour() > 17) {
			valorCancha = cancha.getValorNoche();
		}
		return valorCancha;
	}

}
