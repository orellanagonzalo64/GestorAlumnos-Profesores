/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.controladores;

import gui.interfaces.IControladorAMAlumno;
import static gui.interfaces.IControladorPersonas.TITULO;
import gui.interfaces.IGestorPersonas;
import gui.personas.modelos.Alumno;
import gui.personas.modelos.GestorPersonas;
import gui.personas.modelos.SaveNewItemException;
import gui.personas.vistas.AMAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Tuquina Fernando, Orellana Gonzalo
 */
public class ControladorAMAlumno implements IControladorAMAlumno {

    private AMAlumno ventana;
    private Alumno modificar;
    
    public ControladorAMAlumno(int codigo, Alumno alumnoAModificar) {
        ventana = new AMAlumno(null,true,this);
        this.ventana.setLocationRelativeTo(null);
        this.modificar = alumnoAModificar;
        
        
        if(codigo==0 && alumnoAModificar == null){
            ventana.setTitle("Nuevo alumno");
            ventana.getTitulo().setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
            ventana.getTitulo().setText("Nuevo alumno");
        }
        if(codigo==1){
            ventana.setTitle("Modificar datos de un alumno");
            ventana.getTitulo().setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
            ventana.getTitulo().setText("Modificar alumno");
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
     * 1) Crea un nuevo alumno
     * 2) Modifica un alumno existente
     */
    private void guardar() {
        if (this.modificar == null) {


            if (ventana.getTextFieldApellido().getText().toUpperCase().equals("") || ventana.getTextFieldNombre().getText().toUpperCase().equals("") || ventana.getTextFieldCX().getText().toUpperCase().equals("") || ventana.getTextFieldDNI().getText().isEmpty()) {
                    
               JOptionPane.showMessageDialog(null,"Campos vacios","Alumno", JOptionPane.ERROR_MESSAGE);
            }
  
            
            else{
                
                GestorPersonas gestor = GestorPersonas.instanciar();
                String Apellido = ventana.getTextFieldApellido().getText().toUpperCase();
                String Nombre = ventana.getTextFieldNombre().getText().toUpperCase();
                int DNI = Integer.parseInt(ventana.getTextFieldDNI().getText());
                String CX = ventana.getTextFieldCX().getText().toUpperCase();
                
                String Estado = gestor.nuevoAlumno(Apellido, Nombre, DNI, CX);
                JOptionPane.showMessageDialog(null, Estado);
                this.ventana.dispose();
            }
        
        } else {
            GestorPersonas gestor = GestorPersonas.instanciar();

            

             if (ventana.getTextFieldApellido().getText().equals("") || ventana.getTextFieldNombre().getText().equals("") || ventana.getTextFieldCX().getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Campos vacios","Alumno", JOptionPane.ERROR_MESSAGE);

            }
             else{
                 
            String Apellido = ventana.getTextFieldApellido().getText().toUpperCase();
            String Nombre = ventana.getTextFieldNombre().getText().toUpperCase();
            String CX = ventana.getTextFieldCX().getText().toUpperCase();     
            String resultado = gestor.modificarAlumno(modificar, Apellido, Nombre, CX);
            

            if (!resultado.equals(IGestorPersonas.EXITO_ALUMNOS)) { //no se pudo modificar el alumno
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
        gp.cancelarAlumno();
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
    public void txtCXPresionarTecla(KeyEvent evt) {

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
