/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersistentes;
import Negocio.Entidades.GrupoProds;
/**
 *
 * @author DEMON
 */
public class AccesoDatosGrupoProds extends AccesoDatos<GrupoProds> {

    @Override
    protected Class getTipoClase() {
        return GrupoProds.class;
    }
    
}
