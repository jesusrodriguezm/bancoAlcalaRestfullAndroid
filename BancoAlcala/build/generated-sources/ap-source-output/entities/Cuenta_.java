package entities;

import entities.Movimiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-21T14:20:10")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, Integer> pin;
    public static volatile CollectionAttribute<Cuenta, Movimiento> movimientoCollection;
    public static volatile SingularAttribute<Cuenta, Double> saldo;
    public static volatile SingularAttribute<Cuenta, Integer> numero;

}