package SEMANA_8;
import java.util.ArrayList;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Tarea {
  
    private String descripcion;
    // Declaro una variable privada llamada descripcion, donde guardaré el contenido de cada tarea que se cree.

    public Tarea(String descripcion) {
        
        // Creo un constructor: cuando alguien cree una nueva tarea, recibirá una descripción y yo la almacenaré usando this.descripcion.
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        // Defino un método público que devuelve el valor de descripcion.
        return descripcion;
    }

    public void mostrarTarea() {
        System.out.println("️ Tarea registrada: " + descripcion);
    }
}

