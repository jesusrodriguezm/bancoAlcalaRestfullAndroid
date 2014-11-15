package com.jrm.bancoAlcalaCliente.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Formatter;

public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer numero;
	private int pin;
	private double saldo;
	private Collection<Movimiento> movimientoCollection;

	public Cuenta() {
	}

	/*
	 * public Cuenta(JSONObject json) throws JSONException{ JSONObject
	 * jsonCuenta = json; //.getJSONObject("cuenta"); this.numero =
	 * jsonCuenta.getInt("numero"); this.pin = jsonCuenta.getInt("pin");
	 * this.saldo = jsonCuenta.getDouble("saldo"); }
	 */

	public Cuenta(Integer numero) {
		this.numero = numero;
	}

	public Cuenta(Integer numero, int pin, double saldo) {
		this.numero = numero;
		this.pin = pin;
		this.saldo = saldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Collection<Movimiento> getMovimientoCollection() {
		return movimientoCollection;
	}

	public void setMovimientoCollection(
			Collection<Movimiento> movimientoCollection) {
		this.movimientoCollection = movimientoCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (numero != null ? numero.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Cuenta)) {
			return false;
		}
		Cuenta other = (Cuenta) object;
		if ((this.numero == null && other.numero != null)
				|| (this.numero != null && !this.numero.equals(other.numero))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		Formatter fmt2 = new Formatter();

		return "Cuenta '" + fmt.format("%1$04d", numero) + "' (PIN: '"
				+ fmt2.format("%1$04d", pin) + "')"; // con un saldo de: " +
														// saldo;
	}

}
