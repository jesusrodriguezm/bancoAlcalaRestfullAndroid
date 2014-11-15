package com.jrm.bancoAlcalaCliente.servicios;

import com.jrm.bancoAlcalaCliente.modelo.Cuenta;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;

public class CuentaAccesoServicio {
	public static Cuenta acceso(int numCuenta, int pin, MiAplicacion application) {
		Cuenta cuenta = null;
		cuenta = CuentaObtenerCuentaServicio.obtenerCuenta(numCuenta,
				application);
		if (cuenta != null) {
			if (cuenta.getPin() != pin) {
				cuenta = null;
			}
		}
		return cuenta;
	}
}
