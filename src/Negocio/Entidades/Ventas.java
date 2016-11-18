/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Entidades;

/**
 *
 * @author Mario
 */

public class Ventas{
    private int idVenta;    //folio
    private String fechaDeVenta;
    private String nombreCliente;
    private String direccionCliente;
    private double precioVenta;
    private String detallesVenta;

    
    //Constuctor

    public Ventas(int idVenta, String fechaDeVenta, 
                  String nombreCliente, 
                  String direccionCliente, 
                  double precioVenta, 
                  String detallesVenta) {
        this.idVenta = idVenta;
        this.fechaDeVenta = fechaDeVenta;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.precioVenta = precioVenta;
        this.detallesVenta = detallesVenta;
    }
    public int getIdVenta() {
        return idVenta;
    }

    public String getFechaDeVenta() {
        return fechaDeVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDireccionCliente() {    
        return direccionCliente;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    //Metodos get
    public String getDetallesVenta() {
        return detallesVenta;
    }

    //Precio de la Venta
    public double obtenerMontoPago() {
        return getPrecioVenta();
    }
 

}
