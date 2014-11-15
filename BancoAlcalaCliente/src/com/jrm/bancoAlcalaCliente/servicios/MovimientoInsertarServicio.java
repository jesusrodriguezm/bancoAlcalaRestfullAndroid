package com.jrm.bancoAlcalaCliente.servicios;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.jrm.bancoAlcalaCliente.modelo.Movimiento;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;

public class MovimientoInsertarServicio {
	public static String insertar(Movimiento mov,MiAplicacion application) {
		try {

			String direccionServicio = application.direccionServicios;
			direccionServicio = direccionServicio + "entities.movimiento";
			Gson gson = new Gson();
			JSONObject json = new JSONObject(gson.toJson(mov));
			application.ejecutarPeticionPostWebService(direccionServicio, json);

			return "Movimiento insertado: \n" + mov.toString();
		} catch (Exception e) {
			System.out.println(e.toString());
			return "ERROR creando la cuenta.";
		}
	}
}
