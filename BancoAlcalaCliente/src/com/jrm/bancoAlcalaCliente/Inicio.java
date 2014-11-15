package com.jrm.bancoAlcalaCliente;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//SENSOR SIMULATOR
import org.openintents.sensorsimulator.hardware.Sensor;
import org.openintents.sensorsimulator.hardware.SensorEvent;
import org.openintents.sensorsimulator.hardware.SensorEventListener;
import org.openintents.sensorsimulator.hardware.SensorManagerSimulator;
//**********

//REAL DEVICE
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager; // required for getRotationMatrix and getOrientation
//**********

//import android.os.AsyncTask;
//import android.util.Log;

//@TargetApi(Build.VERSION_CODES.GINGERBREAD)
//@SuppressLint({ "NewApi", "ShowToast" })
public class Inicio extends Activity implements SensorEventListener {

	// SENSOR SIMULATOR
	private SensorManagerSimulator mSensorManager;
	//private ConnectionToSensorSimulator conn;

	// **********

	// REAL DEVICE
	// private SensorManager mSensorManager;
	// **********

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		addListeners();

		// SENSOR SIMULATOR
		/*mSensorManager = SensorManagerSimulator.getSystemService(this,
				SENSOR_SERVICE);
		conn = new ConnectionToSensorSimulator();
		conn.execute();
		*/
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		mSensorManager = SensorManagerSimulator.getSystemService(this, SENSOR_SERVICE);
		mSensorManager.connectSimulator();
		// **********

		// REAL DEVICE
		// mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		// *********
	}

	private void addListeners() {
		Button btAltaCuenta = (Button) findViewById(R.id.btAltaCuenta);
		btAltaCuenta.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Inicio.this, AltaCuenta.class);
				startActivity(i);
			}
		});

		Button btAccesoCuenta = (Button) findViewById(R.id.btAccesoCuenta);
		btAccesoCuenta.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Inicio.this, AccesoCuenta.class);
				startActivity(i);
			}
		});

		Button btVerCuentas = (Button) findViewById(R.id.btVerCuentas);
		btVerCuentas.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Inicio.this, VerCuentas.class);
				startActivity(i);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		// SENSOR SIMULATOR
		mSensorManager.registerListener(this,
				mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
				SensorManagerSimulator.SENSOR_DELAY_NORMAL);
		// **********

		// REAL DEVICE
		// mSensorManager.registerListener(this,
		// mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
		// SensorManager.SENSOR_DELAY_NORMAL);
		// **********
	}

	@Override
	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	public void onSensorChanged(SensorEvent event) {

		synchronized (this) {

			// SENSOR SIMULATOR
			int sensor = event.type;
			// **********

			// REAL DEVICE
			// int sensor = event.sensor.getType();
			// **********
			//System.out.println("Detectado evento sensores.");
			float[] values = event.values;

			switch (sensor) {
			case Sensor.TYPE_PROXIMITY:
				if (values[0] > 0.0 && values[0] < 3.0){
					System.out.println("Detectado evento de proximidad: " + values[0]);
					Context context = getApplicationContext();
					CharSequence text = "Practica final PAW. \n Jesus Rodriguez.";
					int duration = Toast.LENGTH_SHORT ;

					final Toast toast = Toast.makeText(context, text, duration);
					//toast.show();
					mostrarToastDuracionVariable(toast,10);
				}
				break;
			case Sensor.TYPE_ACCELEROMETER:

				break;
			case Sensor.TYPE_MAGNETIC_FIELD:

				break;
			case Sensor.TYPE_GYROSCOPE:

				break;
			default:
				break;
			}
		}
	}

	  private void mostrarToastDuracionVariable(final Toast toast, final int duracion) {
	        Thread t = new Thread() {
	            public void run() {
	                int count = 0;
	                try {
	                    while (true && count < duracion - 1) {
	                        toast.show();
	                        sleep(1000);
	                        count++;
	                    }
	                    System.out.println("Fin mostrar mensaje.");
	                } catch (Exception e) {
	                    System.out.println("mostrarToastDuracionVariable" + e.toString());
	                }
	            }
	        };
	        t.start();
	    }
	
	/*private class ConnectionToSensorSimulator extends
			AsyncTask<Void, Void, Boolean> {

		@Override
		protected Boolean doInBackground(Void... params) {
			Log.d("SENSOR", "CONNECTING TO SENSOR SIMULATOR");
			mSensorManager.connectSimulator();
			return true;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			if (result) {
				Log.d("SENSOR", "CONNECTED TO SENSOR SIMULATOR");
			} else {
				Log.d("SENSOR", "NOT CONNECTED TO SENSOR SIMULATOR");
			}
		}
	}*/

}
