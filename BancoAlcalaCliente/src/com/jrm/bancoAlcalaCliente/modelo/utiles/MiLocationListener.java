package com.jrm.bancoAlcalaCliente.modelo.utiles;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public final class MiLocationListener implements LocationListener {
	Location loc;
	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	@Override
	public void onLocationChanged(Location location) {
		if (location!= null){
			loc = location;
		}
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
