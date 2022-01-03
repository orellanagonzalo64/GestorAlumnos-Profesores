/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.controladores;

import gui.interfaces.IControladorAMProfesor;
import static gui.interfaces.IControladorPersonas.TITULO;
import gui.interfaces.IGestorPersonas;
import gui.personas.modelos.Cargo;
import gui.personas.modelos.GestorPersonas;
import gui.personas.modelos.ModeloComboCargo;
import gui.personas.modelos.Profesor;
import gui.personas.modelos.SaveNewItemException;
import gui.personas.vistas.AMProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Tuquina Fernando, Orellana Gonzalo
 */
public class ControladorAMProfesor implements IControladorAMProfesor {
    
    private AMProfesor ventana;
    private Profesor modificar;
    
    public ControladorAMProfesor(int codigo, Profesor profesorAModificar) {
        
        ventana = new AMProfesor(null, true, this);
        this.ventana.setLocationRelativeTo(null);
        ventana.getComboCargo().setModel(new ModeloComboCargo());
        this.modificar = profesorAModificar;
        
        if(codigo==0 && profesorAModificar == null){
            ventana.setTitle("Nuevo profesor");
            ventana.getTitulo().setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
            ventana.getTitulo().setText("Nuevo profesor");
        }
        if(codigo==1){
            ventana.setTitle("Modificar datos de un profesor");
            ventana.getTitulo().setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
            ventana.getTitulo().setText("Modificar profesor");
            ventana.getTextFieldDNI().setEditable(false);
           
        }
        
        
        
        ventana.setVisible(true);
        
    }
    
    /**
     * Método que llama al método guardar al recibir un evento
     * @param evt 
     */
    @Override
    public void btnGuardarClic(ActionEvent evt) {
                this.guardar();
    }
    
    /**
     * Método que permite guardar los datos desde la interfaz gráfica
     * Funciona en dos posibles etapas:
     * 1) Crea un nuevo profesor
     * 2) Modifica un profesor existente
     */
    public void guardar() {

        if (this.modificar == null) {

            if (ventana.getTextFieldApellido().getText().toUpperCase().equals("") || ventana.getTextFieldNombre().getText().toUpperCase().equals("") || ventana.getTextFieldDNI().getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Campos vacios", "Profesor", JOptionPane.ERROR_MESSAGE);
            } else {

                GestorPersonas gestor = GestorPersonas.instanciar();
                String Apellido = ventana.getTextFieldApellido().getText().toUpperCase();
                String Nombre = ventana.getTextFieldNombre().getText().toUpperCase();
                int DNI = Integer.parseInt(ventana.getTextFieldDNI().getText());

                String Estado = gestor.nuevoProfesor(Apellido, Nombre, DNI, (Cargo) ventana.getComboCargo().getSelectedItem());
                JOptionPane.showMessageDialog(null, Estado);
                this.ventana.dispose();

            } 

        } else {

            if (ventana.getTextFieldApellido().getText().toUpperCase().equals("") || ventana.getTextFieldNombre().getText().toUpperCase().equals("") ) {

                JOptionPane.showMessageDialog(null, "Campos vacios", "Profesor", JOptionPane.ERROR_MESSAGE);
            } else {

                GestorPersonas gestor = GestorPersonas.instanciar();

                String Apellido = ventana.getTextFieldApellido().getText().toUpperCase();
                String Nombre = ventana.getTextFieldNombre().getText().toUpperCase();

                String resultado = gestor.modificarProfesor(modificar, Apellido, Nombre, (Cargo) ventana.getComboCargo().getSelectedItem());

                if (!resultado.equals(IGestorPersonas.EXITO_PROFESORES)) { //no se pudo modificar el profesor
                    gestor.cancelarAlumno();
                    JOptionPane.showMessageDialog(null, resultado, TITULO, JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, resultado);
                }
                this.ventana.dispose();
            }
        }
    }

    
    /**
     * Cancela la acción de crear/modificar un alumno y cierra la ventana
     * @param evt 
     */
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        
        IGestorPersonas gp = GestorPersonas.instanciar();
        gp.cancelarProfesor();
        ventana.dispose();
        
    }
    
    /**
     * Control de restricción de caracteres
     * @param evt 
     */
    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {

        char c = evt.getKeyChar();            
        if (!Character.isLetter(c)) { //sólo se aceptan letras, Enter, Del, Backspace y espacio
            switch(c) {
                case KeyEvent.VK_ENTER: 
                     this.guardar();
                     break;
                case KeyEvent.VK_ESCAPE:
                     this.btnCancelarClic(null);
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
    public void txtDocumentoPresionarTecla(KeyEvent evt) {

        char c = evt.getKeyChar();            
        if (!Character.isDigit(c)) { //sólo se aceptan números, Enter, Del, Backspace y espacio
            switch(c) {
                case KeyEvent.VK_ENTER: 
                     this.guardar();
                     break;
                case KeyEvent.VK_ESCAPE:
                     this.btnCancelarClic(null);
                     break;
                case KeyEvent.VK_BACK_SPACE:    
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_SPACE:
                
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Sólo se permiten caracteres numéricos","Caracter inválido",JOptionPane.ERROR_MESSAGE);
                    evt.consume(); //consume el evento para que no sea procesado por la fuente
            }
        }
    }

    /**
     * Control de restricción de caracteres
     * @param evt 
     */
    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {

         char c = evt.getKeyChar();            
        if (!Character.isLetter(c)) { //sólo se aceptan letras, Enter, Del, Backspace y espacio
            switch(c) {
                case KeyEvent.VK_ENTER: 
                     this.guardar();
                     break;
                case KeyEvent.VK_ESCAPE:
                     this.btnCancelarClic(null);
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
