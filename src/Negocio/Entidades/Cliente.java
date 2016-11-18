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
 
    CLASE: {@link Cliente}
    
    AUTOR: Roberto Gil Flores y Mario Lopez Duran

 **********************************************************************/

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    @Column(name = "nombreCliente", nullable = false)
    private String nombreCliente;
    @Column(name = "telefonoCliente", nullable = false)
    private String telefonoCliente;
    @Column(name = "direccionCliente", nullable = false)
    private String direccionCliente;

 
    
//Constructor

    public Cliente(String nombreCliente, String telefonoCliente, String direccionCliente) {
        
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.direccionCliente = direccionCliente;
    }
    
    //Metodos Get

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }
    
    //Metodos Set

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    

    
}
