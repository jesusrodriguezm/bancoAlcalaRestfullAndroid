package com.jrm.bancoAlcalaCliente.modelo.utiles;

import java.util.concurrent.ExecutionException;

import org.json.JSONObject;

import com.jrm.bancoAlcalaCliente.modelo.Cuenta;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;
import android.os.AsyncTask;

public class MiAplicacion extends Application {

	final private String direccionPuerto = "192.168.1.105:8080/";

	final private String direccionRecursosWebsAplicacion = "BancoAlcala/webresources/";

	public final String direccionServicios = "http://" + direccionPuerto
			+ direccionRecursosWebsAplicacion;

	public Cuenta cuentaAccedida;
	public MiLocationListener locListener;
	
	@Override
	public void onCreate() {
		super.onCreate();
		cuentaAccedida = null;
		
		locListener = new MiLocationListener();
		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				locListener);
		
		// Initialize the singletons so their instances
		// are bound to the application process.
		initSingletons();
	}

	protected void initSingletons() {
		// Initialize the instance of MySingleton
		// MySingleton.initInstance();
	}

	public JSONObject ejecutarPeticionGetWebService(String cadena) {
		AsyncTask<String, Void, JSONObject> aux = new LlamarWebServiceGetJSON()
				.execute(cadena);
		try {
			JSONObject jsonObject = aux.get();
			return jsonObject;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String ejecutarPeticionGetWebServiceSalidaPlana(String cadena) {
		AsyncTask<String, Void, String> aux = new LlamarWebServiceGetSalidaPlana()
				.execute(cadena);
		try {
			String jsonObject = aux.get();
			return jsonObject;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public JSONObject ejecutarPeticionPostWebService(String cadena, JSONObject jsonObj) {
		AsyncTask<String, Void, JSONObject> aux = new LlamarWebServicePost()
				.execute(cadena, jsonObj.toString());
		try {
			JSONObject jsonObject = aux.get();
			return jsonObject;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public JSONObject ejecutarPeticionPutWebService(String cadena, JSONObject jsonObj) {
		AsyncTask<String, Void, JSONObject> aux = new LlamarWebServicePut()
				.execute(cadena, jsonObj.toString());
		try {
			JSONObject jsonObject = aux.get();
			return jsonObject;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

}
