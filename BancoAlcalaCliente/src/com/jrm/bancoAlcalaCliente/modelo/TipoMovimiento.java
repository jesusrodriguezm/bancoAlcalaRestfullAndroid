package com.jrm.bancoAlcalaCliente.modelo;

import java.io.Serializable;
import java.util.Collection;

public class TipoMovimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String descripcion;
    private Collection<Movimiento> movimientoCollection;

    public TipoMovimiento() {
    }

    public TipoMovimiento(String id) {
        this.id = id;
    }

    public TipoMovimiento(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Movimiento> getMovimientoCollection() {
        return movimientoCollection;
    }

    public void setMovimientoCollection(Collection<Movimiento> movimientoCollection) {
        this.movimientoCollection = movimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovimiento)) {
            return false;
        }
        TipoMovimiento other = (TipoMovimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoMovimiento id: '" + id + "' descripcion: '" + descripcion + "'";
    }
    
}