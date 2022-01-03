/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.areas.modelos;

import gui.interfaces.IGestorAreas;
import gui.interfaces.IGestorTrabajos;
import gui.trabajos.modelos.GestorTrabajos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorAreas implements IGestorAreas { 
    private final String NOMBRE_ARCHIVO = "./Areas.txt";
    //nombre del archivo con las áreas    
    
    private List<Area> areas = new ArrayList<>();
    private static GestorAreas gestor;
    
    private int ultimaArea;
    //sirve para manejar la tabla tablaAreas
    
    /**
     * Constructor
    */                                            
    private GestorAreas() {    
        this.leerArchivo();
    }
    
    /**
     * Método estático que permite crear una única instancia de GestorAreas
     * @return GestorAreas
    */                                                            
    public static GestorAreas instanciar() {
        if (gestor == null) 
            gestor = new GestorAreas();            
        return gestor;
    } 
    
    /**
     * Crea un nueva área
     * @param nombre nombre del área
     * @return cadena con el resultado de la operación (EXITO | ESCRITURA_ERROR | DUPLICADOS | ERROR)
    */                                                                    
    @Override
    public String nuevaArea(String nombre) {
        if ((nombre == null) || (nombre.trim().isEmpty()))  //nombre del área no nulo y no vacío
            return ERROR; 
        
        Area area = new Area(nombre);
        if (!this.areas.contains(area)) {
            this.areas.add(area); //no admite duplicados
            Collections.sort(this.areas);
            String resultado = this.escribirArchivo();
            if (resultado.equals(ESCRITURA_OK)) {
                this.ultimaArea = this.areas.indexOf(area);
                return EXITO;
            }
            return resultado;
        }
        return DUPLICADOS;            
    }
   
    /**
     * Busca si existe un área con el nombre especificado (total o parcialmente)
     * Si no se especifica un nombre de área, devuelve todas las áreas
     * Este método es necesario para las clases ModeloTablaAreas y ModeloComboAreas
     * @param nombre nombre del área a buscar
     * @return List<Area>  - lista de áreas, ordenadas por nombre, cuyos nombres coincidan con el especificado
    */                                                                           
    @Override
    public List<Area> buscarAreas(String nombre) {        
        if (nombre != null) {
            List<Area> areasBuscadas = new ArrayList<>();
            for(Area area : this.areas) {
                if (area.verNombre().toLowerCase().contains(nombre.toLowerCase()))
                    areasBuscadas.add(area);
            }
            return areasBuscadas;
        }
        return this.areas; //todas las áreas
    }
        
    /**
     * Borra un área siempre y cuando no haya trabajos con la misma
     * @param area área a borrar
     * @return String  - cadena con el resultado de la operación (AREA_CON_TRABAJO | EXITO | ESCRITURA_ERROR)
     */
    @Override
    public String borrarArea(Area area) {
        IGestorTrabajos gt = GestorTrabajos.instanciar();
        if (gt.hayTrabajosConEsteArea(area)) //hay al menos un trabajo con este área
            return AREA_CON_TRABAJO;
        
        this.ultimaArea = this.areas.indexOf(area);
        this.areas.remove(area);
        String resultado = this.escribirArchivo();
        return (resultado.equals(ESCRITURA_OK) ? EXITO : resultado);            
    }            
    
    /**
     * Busca si existe un área que coincida con el nombre especificado
     * Si existe un área con el nombre especificado, la devuelve
     * Si no hay un área con el nombre especicado, devuelve null
     * A este método lo usa la clase GestorTrabajos
     * @param nombre nombre del área a buscar
     * @return Area  - objeto Area cuyo nombre coincida con el nombre especificado, o null
     */
    @Override
    public Area dameArea(String nombre) {
        for(Area area : this.areas) {
            if (area.verNombre().equalsIgnoreCase(nombre.trim()))
                return area;
        }
        return null;
    }

    /**
     * Devuelve la posición de la última área agregada
     * Sirve para manejar la tabla tablaAreas
     * Si cuando se agrega un área se cancela la operación, devuelve - 1
     * Cada vez que se agrega un área, este valor toma la posición del área agregada en el ArrayList
     * @return int  - posición de la última área agregada
     */    
    @Override
    public int verUltimaArea() {
        return this.ultimaArea;
    }

    /**
     * Asigna en -1 la variable que controla la última área agregada
     * Sirve para manejar la tabla tablaAreas
     */    
    @Override
    public void cancelar() {
        this.ultimaArea = -1;
    }
    
    /**
     * Devuelve el orden que ocupa el área en todo el conjunto de áreas
     * Si no existe el área especificada, devuelve -1
     * Este método es necesario para poder seleccionar las áreas a las que pertenece el trabajo en una JList
     * @param area área al cual se le determina el orden
     * @return int  - orden que ocupa el área
     */
    @Override
    public int ordenArea(Area area) {
        return this.areas.indexOf(area);
    }
            
    /**
     * Lee del archivo de texto y carga el ArrayList empleando un try con recursos
     * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
     * Formato del archivo:
     *  nombre 1
     *  nombre 2
     *  nombre 3
     * @return String  - cadena con el resultado de la operacion (ARCHIVO_INEXISTENTE | LECTURA_OK | LECTURA_ERROR)
     */
    private String leerArchivo() {
        File file = new File(NOMBRE_ARCHIVO);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String nombre;
                while((nombre = br.readLine()) != null) {
                    Area area = new Area(nombre);
                    this.areas.add(area);
                }
                return LECTURA_OK;
            }
            catch (IOException ioe) {
                return LECTURA_ERROR;
            }
        }
        return ARCHIVO_INEXISTENTE;
    }                    
    
    /**
     * Escribe en el archivo de texto el ArrayList
     * Formato del archivo:
     *  nombre 1
     *  nombre 2
     *  nombre 3
     * @return String  - cadena con el resultado de la operacion (ESCRITURA_OK | ESCRITURA_ERROR)
     */
    private String escribirArchivo() {
        File file = new File(NOMBRE_ARCHIVO);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {     
            for(Area area : this.areas) {
                bw.write(area.verNombre());
                bw.newLine();
            }            
            return ESCRITURA_OK;
        } 
        catch (IOException ioe) {
            return ESCRITURA_ERROR;            
        }
    }          
}
