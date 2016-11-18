
import DatosPersistentes.AccesoDatosClientes;
import DatosPersistentes.AccesoDatosGrupoProds;
import DatosPersistentes.AccesoDatosProd;
import DatosPersistentes.AccesoDatosVenta;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.GrupoProds;
import Negocio.Entidades.Producto;
import Negocio.Entidades.Venta;
import Negocio.Operaciones.AdminClientes;
import Negocio.Operaciones.AdminGrupoProd;
import Negocio.Operaciones.AdminProd;
import Negocio.Operaciones.AdminVentas;
import Vista.MenuPrincipal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DEMON
 */
public class ClasePruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatoFecha.format(fechaActual);
        Cliente hGil = new Cliente("Hector Gil", "9999273285", "Calle 76 Las Americas");
        Cliente dGil = new Cliente("Daniel Gil", "test", "Test2");
       
        Producto ch200g = new Producto(1,"Charritos 200g",9);
       
        List<GrupoProds> prodsVendidos = new ArrayList<>();
//        
//        AdminClientes ac = new  AdminClientes();
//        ac.agregarCliente(dGil);
//        ac.agregarCliente(hGil);

        
        AdminProd ap = new AdminProd();
        ap.AgregarProd(ch200g);
        
        
//        List<Cliente> busqueda1 = ac.getListaClientesPorNombre("Roberto Gil");
//        System.out.println("Busqueda1");
//        for(Cliente c:busqueda1){
//            System.out.println(c.getNombre());
//        }
//        
//        List<Cliente> busqueda2 = ac.getListaClientesPorNombre("Hector Gil");
//        System.out.println("Busqueda2");
//        for(Cliente c:busqueda2){
//            System.out.println(c.getNombre());
//            System.out.println(c.getTelefono());
//        }
//        
        
//        List<Producto> test = ap.getListaProd();

    System.exit(0);
    }
    
}
