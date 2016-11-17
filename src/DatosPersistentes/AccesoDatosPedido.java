/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersistentes;


import Negocio.Entidades.Enums.TipoReporte;
import Negocio.Entidades.Pedido;
import Negocio.Entidades.GrupoProds;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

/**
 *
 * @author DEMON
 */
public class AccesoDatosPedido extends AccesoDatos<Pedido>{

    public List<Pedido> getPorFechaCreacion(Date fecha) {
        String COLUMN_NAME = "fecha_creacion";
        List<Pedido> pedidosEncontrados = null;
        
        try {
            iniciarTransaccion();
            Criteria criterio = sesion.createCriteria(getTipoClase());
            SimpleExpression restriccion = Restrictions.eq(COLUMN_NAME, fecha);
            pedidosEncontrados = criterio.add(restriccion).list();
        } catch (HibernateException excepcion) {
            manejarExcepcionHibernate(excepcion);
            throw excepcion;
        } finally {
            terminarTransaccion();
        }
        
        return pedidosEncontrados;
    }

    public List<Pedido> getPorFechaEntrega(Date fecha) {
        String COLUMN_NAME = "fecha_entrega";
        List<Pedido> pedidosEncontrados = null;
        
        try {
            iniciarTransaccion();
            Criteria criterio = sesion.createCriteria(getTipoClase());
            SimpleExpression restriccion = Restrictions.eq(COLUMN_NAME, fecha);
            pedidosEncontrados = criterio.add(restriccion).list();
        } catch (HibernateException excepcion) {
            manejarExcepcionHibernate(excepcion);
            throw excepcion;
        } finally {
            terminarTransaccion();
        }
        
        return pedidosEncontrados;
    }
     
    @Override
    protected Class getTipoClase() {
        return Pedido.class;
    }
}
