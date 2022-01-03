/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.controladores;

import gui.interfaces.IControladorAMAlumno;
import gui.interfaces.IControladorAMProfesor;
import gui.interfaces.IControladorPersonas;
import gui.interfaces.IGestorPersonas;
import gui.personas.modelos.Alumno;
import gui.personas.modelos.GestorPersonas;
import gui.personas.modelos.ModeloTablaAlumnos;
import gui.personas.modelos.ModeloTablaProfesores;
import gui.personas.modelos.Persona;
import gui.personas.modelos.Profesor;
import gui.personas.vistas.AMAlumno;
import gui.personas.vistas.AMProfesor;
import gui.personas.vistas.Personas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Orellana
 */
public class ControladorPersonas implements IControladorPersonas {

    private Personas ventana;
    private int alumnoSeleccionado;
    private int profesorSeleccionado;
    
    public ControladorPersonas() {

        GestorPersonas gestor = GestorPersonas.instanciar();
        ventana = new Personas(null, true, this);
        this.ventana.setLocationRelativeTo(null);
        this.configurarTablaProfesores(null);
        this.configurarTablaAlumnos(null);
        gestor.cancelarAlumno();
        ventana.setVisible(true);
        
    }
    
     /**
     * Configura la tabla donde se muestran los alumnos
     */
    private void configurarTablaAlumnos(String nombre){
       JTable tablaAlumno = this.ventana.getTablaAlumnos();
       tablaAlumno.setModel(new ModeloTablaAlumnos(nombre));
       tablaAlumno.setCellSelectionEnabled(true);
       tablaAlumno.getTableHeader().setReorderingAllowed(false);
       tablaAlumno.getTableHeader().setResizingAllowed(false);
       tablaAlumno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
     /**
     * Configura la tabla donde se muestran los profesores
     */
    private void configurarTablaProfesores(String nombre){
       JTable tablaProfesores = this.ventana.getTablaProfesores();
       tablaProfesores.setModel(new ModeloTablaProfesores(nombre));
       tablaProfesores.setCellSelectionEnabled(true);
       tablaProfesores.getTableHeader().setReorderingAllowed(false);
       tablaProfesores.getTableHeader().setResizingAllowed(false);
       tablaProfesores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    /**
     * Método que "abre" la ventana para crear un nuevo profesor
     * @param evt 
     */
    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {

        IControladorAMProfesor ca = new ControladorAMProfesor(0,null);

        AMProfesor ventanita = new AMProfesor(null, true, ca);

    }
    /**
     * Método que abre la ventana para crear un nuevo alumno
     * @param evt 
     */
    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {

        IControladorAMAlumno ca = new ControladorAMAlumno(0,null);

        AMAlumno ventanita = new AMAlumno(null, true, ca);

    }
    
    /**
     * Método para modificar un profesor:
     * Si hay un profesor seleccionado abre la ventana
     * que permite realizar la modificación
     * @param evt 
     */
    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        Profesor profesor = this.obtenerProfesorSeleccionada();        
        if (profesor != null) { //hay seleccionada un profesor
            GestorPersonas ga = GestorPersonas.instanciar();
            int opcion = JOptionPane.showConfirmDialog(null, "Desea modificar el profesor", TITULO, JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) { //se quiere modificar el profesor                      
                IControladorAMProfesor ca = new ControladorAMProfesor(1,profesor);
                AMProfesor ventanita = new AMProfesor(null, true, ca);
            }
            else
                ga.cancelarAlumno();
        }
        else{
            JOptionPane.showMessageDialog(this.ventana, "Debe seleccionar un profesor");
        }
    }
    
    /**
     * Método para modificar un alumno:
     * Si hay un alumno seleccionado abre la ventana
     * que permite realizar la modificación.
     * @param evt 
     */
    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {

        Alumno alumno = this.obtenerAlumnoSeleccionada();        
        if (alumno != null) { //hay seleccionado un alumno
            GestorPersonas ga = GestorPersonas.instanciar();
            int opcion = JOptionPane.showConfirmDialog(null, "Desea modificar el alumno", TITULO, JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) { //se quiere modificar el alumno
                    
                IControladorAMAlumno ca = new ControladorAMAlumno(1,alumno);
                 AMAlumno ventanita = new AMAlumno(null, true, ca);  
            }
            else
                ga.cancelarAlumno();
        }
        else{
            JOptionPane.showMessageDialog(this.ventana, "Debe seleccionar un alumno");
        }
    }
    
    /**
     * Método que permite borrar un profesor:
     * Si hay un profesor seleccionado entonces intenta borrarlo
     * si cumple con las condiciones necesarias.
     * @param evt 
     */
    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {

        Profesor profesor = this.obtenerProfesorSeleccionada();        
        if (profesor != null) { //hay seleccionada un profesor
            GestorPersonas ga = GestorPersonas.instanciar();
            int opcion = JOptionPane.showConfirmDialog(null, "Desea borrar el profesor", TITULO, JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) { //se quiere borrar el profesor               
                String resultado = ga.borrarProfesor(profesor);
                
                if (!resultado.equals(IGestorPersonas.EXITO_PROFESORES)) { //no se pudo borrar el profesor
                    ga.cancelarProfesor();
                    JOptionPane.showMessageDialog(null, resultado, TITULO, JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Profesor borrado con éxito");
                }
            }
            else
                ga.cancelarProfesor();
        }
        else{
            JOptionPane.showMessageDialog(this.ventana, "Debe seleccionar un profesor");
        }
    }
    
    /**
     * Método que permite borrar un alumno:
     * Si hay un alumno seleccionado entonces intenta borrarlo
     * si cumple con las condiciones necesarias.
     * @param evt 
     */
    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {

            Alumno alumno = this.obtenerAlumnoSeleccionada();        
        if (alumno != null) { //hay seleccionada un alumno
            GestorPersonas ga = GestorPersonas.instanciar();
            int opcion = JOptionPane.showConfirmDialog(null, "Desea borrar el alumno", TITULO, JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) { //se quiere borrar el alumno   
                String resultado = ga.borrarAlumno(alumno);    
                if (!resultado.equals(GestorPersonas.EXITO_ALUMNOS)) { //no se pudo borrar el alumno
                    ga.cancelarAlumno();
                    JOptionPane.showMessageDialog(null, resultado, TITULO, JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Alumno borrado con éxito");
                }
            }
            else
                ga.cancelarAlumno();
        }
        else{
            JOptionPane.showMessageDialog(this.ventana, "Debe seleccionar un alumno");
        }
    }
    
    /**
     * Devuelve el alumno de la posición marcada, en caso contrario
     * devuelve null
     * @return Alumno
     */
    private Alumno obtenerAlumnoSeleccionada() {
        JTable tablaAlumnos = this.ventana.getTablaAlumnos();
        if (tablaAlumnos.getSelectedRow() != -1) { //hay un alumno seleccionado
            ModeloTablaAlumnos mta = (ModeloTablaAlumnos) tablaAlumnos.getModel();
            this.alumnoSeleccionado = tablaAlumnos.getSelectedRow();
            return mta.obtenerAlumno(tablaAlumnos.getSelectedRow());
        } else {
            this.alumnoSeleccionado = -1;
            return null;
        }
    }

    /**
     * Devuelve el profesor de la posición marcada, en caso contrario
     * devuelve null
     * @return Alumno
     */
    private Profesor obtenerProfesorSeleccionada() {
        JTable tablaProfesores = this.ventana.getTablaProfesores();
        if (tablaProfesores.getSelectedRow() != -1) { //hay unalumno seleccionado
            ModeloTablaProfesores mtp = (ModeloTablaProfesores)tablaProfesores.getModel();
            this.profesorSeleccionado = tablaProfesores.getSelectedRow();
            return mtp.obtenerProfesor(tablaProfesores.getSelectedRow());
        }
        else {
            this.alumnoSeleccionado = -1;
            return null;
        }
    }
 
    /**
     * Método que cierra la ventana
     * @param evt 
     */
    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventana.dispose();
    }
    
    /**
     * Busca coincidencias de los profesores en la tabla
     * con lo escrito en el campo de texto y luego actualiza
     * la tabla para mostrarlos.
     * @param evt 
     */
    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        String nombre;
        if (this.ventana.getjTextFieldProfesores().getText().trim().isEmpty())
            nombre = null;
        else
        nombre = this.ventana.getjTextFieldProfesores().getText().toUpperCase().trim();

        this.configurarTablaProfesores(nombre);
    
    }    
    
    /**
     * Busca coincidencias de los alumnos en la tabla
     * con lo escrito en el campo de texto y luego actualiza
     * la tabla para mostrarlos.
     * @param evt 
     */
    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        String nombre;
        if (this.ventana.getjTextFieldAlumnos().getText().trim().isEmpty())
            nombre = null;
        else
            nombre= ventana.getjTextFieldAlumnos().getText().toUpperCase().trim(); 
        this.configurarTablaAlumnos(nombre);

    }
    
