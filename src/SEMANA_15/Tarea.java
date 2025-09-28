package SEMANA_15;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Tarea {
    // Declaro una variable privada 
    private String descripcion;

    // Declaro una variable booleana para saber si la tarea está completada o no.
    private boolean completada;

   
    // Constructor para una nueva tarea (por defecto, no completada).
    
    public Tarea(String descripcion) {
        // Cuando creo una nueva tarea, le asigno la descripción que me pasan como parámetro.
        this.descripcion = descripcion;

      
        this.completada = false;
    }

    // Getters y Setters 
    
    // Este método me permite obtener la descripción actual de la tarea.
    public String getDescripcion() {
        return descripcion;
    }

    // Este método me permite cambiar la descripción de la tarea.
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Este método me dice si la tarea está completada o no.
    public boolean isCompletada() {
        return completada;
    }

    // Este método me permite cambiar el estado de completada 
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    
    // Alterna el estado de completado de la tarea
    
    public void toggleCompletada() {
        //  la marco como no completada; si no lo está, la marco como completada.
        this.completada = !this.completada;
    }

   
    @Override
    public String toString() {
        // muestro solo su descripción.
        return descripcion;
    }
}
