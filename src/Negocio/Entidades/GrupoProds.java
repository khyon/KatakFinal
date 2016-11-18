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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/********************************************************************** 
 
    CLASE: {@link GrupoProds}
    
    AUTOR: Roberto Gil Flores

 **********************************************************************/
@Entity 
public class GrupoProds implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ManyToOne(optional = false)
    private Producto prod;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Column(name = "costo", nullable = false)
    private double costoGrupo;
    
    public GrupoProds(){
        
    }
    
    public GrupoProds(
            Producto prod,
            int cantidad
    )  {
        this.prod = prod;
        this.cantidad = cantidad;
        this.costoGrupo = getCalculoCostoGrupo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getNombreProd(){
        return prod.getNombre();
    }

    public double getCostoGrupoProd() {
        return costoGrupo;
    }

    public void setCostoGrupoProd(double costoGrupoProd) {
        this.costoGrupo = costoGrupoProd;
    }
    
    public void calcularCostoGrupo(){
        this.costoGrupo = getCalculoCostoGrupo();
    }
    
    public double getCalculoCostoGrupo(){
        return (cantidad * prod.getPrecio());
    }
    
}
