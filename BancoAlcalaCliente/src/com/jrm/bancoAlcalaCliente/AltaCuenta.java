package com.jrm.bancoAlcalaCliente;

import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;
import com.jrm.bancoAlcalaCliente.servicios.CuentaAltaServicio;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class AltaCuenta extends Activity {
	TextView txtResultado;
	Button btAltaCuentaSi;
	Button btAltaCuentaNo;
	TextView txtPregunta;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alta_cuenta);
		 addListeners();
		// Show the Up button in the action bar.
		setupActionBar();
	}

	  private void addListeners() {
	    	btAltaCuentaSi = (Button) findViewById(R.id.btAltaCuentaSi);
	    	btAltaCuentaNo = (Button) findViewById(R.id.btAltaCuentaNo);
	    	txtResultado = (TextView) findViewById(R.id.altaCuentaResultado);
	    	txtPregunta = (TextView)findViewById(R.id.altaCuentaPregunta);
	    	btAltaCuentaSi.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					try {
						txtResultado.setText("Creando cuenta.");
						
						txtResultado.setText(CuentaAltaServicio.alta((MiAplicacion)getApplication()));
						
						btAltaCuentaSi.setVisibility(View.INVISIBLE);
						btAltaCuentaNo.setVisibility(View.INVISIBLE);
						txtPregunta.setVisibility(View.INVISIBLE);
					} catch (Exception e) {
						txtResultado.setText(e.toString());  
					}
				}
			});
	    	
	    	btAltaCuentaNo.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					  Intent i = new Intent(AltaCuenta.this, Inicio.class);
					  startActivity(i);
				}
			});
	  }

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alta_cuenta, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
