package com.jrm.bancoAlcalaCliente.servicios;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.jrm.bancoAlcalaCliente.modelo.Cuenta;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;

public class CuentaObtenerCuentaServicio {
	public static Cuenta obtenerCuenta(int numCuenta, MiAplicacion application) {
		Cuenta cuenta = null;
		String direccionServicio = application.direccionServicios;
		direccionServicio = direccionServicio + "entities.cuenta";
		direccionServicio = direccionServicio + "/" + numCuenta;
		JSONObject salida = application
				.ejecutarPeticionGetWebService(direccionServicio);
		if (salida == null) {
			return cuenta;
		} else {
			Gson gson = new Gson();
			cuenta = gson.fromJson(salida.toString(), Cuenta.class);
			if (cuenta == null) {
				return cuenta;
			} else {
				return cuenta;
			}
		}
	}
}
