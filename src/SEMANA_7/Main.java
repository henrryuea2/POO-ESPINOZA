/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_7; // Declaro el package donde se encuentra mi clase principal

/**
 *
 * @author User
 */
public class Main { // Defino mi clase principal que contiene el método main
    public static void main(String[] args) { // Defino el método main que es el punto de entrada de mi programa
        System.out.println("=== DEMOSTRACIÓN DE CONSTRUCTORES ===\n"); // Imprimo el título de mi demostración
        
        // Creando instancias usando diferentes constructores
        System.out.println("1. Constructor por defecto:"); // Imprimo el subtítulo para el primer ejemplo
        Estudiante est1 = new Estudiante(); // Creo mi primera instancia usando el constructor por defecto
        est1.mostrarInfo(); // Llamo al método mostrarInfo() para ver los datos del primer estudiante
        
        System.out.println("\n2. Constructor con 1 parámetro:"); // Imprimo el subtítulo para el segundo ejemplo
        Estudiante est2 = new Estudiante("Henry"); // Creo mi segunda instancia pasando solo el nombre
        est2.mostrarInfo(); // Llamo al método mostrarInfo() para ver los datos del segundo estudiante
        
        System.out.println("\n3. Constructor con 2 parámetros:"); // Imprimo el subtítulo para el tercer ejemplo
        Estudiante est3 = new Estudiante("Carlos", "Ingeniería"); // Creo mi tercera instancia pasando nombre y carrera
        est3.mostrarInfo(); // Llamo al método mostrarInfo() para ver los datos del tercer estudiante
        
        System.out.println("\n4. Constructor con 3 parámetros:"); // Imprimo el subtítulo para el cuarto ejemplo
        Estudiante est4 = new Estudiante("María", "Medicina", 22); // Creo mi cuarta instancia pasando todos los parámetros
        est4.mostrarInfo(); // Llamo al método mostrarInfo() para ver los datos del cuarto estudiante
        
      
        
    }
}