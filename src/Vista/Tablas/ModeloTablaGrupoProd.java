/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Negocio.Entidades.GrupoProds;
import java.util.Arrays;

/**
 *
 * @author DEMON
 */
public class ModeloTablaGrupoProd extends ModeloTabla<GrupoProds>{
    private static final int INDICE_ID = 0;
    private static final int INDICE_NOMBRE_PROD = 1;
    private static final int INDICE_CANTIDAD_GRUPO = 2;
    private static final int INDICE_COSTO_GRUPO = 3;
    private static final String[] TITULOS_COLUMNAS =
    {
        "ID",
        "Nombre Producto",
        "Cantidad",
        "Costo"
    };
    
    public ModeloTablaGrupoProd() {
        super(Arrays.asList(TITULOS_COLUMNAS));
        setClaseFila(GrupoProds.class);
        setModeloEditable(false);
    }
    
    @Override
    public Object getValueAt(int indiceFila, int indiceColumna) {
        GrupoProds grupoProd = getFila(indiceFila);
        
        switch(indiceColumna) {
            case INDICE_ID:
                return grupoProd.getId();
            case INDICE_NOMBRE_PROD:
                return grupoProd.getNombreProd();
            case INDICE_CANTIDAD_GRUPO:
                return grupoProd.getCantidad();
            case INDICE_COSTO_GRUPO:
                return grupoProd.getCostoGrupoProd();
            default:
                return null;
        }
    }  
}

