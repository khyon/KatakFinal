/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Operaciones;

import DatosPersistentes.AccesoDatosGrupoProds;
import Negocio.Entidades.GrupoProds;
import java.util.List;

/**
 *
 * @author DEMON
 */
public class AdminGrupoProd {
    private AccesoDatosGrupoProds datosGrupoProds;
    
    public AdminGrupoProd(){
        datosGrupoProds = new AccesoDatosGrupoProds();
    }
    
public void AgregarGrupoProd(GrupoProds grupoProds){
        datosGrupoProds.insertar(grupoProds);
    }
    
    public void EditarGrupoProd(GrupoProds grupoProds){
        datosGrupoProds.sobrescribir(grupoProds);
    }
    
    public void BorrarGrupoProd(GrupoProds grupoProds){
        datosGrupoProds.borrar(grupoProds);
    }
    
    public GrupoProds getGrupoProdPorID(int id) {
        return datosGrupoProds.getPorID(id);
    }
    
    public List<GrupoProds> getListaGrupoProds() {
        return datosGrupoProds.getListaTodos();
    }
}