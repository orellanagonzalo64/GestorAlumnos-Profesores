/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

import java.util.Objects;

public class Alumno extends Persona {
    private String cx;

    /**
     * Constructor
     * @param apellidos apellidos de un alumno
     * @param nombres nombres de un alumno
     * @param dni dni de un alumno
     * @param cx cx de un alumno
     */    
    public Alumno(String apellidos, String nombres, int dni, String cx) {
        super(apellidos, nombres, dni);
        this.cx = cx;
    }

    /**
     * Muestra el cx de un alumno
     * @return String  - cx de un alumno
     */        
    public String verCX() {
        return this.cx;
    }

    /**
     * Asigna el cx a un alumno
     * @param cx cx de un alumno
     */        
    public void asignarCX(String cx) {
        this.cx = cx;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + verDNI();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Alumno other = (Alumno) obj;
            if (!Objects.equals(this.cx, other.cx)) {
                return false;
            }
        }
        return true;

    }
    
    
    
    
    
    
    
    
    
    
}
