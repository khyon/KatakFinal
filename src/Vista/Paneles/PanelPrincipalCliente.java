/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Bernardo Espinoza
 */
public class PanelPrincipalCliente extends JPanel{
    private javax.swing.JScrollPane AdminClientesScrollPanel;
    private javax.swing.JButton BotonBorrar;
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JTable TablaListaClientes;
    private javax.swing.JScrollPane patientListScrollPane;
    
    public PanelPrincipalCliente(){
        BotonAgregar = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        BotonBorrar = new javax.swing.JButton();
        BotonRegresar = new javax.swing.JButton();
        AdminClientesScrollPanel = new javax.swing.JScrollPane();
        TablaListaClientes = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Administrar Clientes"));

        BotonAgregar.setText("Agregar");

        BotonEditar.setText("Editar");

        BotonBorrar.setText("Borrar");
        
        BotonRegresar.setText("Regresar");
        
        TablaListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nombre", "Direccion", "Telefono"
            }
        ));

        AdminClientesScrollPanel.setViewportView(TablaListaClientes);
        if (TablaListaClientes.getColumnModel().getColumnCount() > 0) {
            TablaListaClientes.getColumnModel().getColumn(0).setHeaderValue("Nombre");
            TablaListaClientes.getColumnModel().getColumn(1).setHeaderValue("Direccion");
            TablaListaClientes.getColumnModel().getColumn(2).setHeaderValue("Telefono");
        }

        javax.swing.GroupLayout AdminClientesPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(AdminClientesPanelLayout);
        AdminClientesPanelLayout.setHorizontalGroup(AdminClientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminClientesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminClientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminClientesScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdminClientesPanelLayout.createSequentialGroup()
                        .addComponent(BotonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonBorrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AdminClientesPanelLayout.setVerticalGroup(AdminClientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminClientesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AdminClientesScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(AdminClientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAgregar)
                    .addComponent(BotonEditar)
                    .addComponent(BotonBorrar))
                .addContainerGap())
        );
    }

    public JButton getBotonBorrar() {
        return BotonBorrar;
    }

    public JButton getBotonAgregar() {
        return BotonAgregar;
    }

    public JButton getBotonEditar() {
        return BotonEditar;
    }

    public JTable getTablaListaClientes() {
        return TablaListaClientes;
    }
}
