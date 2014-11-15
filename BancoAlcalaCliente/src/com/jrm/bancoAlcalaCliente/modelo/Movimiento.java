package com.jrm.bancoAlcalaCliente.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Formatter;

public class Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idMovimiento;
    private Date fecha;
    private double monto;
    private double longitud;
    private double latitud;
    private Cuenta numCuenta;
    private TipoMovimiento tipo;

    public Movimiento() {
    }

    public Movimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    
    public Movimiento(Integer idMovimiento, Date fecha, double monto, double longitud, double latitud) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.monto = monto;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public Cuenta getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(Cuenta numCuenta) {
        this.numCuenta = numCuenta;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	Formatter fmt = new Formatter();
        //return "Movimiento n:" + idMovimiento + " cuenta: '" + fmt.format("%1$04d", numCuenta.getNumero()) + "' tipo: '" + tipo.getDescripcion() + "' monto: " + monto;
        return "Cuenta: '" + fmt.format("%1$04d", numCuenta.getNumero()) + "': " + tipo.getDescripcion() + " monto: " + monto + " (long: "+ longitud +" - latitud: "+ latitud +")";
    }
    
}
