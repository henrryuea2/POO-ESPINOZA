/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_8;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Dashboard {
    private static final Scanner scanner = new Scanner(System.in); 
    private static final IGestorTareas gestor = new GestorTareas();  // Se declara el gestor de tareas usando la interfaz

    public static void main(String[] args) {
        mostrarBienvenida(); // Llamo al método que imprime un saludo inicial
        mostrarMenu();       // Inicio el menú de opciones interactivo
    }

    /**
     * Muestro un mensaje de bienvenida y el estado actual del sistema.
     */
    private static void mostrarBienvenida() {
        System.out.println("Bienvenido al Gestor de Tareas - Proyecto Java"); // Mensaje de saludo
        System.out.println(" Estado: Proyecto en desarrollo\n");                // Estado actual del sistema
    }

    private static void mostrarMenu() {
        int opcion; // Variable para almacenar la opción del usuario

        do { // Ciclo que se repite mientras el usuario no elija salir
            System.out.println("\n  Menú Principal:"); 
            System.out.println("1. Registrar tarea");  
            System.out.println("2. Ver tareas");       
            System.out.println("0. Salir");            
            System.out.print("Seleccione una opción: "); 

            opcion = scanner.nextInt();     // Captura la opción ingresada
            scanner.nextLine();             

            switch (opcion) { // Estructura de control para ejecutar según la opción elegida
                case 1:
                    System.out.print("nEscribe una tarea: ");     // Solicita descripción de la tarea
                    String desc = scanner.nextLine();               // Captura la descripción
                    gestor.registrarTarea(desc);                    // Registra la tarea usando el gestor
                    break;

                case 2:
                    gestor.mostrarTareas(); // Muestra todas las tareas registradas
                    break;

                case 0:
                    System.out.println(" Saliendo del sistema..."); // Mensaje de cierre
                    break;

                default:
                    System.out.println("❗ Opción no válida."); // Mensaje si el usuario ingresa una opción incorrecta
            }

        } while (opcion != 0); 
    }
    
}
