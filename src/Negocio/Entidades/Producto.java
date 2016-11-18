/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/********************************************************************** 
 
    CLASE: {@link Producto}
    
    @AUTOR: Roberto Gil Flores y Mario Lopez Duran

 **********************************************************************/
@Entity
@Table (name = "productos")
public class Producto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column(name = "nombreProducto", nullable = false, unique = true)
    private String nombreProducto;
    @Column(name = "precioProducto", nullable = false)
    private double precioProducto;

    //Constructor

    public Producto(int idProducto, String nombreProducto, double precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    //Metodos Set
    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    //Metodos Get

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    
    
    
    
}
