/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersistentes;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Mario
 */

public class ConectaBD {
   
    Connection conexion = null;
   
   public Connection conectar() {
      try {
           //Cargamos el Driver MySQL
           Class.forName("com.mysql.jdbc.Driver");
           
           //Se establece la conexión a la base de datos
           conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/katakdb", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer una conexion con la BD" + e.getMessage());
        }
        return conexion;
    }
   
}
