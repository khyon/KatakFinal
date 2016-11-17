/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersistentes;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author DEMON
 */
public class GeneradorSesiones {
    private static final SessionFactory FabricadorSesion;
    
    static {
        try {
            FabricadorSesion = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch(HibernateException excepcionHibernate) {
            System.err.println(
                    "Ocurrió un error en la inicialización de la SesionFactory: " + 
                            excepcionHibernate);
            throw new ExceptionInInitializerError(excepcionHibernate);
        }
    }
    
    public static SessionFactory getFabricadorSesion() {
        return FabricadorSesion;
    }
    
    public static Session getSesionAbierta(){
        return FabricadorSesion.openSession();
    }
}
