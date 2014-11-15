package entities;

import entities.Movimiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-21T14:20:10")
@StaticMetamodel(TipoMovimiento.class)
public class TipoMovimiento_ { 

    public static volatile SingularAttribute<TipoMovimiento, String> id;
    public static volatile CollectionAttribute<TipoMovimiento, Movimiento> movimientoCollection;
    public static volatile SingularAttribute<TipoMovimiento, String> descripcion;

}