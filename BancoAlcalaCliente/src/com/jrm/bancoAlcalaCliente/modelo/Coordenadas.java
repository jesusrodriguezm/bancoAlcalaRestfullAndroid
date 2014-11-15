package com.jrm.bancoAlcalaCliente.modelo;

import android.location.Location;

public class Coordenadas {
	public double latitud;
	public double longitud;

	public Coordenadas() {
	}
	
	public Coordenadas(Location loc) {
		if (loc != null) {
			latitud = loc.getLatitude();
			longitud = loc.getLongitude();
		}
	}

	public void setCoordenadas(Location loc) {
		if (loc != null) {
			latitud = loc.getLatitude();
			longitud = loc.getLongitude();
		}
	}
}
