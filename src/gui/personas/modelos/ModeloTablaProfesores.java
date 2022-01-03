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
public class ModeloTablaProfesores extends AbstractTableModel {

    private List<String> nombresColumnas = new ArrayList<>();
    private final GestorPersonas gp = GestorPersonas.instanciar();
    private List<Profesor> profesores;

    public ModeloTablaProfesores(String buscar) {

        nombresColumnas.add("Apellido ");
        nombresColumnas.add("Nombre ");
        nombresColumnas.add("DNI ");
        nombresColumnas.add("Cargo ");
        
        if(buscar == null){
            profesores = gp.verListaProfesores();
        }
        else{
            profesores = gp.buscarProfesores(buscar);
        }
        
    }

    @Override
    public int getRowCount() {
        return profesores.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int fila, int columna) {

        Profesor unProfesor = profesores.get(fila);
        switch (columna) {
            case 0:
                return unProfesor.verApellidos();
            case 1:
                return unProfesor.verNombres();
            case 2:
                return unProfesor.verDNI();
            case 3:
                return unProfesor.verCargo().name().toUpperCase();
        }
        return false;
    }
   
    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
    
     public Profesor obtenerProfesor(int fila) {
        return this.profesores.get(fila);
    } 
    

}
