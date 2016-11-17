/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Operaciones;

import DatosPersistentes.AccesoDatosClientes;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.GrupoProds;
import Negocio.Entidades.Producto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/********************************************************************** 
 
    CLASE: {@link AdminVentas}
    
    AUTOR: Roberto Gil Flores

 **********************************************************************/
public class AdminVentas {
    
    
    private List<Cliente> ListaClientes; 
    private List<Producto> ListaProductos;
    private List<GrupoProds> ListaConjuntoProductos;
    private AdminProd adminProd; 
    private AdminClientes adminClientes; 
    private Date fechaActual; 
    
    

    public AdminVentas() {
        fechaActual = Date.from(Instant.now());
        ListaProductos = adminProd.getListaProd();
        ListaClientes = adminClientes.getListaClientes();
    }
    
   /*La siguiente rutina (getListaProd()) utiliza para actualizar la 
    lista de productos en caso de que haya ocurrido un cambio en la 
    cantidad de productos mientras se realiza este registro.
    */
    public void getListaProd(){
        ListaProductos.clear();
        ListaProductos = adminProd.getListaProd();
    }
    

     
    public void EliminarConjuntoProd(GrupoProds conjuntoProductos){
        //adminConjuntoProd.editarConjuntoProd(conjuntoProductos);
    }
    
}
