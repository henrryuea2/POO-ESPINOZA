/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_8;
import java.util.ArrayList;
import java.util.List;


public class GestorTareas implements IGestorTareas {
    private List<Tarea> tareas = new ArrayList<>(); // Inicializo una lista donde voy a guardar las tareas registradas

    @Override
    public void registrarTarea(String descripcion) { // Sobrescribo el método de la interfaz para registrar una tarea
        tareas.add(new Tarea(descripcion)); // Creo una nueva tarea y la agrego a la lista
        System.out.println(" Tarea registrada correctamente."); // Muestro un mensaje para confirmar que se registró
    }

    @Override
    public void mostrarTareas() { // Sobrescribo el método para mostrar todas las tareas
        if (tareas.isEmpty()) { // Verifico si la lista de tareas está vacía
            System.out.println(" No hay tareas registradas."); // Si está vacía, muestro un mensaje informando
        } else {
            System.out.println("?Lista de tareas:"); // Si hay tareas, imprimo un encabezado
            tareas.forEach(Tarea::mostrarTarea); // Recorro la lista y llamo al método que imprime cada tarea
        }
    
    } 
}
