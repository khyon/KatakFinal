/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersistentes;

import Negocio.Entidades.Cliente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author DEMON
 */
public class AccesoDatosClientes extends AccesoDatos<Cliente>  {


    public List<Cliente> getPorNombre(String inputNombre) {
        String NOMBRE_COLUMNA = "nombre";
        List<Cliente> clienteExistente = null;
        
        try {
            iniciarTransaccion();
            Query query = sesion.createSQLQuery(
                    SentenciaBusquedaNombre(NOMBRE_COLUMNA, inputNombre)
            ).addEntity(getTipoClase()
                    );
            clienteExistente = query.list();
        } catch (HibernateException exception) {
            manejarExcepcionHibernate(exception);
            throw exception;
        } finally{
            terminarTransaccion();
        }
        return clienteExistente;
    }

    private String SentenciaBusquedaNombre(String NOMBRE_COLUMNA, String inputNombre) {
        String SentenciaBusqueda = "SELECT * FROM clientes WHERE " 
                + NOMBRE_COLUMNA + " REGEXP"
                + "'^" + inputNombre + "'";
        return SentenciaBusqueda;
    }
    
    @Override
    protected Class getTipoClase() {
        return Cliente.class;
    }
    
}
