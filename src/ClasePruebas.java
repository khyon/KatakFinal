
import DatosPersistentes.AccesoDatosClientes;
import DatosPersistentes.AccesoDatosGrupoProds;
import DatosPersistentes.AccesoDatosProd;
import DatosPersistentes.AccesoDatosVenta;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.GrupoProds;
import Negocio.Entidades.Producto;
import Negocio.Entidades.Venta;
import Negocio.Operaciones.AdminProd;
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
        DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        formatoFecha.format(fechaActual);
        Cliente rGil = new Cliente("Roberto Gil", "9999979832", "Calle 76 Las Americas");
        Cliente dGil = new Cliente("Daniel Gil", "999999999", "Calle 76 Las Americas");
       
        Producto ch500g = new Producto("Charritos 500g", 5);
        
        GrupoProds paqueteGil = new GrupoProds(ch500g, 300);
       
        List<GrupoProds> prodsVendidos = new ArrayList<>();
        prodsVendidos.add(paqueteGil);
        
        Venta v1 = new Venta(rGil, prodsVendidos, fechaActual);
        v1.calcularCostoTotal();
        
        AccesoDatosClientes adc = new AccesoDatosClientes();
        adc.insertar(dGil);
        adc.insertar(rGil);
        
        AdminProd ap = new AdminProd();
        ap.AgregarProd(ch500g);
        
        AccesoDatosGrupoProds adgp = new AccesoDatosGrupoProds();
        adgp.borrar(paqueteGil);
        
        AccesoDatosVenta adv = new AccesoDatosVenta();
        adv.insertar(v1);
        
        List<Cliente> busqueda1 = adc.getPorNombre("RobertoGil");
        System.out.println("Busqueda1");
        busqueda1.add(dGil);
        for(Cliente c:busqueda1){
            System.out.println(c.getNombre());
        }
        
        List<Cliente> busqueda2 = adc.getPorNombre("Roberto Gil");
        System.out.println("Busqueda2");
        for(Cliente c:busqueda2){
            System.out.println(c.getNombre());
            System.out.println(c.getTelefono());
        }
        
        
        List<Producto> test = ap.getListaProd();
       MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);

//        System.exit(0);
    }
    
}
