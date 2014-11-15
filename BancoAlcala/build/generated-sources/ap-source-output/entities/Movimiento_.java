package entities;

import entities.Cuenta;
import entities.TipoMovimiento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-21T14:20:10")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, Integer> idMovimiento;
    public static volatile SingularAttribute<Movimiento, Cuenta> numCuenta;
    public static volatile SingularAttribute<Movimiento, Date> fecha;
    public static volatile SingularAttribute<Movimiento, TipoMovimiento> tipo;
    public static volatile SingularAttribute<Movimiento, Double> latitud;
    public static volatile SingularAttribute<Movimiento, Double> longitud;
    public static volatile SingularAttribute<Movimiento, Double> monto;

}