/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Bernardo Espinoza
 */
public class PanelAgregarEditarCliente extends javax.swing.JPanel{
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelDireccion;
    private javax.swing.JLabel LabelTelefono;
    private javax.swing.JTextField NombreTextField;
    private javax.swing.JTextField DireccionTextField;
    private javax.swing.JTextField TelefonoTextField;

    public PanelAgregarEditarCliente() {
        LabelNombre = new javax.swing.JLabel();
        LabelDireccion = new javax.swing.JLabel();
        LabelTelefono = new javax.swing.JLabel();
        DireccionTextField = new javax.swing.JTextField();
        TelefonoTextField = new javax.swing.JTextField();
        NombreTextField = new javax.swing.JTextField();
        BotonGuardar = new javax.swing.JButton();
        BotonRegresar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        LabelNombre.setText("Nombre");

        LabelDireccion.setText("Dirección");

        LabelTelefono.setText("Telefono");

        BotonGuardar.setText("Guardar");
        
        BotonRegresar.setText("Regresar");

        javax.swing.GroupLayout DatosClientePanelLayout = new javax.swing.GroupLayout(this);
        setLayout(DatosClientePanelLayout);
        DatosClientePanelLayout.setHorizontalGroup(DatosClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosClientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DatosClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosClientePanelLayout.createSequentialGroup()
                        .addComponent(LabelDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DireccionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                    .addGroup(DatosClientePanelLayout.createSequentialGroup()
                        .addComponent(LabelTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TelefonoTextField))
                    .addGroup(DatosClientePanelLayout.createSequentialGroup()
                        .addComponent(LabelNombre)
                        .addGap(9, 9, 9)
                        .addComponent(NombreTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosClientePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotonGuardar)
                        .addGap(31, 31, 31)
                        .addComponent(BotonRegresar)))
                .addContainerGap())
        );
        DatosClientePanelLayout.setVerticalGroup(DatosClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosClientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DatosClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombre)
                    .addComponent(NombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DatosClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDireccion)
                    .addComponent(DireccionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DatosClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTelefono)
                    .addComponent(TelefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(DatosClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonGuardar)
                    .addComponent(BotonRegresar))
                .addContainerGap())
        );
    }

    public JButton getBotonRegresar() {
        return BotonRegresar;
    }

    public JButton getBotonGuardar() {
        return BotonGuardar;
    }
    
    public String obtenerCampoNombre(){
        return NombreTextField.getText();
    }
    
    public String obtenerCampoDireccion(){
        return DireccionTextField.getText();
    }
    
    public String obtenerCampoTelefono(){
        return TelefonoTextField.getText();
    }
    
    public void fijarCampoDireccion(String direccion){
        DireccionTextField.setText(direccion);
    }
    
    public void fijarCampoNombre(String nombre){
        NombreTextField.setText(nombre);
    }
    
    public void fijarCampoTelefono(String telefono){
        TelefonoTextField.setText(telefono);
    }
}
