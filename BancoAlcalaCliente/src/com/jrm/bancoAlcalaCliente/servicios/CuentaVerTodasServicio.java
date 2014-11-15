package com.jrm.bancoAlcalaCliente.servicios;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.jrm.bancoAlcalaCliente.modelo.Cuenta;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;

public class CuentaVerTodasServicio {
	public static ArrayList<Cuenta> obtenerTodas(MiAplicacion application) {
		ArrayList<Cuenta> cuentasArray = null;
		// http://192.168.1.102:8080/BancoAlcala/webresources/entities.cuenta/0/10000
		String direccionServicio = application.direccionServicios;
		direccionServicio = direccionServicio + "entities.cuenta/0/9999999";
		JSONObject jsonObj = application
				.ejecutarPeticionGetWebService(direccionServicio);
		if (jsonObj != null) {
			try {
				cuentasArray = new ArrayList<Cuenta>();
				if (jsonObj.get("cuenta") instanceof JSONArray) {
					JSONArray cuentaJSONArray = jsonObj.getJSONArray("cuenta");
					if (cuentaJSONArray.length() > 0) {
						int i = 0;
						while (i < cuentaJSONArray.length()) {
							// cuentasArray.add(new
							// Cuenta(cuentaJSONArray.getJSONObject(i)));
							Gson gson = new Gson();
							Cuenta cuenta = gson.fromJson(cuentaJSONArray.getJSONObject(i).toString(), Cuenta.class);
							cuentasArray.add(cuenta);
							i++;
						}
					}	
				} else {
					Gson gson = new Gson();
					Cuenta cuenta = gson.fromJson(jsonObj.getJSONObject("cuenta").toString(), Cuenta.class);
					cuentasArray.add(cuenta);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}

			return cuentasArray;
		}
		return null;
	}
}