    /**
     * Cada vez que la ventana foco, vuelve a instanciar el gestor y 
     * reactualiza las tablas.
     * @param evt 
     */
    @Override
    public void ventanaGanaFoco(WindowEvent evt) {
          GestorPersonas gestor = GestorPersonas.instanciar();
          this.configurarTablaAlumnos(null);
          this.configurarTablaProfesores(null);
          try{
            this.ventana.getTablaAlumnos().setRowSelectionInterval(gestor.verUltimoAlumno(), gestor.verUltimoAlumno());
            this.ventana.getTablaProfesores().setRowSelectionInterval(gestor.verUltimoProfesor(), gestor.verUltimoProfesor());
          }
            catch(IllegalArgumentException e){
          }
    }
    
    /**
     * Control de restricción de caracteres
     * @param evt 
     */
    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();            
        if (!Character.isLetter(c)) { //sólo se aceptan letras, Enter, Del, Backspace y espacio
            switch(c) {
                case KeyEvent.VK_ENTER: 
                     this.btnBuscarProfesorClic(null);
                     break;
                case KeyEvent.VK_ESCAPE:
                     this.ventana.getjTextFieldProfesores().setText("");
                     break;
                case KeyEvent.VK_BACK_SPACE:    
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_SPACE:
                
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Sólo se permiten caracteres alfabéticos","Caracter inválido",JOptionPane.ERROR_MESSAGE);
                    evt.consume(); //consume el evento para que no sea procesado por la fuente
            }
        }
    }
    
    /**
     * Control de restricción de caracteres
     * @param evt 
     */
    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {

        char c = evt.getKeyChar();            
        if (!Character.isLetter(c)) { //sólo se aceptan letras, Enter, Del, Backspace y espacio
            switch(c) {
                case KeyEvent.VK_ENTER: 
                     this.btnBuscarAlumnoClic(null);
                     break;
                case KeyEvent.VK_ESCAPE:
                     this.ventana.getjTextFieldAlumnos().setText("");
                     break;
                case KeyEvent.VK_BACK_SPACE:    
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_SPACE:
                
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Sólo se permiten caracteres alfabéticos","Caracter inválido",JOptionPane.ERROR_MESSAGE);
                    evt.consume(); //consume el evento para que no sea procesado por la fuente
            }
        }
    }
    


}
