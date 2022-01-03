/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tuquina Fernando, Orellana Gonzalo
 */
public class ModeloTablaAlumnos extends AbstractTableModel {
    
    private List<String> nombresColumnas = new ArrayList<>();
    private final GestorPersonas gp = GestorPersonas.instanciar();
    private List<Alumno> alumnos = new ArrayList<>();
    
    public ModeloTablaAlumnos(String buscar){
        
        nombresColumnas.add("Apellido ");
        nombresColumnas.add("Nombre ");
        nombresColumnas.add("DNI ");
        nombresColumnas.add("CX ");
        
        if(buscar == null){
            alumnos = gp.verListaAlumnos();
        }
        else{
            alumnos = gp.buscarAlumnos(buscar);
        }
          
        
    }
    
    
    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        
        Alumno unAlumno = alumnos.get(fila);
        switch (columna) {
            case 0: return unAlumno.verApellidos();
            case 1: return unAlumno.verNombres();
            case 2: return unAlumno.verDNI();
            case 3: return unAlumno.verCX();
        } 
        return false;
    }
    
    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna); //To change body of generated methods, choose Tools | Templates.
    } 
    
    
    public Alumno obtenerAlumno(int fila) {
        return this.alumnos.get(fila);
    }  
    
}
