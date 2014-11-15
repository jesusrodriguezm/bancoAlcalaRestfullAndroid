/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Cuenta;
import entities.Movimiento;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author jesusrodriguez
 */
@Stateless
@Path("entities.movimiento")
public class MovimientoFacadeREST extends AbstractFacade<Movimiento> {
    @EJB
    private CuentaFacadeREST cuentaFacadeREST;
    
    @PersistenceContext(unitName = "BancoAlcalaPU")
    private EntityManager em;

    public MovimientoFacadeREST() {
        super(Movimiento.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Movimiento entity) {
        entity.setFecha(new Date());
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Movimiento entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Movimiento find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Movimiento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Movimiento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("ultimos/{numCuenta}/{numVistos}")
    @Produces({"application/xml", "application/json"})
    public List<Movimiento> ultimos(@PathParam("numCuenta") int numCuenta, @PathParam("numVistos") int numVistos) {
       Query  query = em.createNamedQuery("Movimiento.ultimos");
       Cuenta cuenta = cuentaFacadeREST.find(numCuenta);
       query.setParameter("numCuenta", cuenta);
       query.setMaxResults(numVistos);
       return query.getResultList();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
