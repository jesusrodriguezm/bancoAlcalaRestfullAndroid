package com.jrm.bancoAlcalaCliente.servicios;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.jrm.bancoAlcalaCliente.modelo.TipoMovimiento;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;

public class TipoMovimientoObtenerTipoMovimientoServicio {
	public static TipoMovimiento obtenerTipoMovimiento(String tipoMovimiento, MiAplicacion application) {
		TipoMovimiento mov = null;
		String direccionServicio = application.direccionServicios;
		direccionServicio = direccionServicio + "entities.tipomovimiento";
		direccionServicio = direccionServicio + "/" + tipoMovimiento;
		JSONObject salida = application
				.ejecutarPeticionGetWebService(direccionServicio);
		if (salida == null) {
			return mov;
		} else {
			Gson gson = new Gson();
			mov = gson.fromJson(salida.toString(), TipoMovimiento.class);
			if (mov == null) {
				return mov;
			} else {
				return mov;
			}
		}
	}
}
