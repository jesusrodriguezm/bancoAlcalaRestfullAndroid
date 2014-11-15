package com.jrm.bancoAlcalaCliente.servicios;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.jrm.bancoAlcalaCliente.modelo.Cuenta;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;

public class CuentaEditarServicio {
	public static String editar(Cuenta cuenta, MiAplicacion application) {
		try {
			String direccionServicio = application.direccionServicios;
			direccionServicio = direccionServicio + "entities.cuenta";

			Gson gson = new Gson();
			JSONObject json = new JSONObject(gson.toJson(cuenta));
			application.ejecutarPeticionPutWebService(direccionServicio, json);

			return "Cuenta Editada: \n" + cuenta.toString();
		} catch (Exception e) {
			System.out.println(e.toString());
			return "ERROR creando la cuenta.";
		}
	}
}
