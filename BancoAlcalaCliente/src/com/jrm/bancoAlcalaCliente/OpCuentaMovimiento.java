package com.jrm.bancoAlcalaCliente;

import java.util.ArrayList;

import com.jrm.bancoAlcalaCliente.modelo.Movimiento;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;
import com.jrm.bancoAlcalaCliente.servicios.MovimientoVerUltimosServicio;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class OpCuentaMovimiento extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_op_cuenta_movimiento);
		// Show the Up button in the action bar.
		setupActionBar();
		
		ListView lvMovimientos = (ListView) findViewById(R.id.lvMovimientos);
		
		ArrayList<Movimiento> array = MovimientoVerUltimosServicio.obtenerUltimos(((MiAplicacion) getApplication()).cuentaAccedida, 10, (MiAplicacion) getApplication());
		if (array != null) {
			if (array.size() > 0) {
				ArrayAdapter<Movimiento> adapter = new ArrayAdapter<Movimiento>(
						lvMovimientos.getContext(),
						android.R.layout.simple_list_item_1, array);
				
				lvMovimientos.setAdapter(adapter);
				lvMovimientos.setVisibility(View.VISIBLE);
			}
		}
		
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
		getMenuInflater().inflate(R.menu.op_cuenta_movimiento, menu);
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
