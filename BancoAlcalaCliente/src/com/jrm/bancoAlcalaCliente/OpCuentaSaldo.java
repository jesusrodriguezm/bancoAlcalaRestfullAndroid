package com.jrm.bancoAlcalaCliente;

import java.util.Formatter;

import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;
import com.jrm.bancoAlcalaCliente.servicios.CuentaObtenerCuentaServicio;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class OpCuentaSaldo extends Activity {
	TextView txtNumCuenta;
	TextView txtSaldo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_op_cuenta_saldo);
		// Show the Up button in the action bar.
		setupActionBar();
		txtNumCuenta = (TextView) findViewById(R.id.txtSaldoNumCuenta);
		txtSaldo = (TextView) findViewById(R.id.txtSaldoSaldo);
		cargarDatos();
	}
	
	private void cargarDatos() {
		((MiAplicacion)getApplication()).cuentaAccedida =
				CuentaObtenerCuentaServicio.obtenerCuenta(((MiAplicacion)getApplication()).cuentaAccedida.getNumero(), (MiAplicacion)getApplication());
		Formatter fmt = new Formatter();
		int cuenta = ((MiAplicacion)getApplication()).cuentaAccedida.getNumero();
		String cadena = fmt.format("%1$04d", cuenta).toString();
		txtNumCuenta.setText(cadena);
		txtSaldo.setText(Double.toString(((MiAplicacion)getApplication()).cuentaAccedida.getSaldo()));
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
		getMenuInflater().inflate(R.menu.op_cuenta_saldo, menu);
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
