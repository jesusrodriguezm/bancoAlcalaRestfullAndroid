package com.jrm.bancoAlcalaCliente;

import java.util.Date;

import com.jrm.bancoAlcalaCliente.modelo.Coordenadas;
import com.jrm.bancoAlcalaCliente.modelo.Movimiento;
import com.jrm.bancoAlcalaCliente.modelo.utiles.MiAplicacion;
import com.jrm.bancoAlcalaCliente.servicios.CuentaEditarServicio;
import com.jrm.bancoAlcalaCliente.servicios.MovimientoInsertarServicio;
import com.jrm.bancoAlcalaCliente.servicios.TipoMovimientoObtenerTipoMovimientoServicio;

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

public class OpCuentaRetiroEfectivo extends Activity {
	Button btRealizarAccion;
	EditText txtCantidad;
	TextView txtAvisoMonto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_op_cuenta_retiro_efectivo);
		// Show the Up button in the action bar.
		setupActionBar();
		btRealizarAccion = (Button) findViewById(R.id.btRealizarAccion);
		txtCantidad = (EditText) findViewById(R.id.txtCantidad);
		txtAvisoMonto = (TextView) findViewById(R.id.montoDebeSerPositivo);
		txtAvisoMonto.setVisibility(View.INVISIBLE);
		addListeners();
	}

	private void addListeners() {
		btRealizarAccion.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (txtCantidad.getText().toString().length() > 0) {
					Double cantidad = Double.parseDouble(txtCantidad.getText()
							.toString());
					if (cantidad > 0) {
						if (cantidad <= ((MiAplicacion) getApplication()).cuentaAccedida
								.getSaldo()) {
							((MiAplicacion) getApplication()).cuentaAccedida
									.setSaldo(((MiAplicacion) getApplication()).cuentaAccedida
											.getSaldo() - cantidad);

							CuentaEditarServicio
									.editar(((MiAplicacion) getApplication()).cuentaAccedida,
											(MiAplicacion) getApplication());

							Movimiento mov = new Movimiento();
							mov.setIdMovimiento(-1);
							mov.setNumCuenta(((MiAplicacion) getApplication()).cuentaAccedida);
							Date fecha = new Date();
							mov.setFecha(fecha);
							mov.setMonto(cantidad * -1);
							mov.setTipo(TipoMovimientoObtenerTipoMovimientoServicio
									.obtenerTipoMovimiento("RE",
											(MiAplicacion) getApplication()));
							Coordenadas coord = new Coordenadas(
									((MiAplicacion) getApplication()).locListener
											.getLoc());
							mov.setLongitud(coord.longitud);
							mov.setLatitud(coord.latitud);
							MovimientoInsertarServicio.insertar(mov,
									(MiAplicacion) getApplication());

							Intent i = new Intent(OpCuentaRetiroEfectivo.this,
									OpcionesCuenta.class);
							startActivity(i);
						} else {
							txtAvisoMonto
									.setText("La cantidad debe ser menor o igual al saldo: \n Saldo: "
											+ ((MiAplicacion) getApplication()).cuentaAccedida
													.getSaldo());
							txtAvisoMonto.setVisibility(View.VISIBLE);
						}
					} else {
						txtAvisoMonto.setText("El monto debe ser positivo");
						txtAvisoMonto.setVisibility(View.VISIBLE);
					}
				} else {
					txtAvisoMonto.setText("Debe digitar el monto");
					txtAvisoMonto.setVisibility(View.VISIBLE);
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
		getMenuInflater().inflate(R.menu.op_cuenta_retiro_efectivo, menu);
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
