/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersistentes;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/********************************************************************** 
 
    CLASE: {@link AccesoDatos}
    
    AUTOR: Roberto Gil Flores
    
    @param <Entidad> 
    

 **********************************************************************/

public abstract class AccesoDatos<Entidad> {
    protected Session sesion;
    protected Transaction transaccion;
    
 

    protected void iniciarTransaccion() throws HibernateException {
        sesion = GeneradorSesiones.getSesionAbierta();
        transaccion = sesion.beginTransaction();
    }
    
    protected void terminarTransaccion() {
        sesion.close();
    }

    
    protected void manejarExcepcionHibernate(
            HibernateException excepcionHibernate
    ) throws HibernateException {
        transaccion.rollback();
        throw new HibernateException("No se pudo realizar la transaccion");
    }
    
    protected abstract Class getTipoClase();
    
    public void insertar(Entidad entidad) {
        try {
            iniciarTransaccion();
            sesion.save(entidad);
            transaccion.commit();
        } catch (HibernateException excepcion) {
            manejarExcepcionHibernate(excepcion);
            throw excepcion;
        } finally {
            terminarTransaccion();
        }
    }
    
    public void sobrescribir(Entidad entidad) {
        try {
            iniciarTransaccion();
            sesion.update(entidad);
            transaccion.commit();
        } catch (HibernateException excepcion) {
            manejarExcepcionHibernate(excepcion);
            throw excepcion;
        } finally {
            terminarTransaccion();
        }
    }
    
    public void borrar(Entidad entidad) {
        try {
            iniciarTransaccion();
            sesion.delete(entidad);
            transaccion.commit();
        } catch (HibernateException excepcion) {
            manejarExcepcionHibernate(excepcion);
            throw excepcion;
        } finally {
            terminarTransaccion();
        }
    }
    
    public Entidad getPorID(int id) {
        Entidad registroExistente = null;
       
        try {
            iniciarTransaccion();
            registroExistente = (Entidad) sesion.get(getTipoClase(), id);
        } catch (HibernateException excepcion) {
            manejarExcepcionHibernate(excepcion);
            throw excepcion;
        } finally {
            terminarTransaccion();
        }
        
        return registroExistente;
    }
    
    public List<Entidad> getListaTodos() {
        List<Entidad> registrosExistentes = null;
        
        try {
            iniciarTransaccion();
            Criteria criterio = sesion.createCriteria(getTipoClase());
            registrosExistentes = criterio.list();
        } finally {
            terminarTransaccion();
        }
        
        return registrosExistentes;
    }
}
