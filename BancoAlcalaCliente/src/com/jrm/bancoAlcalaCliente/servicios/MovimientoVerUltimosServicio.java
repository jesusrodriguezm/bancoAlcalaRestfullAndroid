package com.jrm.bancoAlcalaCliente.servicios;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jrm.bancoAlcalaCliente.modelo.Cuenta;
import com.jrm.bancoAlcalaCliente.modelo.Movimiento;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;

public class MovimientoVerUltimosServicio {
	
	public static ArrayList<Movimiento> obtenerUltimos(Cuenta cuenta, int num, MiAplicacion application) {
		ArrayList<Movimiento> movimientossArray = null;
		// http://192.168.1.102:8080/BancoAlcala/webresources/entities.cuenta/0/10000
		String direccionServicio = application.direccionServicios;
		direccionServicio = direccionServicio + "entities.movimiento/ultimos/";
		direccionServicio = direccionServicio + cuenta.getNumero() + "/";
		direccionServicio = direccionServicio + num;
		JSONObject jsonObj = application
				.ejecutarPeticionGetWebService(direccionServicio);
		if (jsonObj != null) {
			try {
				movimientossArray = new ArrayList<Movimiento>();
				if (jsonObj.get("movimiento") instanceof JSONArray) {
					JSONArray cuentaJSONArray = jsonObj.getJSONArray("movimiento");
					if (cuentaJSONArray.length() > 0) {
						int i = 0;
						while (i < cuentaJSONArray.length()) {
							// cuentasArray.add(new
							// Cuenta(cuentaJSONArray.getJSONObject(i)));
							//Gson gson = new Gson();
							Gson gSon =  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
							Movimiento mov = gSon.fromJson(cuentaJSONArray.getJSONObject(i).toString(), Movimiento.class);
							movimientossArray.add(mov);
							i++;
						}
					}	
				} else {
					Gson gSon =  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
					Movimiento mov = gSon.fromJson(jsonObj.getJSONObject("movimiento").toString(), Movimiento.class);
					movimientossArray.add(mov);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}

			return movimientossArray;
		}
		return null;
	}
}
