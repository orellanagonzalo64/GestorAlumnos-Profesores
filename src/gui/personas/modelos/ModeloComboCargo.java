/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Tuquina Fernando, Orellana Gonzalo
 */
public class ModeloComboCargo extends DefaultComboBoxModel {

    /**
     * Constructor
     */
    public ModeloComboCargo() {
        for (Cargo cargo : Cargo.values()) {
            this.addElement(cargo);
        }
    }

    /**
     * Devuelve el cargo seleccionado
     *
     * @return Cargo - cargo seleccionado
     */
    public Cargo obtenerCargo() {
        return (Cargo) this.getSelectedItem();
    }

    /**
     * Selecciona el Cargo especificado
     *
     * @param cargo cargo
     */
    public void seleccionarCargo(Cargo cargo) {
        this.setSelectedItem(cargo);
    }

}
