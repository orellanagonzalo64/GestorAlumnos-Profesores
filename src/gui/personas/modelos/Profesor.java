/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

public class Profesor extends Persona {
    private Cargo cargo;

    /**
     * Constructor
     * @param apellidos apellidos de un profesor
     * @param nombres nombres de un profesor
     * @param dni dni de un profesor
     * @param cargo cargo de un profesor
     */
    public Profesor(String apellidos, String nombres, int dni, Cargo cargo) {
        super(apellidos, nombres, dni);
        this.cargo = cargo;
    }

    /**
     * Muestra el cargo de un profesor
     * @return Cargo  - cargo de un profesor
     */    
    public Cargo verCargo() {
        return this.cargo;
    }

    /**
     * Asigna el cargo a un profesor
     * @param cargo cargo de un profesor
     */    
    public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
