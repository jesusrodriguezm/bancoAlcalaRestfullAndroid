package com.jrm.bancoAlcalaCliente;

import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class OpcionesCuenta extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opciones_cuenta);
		// Show the Up button in the action bar.
		setupActionBar();
		addListeners();
	}

	private void addListeners() {
		Button btIngresoEfectivo = (Button) findViewById(R.id.btIngresoEfectivo);
		btIngresoEfectivo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(OpcionesCuenta.this,
						IngresoEfectivo.class);
				startActivity(i);
			}
		});

		Button btRetiroEfectivo = (Button) findViewById(R.id.btRetiroEfectivo);
		btRetiroEfectivo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(OpcionesCuenta.this,
						OpCuentaRetiroEfectivo.class);
				startActivity(i);
			}
		});

		Button btTransferencia = (Button) findViewById(R.id.btTransferencia);
		btTransferencia.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(OpcionesCuenta.this,
						OpCuentaTransferencia.class);
				startActivity(i);
			}
		});

		Button btRecargaTelefonica = (Button) findViewById(R.id.btRecargaTelefonica);
		btRecargaTelefonica.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(OpcionesCuenta.this,
						OpCuentaRecargaTelefonica.class);
				startActivity(i);
			}
		});

		Button btMovimientos = (Button) findViewById(R.id.btMovimientos);
		btMovimientos.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(OpcionesCuenta.this,
						OpCuentaMovimiento.class);
				startActivity(i);
			}
		});

		Button btSaldo = (Button) findViewById(R.id.btSaldo);
		btSaldo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(OpcionesCuenta.this, OpCuentaSaldo.class);
				startActivity(i);
			}
		});

		Button btSalir = (Button) findViewById(R.id.btSalir);
		btSalir.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((MiAplicacion) getApplication()).cuentaAccedida = null;
				Intent i = new Intent(OpcionesCuenta.this, Inicio.class);
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
		getMenuInflater().inflate(R.menu.opciones_cuenta, menu);
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
