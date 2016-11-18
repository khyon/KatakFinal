/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Negocio.Entidades.Cliente;
import Negocio.Operaciones.AdminClientes;
import Vista.Paneles.PanelAgregarEditarCliente;
import Vista.Paneles.PanelPrincipalCliente;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Bernardo Espinoza
 */
public class vistaClientes extends javax.swing.JFrame {
    private JPanel panelBase;
    private PanelPrincipalCliente panelPrincipal;
    private PanelAgregarEditarCliente panelAgregarEditar;
    private CardLayout cardLayout;
    private AdminClientes administrador;
    private boolean modoEdicionActivo;
    /**
     * Creates new form vistaCliente
     */
    public vistaClientes() {
        //initComponents();
        administrador=new AdminClientes();
        panelBase=new JPanel();  
        cardLayout=new CardLayout();
        panelBase.setLayout(cardLayout);
                      
        panelPrincipal=new PanelPrincipalCliente();
        panelAgregarEditar=new PanelAgregarEditarCliente();
        
        panelBase.add(panelPrincipal,"1");
        panelBase.add(panelAgregarEditar,"2");
        
        cardLayout.show(panelBase, "1");
        
        add(panelBase);
        ActualizarTabla();
        pack();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        añadirActionListeners();
        modoEdicionActivo=false;
    }
    
    private void añadirActionListeners(){
        panelPrincipal.getBotonAgregar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAgregarEditar.fijarCampoNombre("");
                panelAgregarEditar.fijarCampoDireccion("");
                panelAgregarEditar.fijarCampoTelefono("");
                cardLayout.show(panelBase, "2");
            }
        });
        
        panelPrincipal.getBotonEditar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(algunaFilaSeleccionada()){
                    modoEdicionActivo=true;
                    panelAgregarEditar.fijarCampoNombre(obtenerModeloTabla().getValueAt(obtenerFilaSeleccionada(), 0).toString());
                    panelAgregarEditar.fijarCampoDireccion(obtenerModeloTabla().getValueAt(obtenerFilaSeleccionada(), 1).toString());
                    panelAgregarEditar.fijarCampoTelefono(obtenerModeloTabla().getValueAt(obtenerFilaSeleccionada(), 2).toString());
                    cardLayout.show(panelBase, "2");
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecciona un elemento");
                }
            }
        });
        
        panelPrincipal.getBotonBorrar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(algunaFilaSeleccionada()){
                    String nombre=obtenerModeloTabla().getValueAt(obtenerFilaSeleccionada(), 0).toString();
                    String direccion=obtenerModeloTabla().getValueAt(obtenerFilaSeleccionada(), 1).toString();
                    String telefono=obtenerModeloTabla().getValueAt(obtenerFilaSeleccionada(), 2).toString();
                    
                    administrador.eliminarCliente(new Cliente(nombre,direccion,telefono));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecciona un elemento");
                }
            }
        });
        
        panelAgregarEditar.getBotonGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente nuevoCliente=new Cliente(
                        panelAgregarEditar.obtenerCampoNombre(), 
                        panelAgregarEditar.obtenerCampoTelefono(), 
                        panelAgregarEditar.obtenerCampoDireccion());
                if(modoEdicionActivo){
                    administrador.editarCliente(nuevoCliente);
                }else{
                    administrador.agregarCliente(nuevoCliente);
                }
            }
        });
        
        panelAgregarEditar.getBotonRegresar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelBase,"1");
                ActualizarTabla();
                modoEdicionActivo=false;
            }
        });
    }
    
    private TableModel obtenerModeloTabla(){
        return panelPrincipal.getTablaListaClientes().getModel();
    }
    
    private int obtenerFilaSeleccionada(){
        return panelPrincipal.getTablaListaClientes().getSelectedRow();
    }
    
    private boolean algunaFilaSeleccionada(){
        int NINGUNA_FILA_SELECCIONADA=-1;
        
        return (obtenerFilaSeleccionada()!=NINGUNA_FILA_SELECCIONADA);
    }
    
    public void ActualizarTabla(){
        List<Cliente> listaClientes=administrador.getListaClientes();
        DefaultTableModel modelo=(DefaultTableModel)obtenerModeloTabla();
        modelo.setRowCount(0);
        for(int i=0;i<listaClientes.size();i++){
            modelo.addRow(new Object[]{listaClientes.get(i).getNombreCliente(),
                                       listaClientes.get(i).getTelefonoCliente(),
                                       listaClientes.get(i).getDireccionCliente()});
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
