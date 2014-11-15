package com.jrm.bancoAlcalaCliente;

import com.jrm.bancoAlcalaCliente.modelo.Cuenta;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;
import com.jrm.bancoAlcalaCliente.servicios.CuentaAccesoServicio;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class AccesoCuenta extends Activity {
	TextView txtError;
	Button btEntrar;
	EditText txtNumCuenta;
	EditText txtPin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acceso_cuenta);
		// Show the Up button in the action bar.
		setupActionBar();
		enlazarElementos();
		txtError.setVisibility(View.INVISIBLE);
		addListeners();
		txtNumCuenta.requestFocus();
	}

	private void enlazarElementos() {
		txtError = (TextView) findViewById(R.id.accesoCuentaError);
		btEntrar = (Button) findViewById(R.id.btAccesoCuentaEntrar);
		txtNumCuenta = (EditText) findViewById(R.id.accesoCuentaNumCuenta);
		txtPin = (EditText) findViewById(R.id.accesoCuentaPin);
	}

	private void addListeners() {
		btEntrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					if (txtNumCuenta.getText().length() < 4) {
						txtError.setText("El numero de cuenta debe contar con 4 digitos.");
						txtError.setVisibility(View.VISIBLE);
					} 
					else
						if (txtPin.getText().length() < 4) {
							txtError.setText("El PIN debe contar con 4 digitos.");
							txtError.setVisibility(View.VISIBLE);
						} 
						else {
							int numCuenta = Integer.parseInt(txtNumCuenta.getText().toString());
							int pin = Integer.parseInt(txtPin.getText().toString());
							//Cuenta cuenta = null;
							Cuenta cuenta = CuentaAccesoServicio.acceso(numCuenta, pin, (MiAplicacion)getApplication());

							if (cuenta != null) {
								((MiAplicacion)getApplication()).cuentaAccedida = cuenta;
								  Intent i = new Intent(AccesoCuenta.this, OpcionesCuenta.class);
								  startActivity(i);
							} else {
								txtError.setText("Error.");
								txtError.setVisibility(View.VISIBLE);
							}
						}
				} catch (Exception e) {
					txtError.setText(e.toString());  
				}
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
		getMenuInflater().inflate(R.menu.acceso_cuenta, menu);
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
