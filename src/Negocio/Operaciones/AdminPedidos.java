/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Operaciones;

import DatosPersistentes.AccesoDatosPedido;
import Negocio.Entidades.Pedido;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DEMON
 */
public class AdminPedidos {
    public final AccesoDatosPedido datosPedido ;

    public AdminPedidos() {
        this.datosPedido = new AccesoDatosPedido();
    }
    
    public void agregarPedidoRegistro(Pedido pedidoNuevo){
        datosPedido.insertar(pedidoNuevo);
    }
    
    public void modificarPedidoRegistro(Pedido pedido){
        datosPedido.sobrescribir(pedido);
    }
    
    public void eliminarPedidoRegistro(Pedido pedido){
        datosPedido.borrar(pedido);
    }
    
    public List<Pedido> getTodosPedidos(){
        return datosPedido.getListaTodos();
    }
    
    public List<Pedido> getPedidosFechaCreacion(Date fechaCreacion){
        return datosPedido.getPorFechaCreacion(fechaCreacion);
    }
    
    public List<Pedido> getPedidosFechaEntrega(Date fechaEntrega){
        return datosPedido.getPorFechaCreacion(fechaEntrega);
    }
}
