/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Operaciones;

import Negocio.Entidades.GrupoProds;
import Negocio.Entidades.Pedido;
import Negocio.Entidades.Producto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author DEMON
 */
public class Pedidor {
    private AdminPedidos adminPedidos;
    private AdminProd adminProd;
    public List<GrupoProds> gruposProdsSeleccionados;
    public List<Producto> prodsDisponibles;
    private Pedido nuevoPedido;

    public Pedidor(){
        adminPedidos = new AdminPedidos();
        adminProd = new AdminProd();
        gruposProdsSeleccionados = new ArrayList<>();
        nuevoPedido = new Pedido();
        prodsDisponibles = adminProd.getListaProd();
        
    }
    
    public void guardarPedido(){
        adminPedidos.insertarPedidoRegistro(nuevoPedido);
    }

    public void setNuevoPedido(String nombreComprador, String direccion, String telefono, Date fechaEntrega) {
        this.nuevoPedido = new Pedido(getFechaActual(), nombreComprador, direccion, telefono, fechaEntrega, gruposProdsSeleccionados);
    }

    private Date getFechaActual() {
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatoFecha.format(fechaActual);
        return fechaActual;
    }

    public List<String> getNombresTodosProd(){
        return adminProd.getNombresTodosProd();
    }
    
    
    
    
    
}
