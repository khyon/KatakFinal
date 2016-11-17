/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/********************************************************************** 
 
    CLASE: {@link ModeloTabla}
    
    AUTOR: Roberto Gil Flores
    
    @param <Entidad> 
    

 **********************************************************************/
public abstract class ModeloTabla<Entidad>  extends AbstractTableModel{
    protected List<Entidad> DatosEntidad;
    protected List<String> NombresColumna;
    protected Class[] clasesColumna;
    protected Boolean[] esEditableColumna;
    private Class claseFila = Object.class;
    private boolean esModeloEditable = true;
    
    public ModeloTabla(List<String> nombresColumna) {
        this(new ArrayList<Entidad>(), nombresColumna);
    }
    
    protected ModeloTabla(List<Entidad> datosModelo, List<String> nombresColumna) {
        setNombresDatosYColumnas(datosModelo, nombresColumna);
    }
    
    public ModeloTabla(
            List<Entidad> datosModelo, 
            List<String> nombresColumna, 
            Class claseFila
    ) {
        setNombresDatosYColumnas(datosModelo, nombresColumna);
        setClaseFila(claseFila);
    }
    
    public void agregarFila(Entidad datosFila) {
        insertarFila(getRowCount(), datosFila);
    }
    
    public void agregarVariasFilas(List<Entidad> filas) {
        filas.stream().forEach((fila) -> {
            agregarFila(fila);
        });
    }
    
    public void insertarFila(int fila, Entidad datosFila) {
        DatosEntidad.add(fila, datosFila);
        fireTableRowsInserted(fila, fila);
    }
    
    public void insertarVariasFilas(int fila, List<Entidad> listaFilas) {
        DatosEntidad.addAll(fila, listaFilas);
        fireTableRowsInserted(fila, fila + listaFilas.size() - 1);
    }
    
    public void removerRangoFilas(int primero, int ultimo) {
        DatosEntidad.subList(primero, ultimo + 1).clear();
        fireTableRowsDeleted(primero, ultimo);
    }
    
    public void RemoverVariasFilas(int... filas) {
        for (int i = filas.length - 1; i >= 0; i--) {
            int fila = filas[i];
            DatosEntidad.remove(fila);
            fireTableRowsDeleted(fila, fila);
        }
    }
    public void removerFila(int fila) {
        DatosEntidad.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }
    
    public Entidad getFila(int fila) {
        return DatosEntidad.get(fila);
    }
    
    public void setClaseColumna(int columna, Class claseColumna) {
        clasesColumna[columna] = claseColumna;
        fireTableRowsUpdated(0, getRowCount() - 1);
    }
    
    public void setColumnaEditable(int columna, boolean esEditable) {
        esEditableColumna[columna] = esEditable ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public void setModeloEditable(boolean esModeloEditable) {
        this.esModeloEditable = esModeloEditable;
    }
    
    @Override
    public Class getColumnClass(int columna) {
        Class claseColumna = null;
        
        if (columna < clasesColumna.length) {
            claseColumna = clasesColumna[columna];
        }
        
        if (claseColumna == null) {
            claseColumna = super.getColumnClass(columna);
        }
        
        return claseColumna;
    }
    
    @Override
    public int getColumnCount() {
        return NombresColumna.size();
    }
    
    @Override
    public String getColumnName(int columna) {
        Object nombreColumna = null;
        
        if (columna < NombresColumna.size()) {
            nombreColumna = NombresColumna.get( columna );
        }
        
        return (nombreColumna == null) ? super.getColumnName(columna) : nombreColumna.toString();
    }
    
    @Override
    public int getRowCount() {
        return DatosEntidad.size();
    }
    
    @Override
    public boolean isCellEditable(int fila, int columna) {
        Boolean isEditable = null;
        
        if (columna < esEditableColumna.length)
            isEditable = esEditableColumna[columna];
        
        return (isEditable == null) ? esModeloEditable : isEditable.booleanValue();
    }
    
    protected void setClaseFila(Class rowClass) {
        this.claseFila = rowClass;
    }
    
    private void setNombresDatosYColumnas(List<Entidad> entityData, List<String> columnNames) {
        this.DatosEntidad = entityData;
        this.NombresColumna = columnNames;
        clasesColumna = new Class[getColumnCount()];
        esEditableColumna = new Boolean[getColumnCount()];
        fireTableStructureChanged();
    }

}
