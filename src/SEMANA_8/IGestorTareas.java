/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_8;

/**
 *
 * @author User
 */
public interface IGestorTareas {
    void registrarTarea(String descripcion); // Especifico que se debe poder registrar una tarea con su descripción
    void mostrarTareas(); // También quiero que se pueda mostrar la lista de tareas registradas
}
