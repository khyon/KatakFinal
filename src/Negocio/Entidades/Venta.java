/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Entidades;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
/********************************************************************** 
 
    CLASE: {@link Venta}
    
    @AUTOR: Roberto Gil Flores

 **********************************************************************/
@Entity 
@Table (name = "ventas") 
public class Venta implements Serializable{
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @OneToOne(optional = false)
    private Cliente cliente;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GrupoProds> prodsVendidos;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column (name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;
    @Column (name = "costo", nullable = false)
    private double costoTotal;
    
    public Venta(){
        
    };

    public Venta(
            Cliente cliente, 
            List<GrupoProds> prodsVendidos, 
            Date fechaCreacion
    ) {
        this.cliente = cliente;
        this.prodsVendidos = prodsVendidos;
        this.fechaCreacion = fechaCreacion;
        this.costoTotal = getCostoTotal();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
   
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<GrupoProds> getProdsVendidos() {
        return prodsVendidos;
    }

    public void setProdsVendidos(List<GrupoProds> prodsVendidos) {
        this.prodsVendidos = prodsVendidos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getCostoTotal() {
        calcularCostoTotal();
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getNombreProdVendido(GrupoProds prodVendido){
        return prodVendido.getNombreProd();
    }
    
    public String getNombreCliente(){
        return cliente.getNombreCliente();
    }
    
    public void calcularCostoTotal(){
        for(GrupoProds grupoActual: prodsVendidos ){
            costoTotal =+ grupoActual.getCostoGrupoProd();
        }
        
    }

}
