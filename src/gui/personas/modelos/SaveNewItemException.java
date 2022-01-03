/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

/**
 * Excepcion cuando no se puede guardar una nueva persona, sea que ya existe o se haya dejado el campo "Nombre vacio"
 * @author Tuquina Fernando, Orellana Gonzalo
 */
public class SaveNewItemException extends Exception {

    /**
     * Creates a new instance of <code>SaveNewItemException</code> without
     * detail message.
     */
    public SaveNewItemException() {
    }
    public SaveNewItemException(String msg) {
        super(msg);
    }
    
    @Override
    public String getMessage() {
        return super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
