/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Operaciones;

import Negocio.Entidades.GrupoProds;
import Negocio.Entidades.Producto;
import Negocio.Entidades.Venta;
import Negocio.Entidades.Cliente;
import Negocio.Operaciones.AdminClientes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mario
 */
public class Vendedor {
    private final AdminVentas adminVentas;
    private final AdminProd adminProd;
    private final AdminGrupoProd adminGrupoProd;
    public List<GrupoProds> gruposProdsInput;
    public List<GrupoProds> gruposProdsVenta;
    public List<Producto> prodsDisponibles;
    private Venta nuevaVenta = new Venta();
    private double costo;
    private Cliente nuevoCliente;
    
        public Vendedor(){
        adminVentas = new AdminVentas();
        adminGrupoProd = new AdminGrupoProd();
        adminProd = new AdminProd();
        gruposProdsInput = new ArrayList<>();
        gruposProdsVenta = new ArrayList<>();
        nuevaVenta = new Venta();
        prodsDisponibles = adminProd.getListaProd();
        
    }
      
        public void elaborarVenta() {
            this.nuevaVenta = new Venta(
                    nuevoCliente,
                    gruposProdsVenta,
                    getFechaActual()
                    
            );
    }
        
        public void guardarVenta(){
        guardarGruposProds();
        elaborarVenta();
        adminVentas.AgregarVenta(nuevaVenta);
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
            System.out.println(gp.getNombreProd()+"   -   "+gp.getCantidad());
            adminGrupoProd.AgregarGrupoProd(nuevoGrupoProd);
            gruposProdsVenta.add(nuevoGrupoProd);
        }
    }
        
        
        public List<String> getNombresTodosProd(){
            return adminProd.getNombresTodosProd();
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

        public double getCosto() {
            return costo;
        }

        public void setCosto(double costo) {
            this.costo = costo;
        }

    public void setNuevaVenta(Venta nuevaVenta) {
        this.nuevaVenta = nuevaVenta;
    }

    public void setNuevoCliente(Cliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }

    public Venta getNuevaVenta() {
        return nuevaVenta;
    }

    public Cliente getNuevoCliente() {
        return nuevoCliente;
    }
        
        
    
    
    
}
