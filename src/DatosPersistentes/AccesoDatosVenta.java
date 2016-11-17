/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersistentes;


import Negocio.Entidades.Venta;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

/**
 *
 * @author DEMON
 */
public class AccesoDatosVenta extends AccesoDatos<Venta>{

    
     public List<Venta> getPorFechaCreacion(Date fecha) {
        String COLUMN_NAME = "fecha_creacion";
        List<Venta> ventasEncontradas = null;
        
        try {
            iniciarTransaccion();
            Criteria criterio = sesion.createCriteria(getTipoClase());
            SimpleExpression restriccion = Restrictions.eq(COLUMN_NAME, fecha);
            ventasEncontradas = criterio.add(restriccion).list();
        } catch (HibernateException excepcion) {
            manejarExcepcionHibernate(excepcion);
            throw excepcion;
        } finally {
            terminarTransaccion();
        }
        
        return ventasEncontradas;
    }
    
       
    @Override
    protected Class getTipoClase() {
        return Venta.class;
    }
}
