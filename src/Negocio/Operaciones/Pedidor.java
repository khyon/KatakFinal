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
    private AdminGrupoProd adminGrupoProd;
    private String nombreComprador;
    private String direccion; 
    private String telefono;
    private Date fechaEntrega ;
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
    
    

    public void setNuevoPedido() {
        guardarGruposProds(getGruposProdsSeleccionados());
        this.nuevoPedido = new Pedido(
                getFechaActual(), 
                getNombreComprador(), 
                getDireccion(), 
                getTelefono(), 
                getFechaEntrega(), 
                getGruposProdsSeleccionados());
    }
    
    public void guardarPedido(){
        adminPedidos.insertarPedidoRegistro(nuevoPedido);
    }
    private Date getFechaActual() {
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatoFecha.format(fechaActual);
        return fechaActual;
    }

    private void guardarGruposProds(List<GrupoProds> ListaGrupoProd){
        ListaGrupoProd.stream().forEach((grupoProds) -> {
            adminGrupoProd.AgregarGrupoProd(grupoProds);
        });
    }
    
    public List<String> getNombresTodosProd(){
        return adminProd.getNombresTodosProd();
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<GrupoProds> getGruposProdsSeleccionados() {
        return gruposProdsSeleccionados;
    }

    public void setGruposProdsSeleccionados(List<GrupoProds> gruposProdsSeleccionados) {
        this.gruposProdsSeleccionados = gruposProdsSeleccionados;
    }

}
