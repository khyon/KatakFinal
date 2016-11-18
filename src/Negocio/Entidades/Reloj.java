package Negocio.Entidades;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Mario
 */
public class Reloj extends Thread{
    private JLabel lbReloj;

    
    //constructor
    public Reloj(JLabel lbReloj) {
        this.lbReloj = lbReloj;
    }
    
    
    //metodo concreto
    public void run()
    {
        while(true)
        {
            Date horaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("hh:mm:ss");
            lbReloj.setText(formato.format(horaActual));
        
        
            try 
            {
                sleep(1000);    //para que al mostrarlo se vea como pasa segundo a segundo... 1000 milisegundos
            } catch (Exception ex) {
            
            }
        
        }
    }
    
}
