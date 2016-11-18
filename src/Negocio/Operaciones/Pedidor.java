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
    private final AdminPedidos adminPedidos;
    private final AdminProd adminProd;
    private final AdminGrupoProd adminGrupoProd;
    private String nombreComprador;
    private String direccion; 
    private String telefono;
    private String hora;
    private Date fechaEntrega ;
    public List<GrupoProds> gruposProdsInput;
    public List<GrupoProds> gruposProdsPedido;
    public List<Producto> prodsDisponibles;
    private Pedido nuevoPedido = new Pedido();
    private double costo;
    private boolean ingresoTelefono = false;
    
           

    public Pedidor(){
        adminPedidos = new AdminPedidos();
        adminGrupoProd = new AdminGrupoProd();
        adminProd = new AdminProd();
        gruposProdsInput = new ArrayList<>();
        gruposProdsPedido = new ArrayList<>();
        nuevoPedido = new Pedido();
        prodsDisponibles = adminProd.getListaProd();
        
    }
    
    

    public void construirPedido() {
        if(ingresoTelefono){
            this.nuevoPedido = new Pedido(
                    getFechaActual(), 
                    nombreComprador, 
                    direccion, 
                    telefono, 
                    fechaEntrega, 
                    gruposProdsPedido, 
                    hora,
                    costo
            );   
        }else{
            this.nuevoPedido = new Pedido(
                    getFechaActual(), 
                    nombreComprador, 
                    direccion, 
                    fechaEntrega, 
                    gruposProdsPedido, 
                    hora,
                    costo
            );
        }
    }
    
    public void guardarPedido(){
        guardarGruposProds();
        construirPedido();
        adminPedidos.agregarPedidoRegistro(nuevoPedido);
    }
    private Date getFechaActual() {
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatoFecha.format(fechaActual);
        return fechaActual;
    }

    private void guardarGruposProds(){
        for(GrupoProds gp : gruposProdsInput){
            GrupoProds nuevoGrupoProd = new GrupoProds(
                    gp.getProd(), 
                    gp.getCantidad()
            );
            adminGrupoProd.AgregarGrupoProd(nuevoGrupoProd);
            gruposProdsPedido.add(nuevoGrupoProd);
        }
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
        ingresoTelefono = true;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<GrupoProds> getGruposProdsSeleccionados() {
        return gruposProdsInput;
    }

    public void setGruposProdsSeleccionados(List<GrupoProds> gruposProdsSeleccionados) {
        this.gruposProdsInput = gruposProdsSeleccionados;       
    }
    
    public Producto getProdPorNombre(String nombreProd){
        return adminProd.getProdPorNombre(nombreProd);
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
