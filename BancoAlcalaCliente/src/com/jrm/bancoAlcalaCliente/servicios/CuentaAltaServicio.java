package com.jrm.bancoAlcalaCliente.servicios;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.jrm.bancoAlcalaCliente.modelo.Cuenta;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;

public class CuentaAltaServicio {
	public static String alta(MiAplicacion application) {
		try {
			Cuenta cuenta = new Cuenta();
			cuenta.setNumero(-1);
			cuenta.setSaldo(0);
			java.util.Random rndGenerator = new java.util.Random();
			cuenta.setPin(rndGenerator.nextInt(9999));

			String direccionServicio = application.direccionServicios;
			direccionServicio = direccionServicio + "entities.cuenta";
			Gson gson = new Gson();
			JSONObject json = new JSONObject(gson.toJson(cuenta));
			application.ejecutarPeticionPostWebService(direccionServicio, json);

			direccionServicio = direccionServicio + "/count";
			String salida = application
					.ejecutarPeticionGetWebServiceSalidaPlana(direccionServicio);
			cuenta.setNumero(Integer.parseInt(salida));

			return "Cuenta Creada: \n" + cuenta.toString();
		} catch (Exception e) {
			System.out.println(e.toString());
			return "ERROR creando la cuenta.";
		}
	}
}
