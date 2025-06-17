/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SEMANA_2;
import java.util.Scanner; // Importo la clase Scanner para poder leer lo que el usuario escriba
/**
 *
 * @author User
 */
public class Programacion_Tradcional { // Inicio la clase principal llamada "POO_TAREAS"
 
 
    public static void main(String[] args) {
        // Declaro un arreglo con los días de la semana.
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        double[] temperaturas = new double[dias.length];
       // Abro el escáner para empezar a leer lo que el usuario escriba
        Scanner scanner = new Scanner(System.in);
        // Comienzo a recorrer cada uno de los días
        for (int i = 0; i < dias.length; i++) {
            // Le pido al usuario que me diga la temperatura de ese día
            System.out.print("Temperatura del " + dias[i] + ": ");
            // Guardo la temperatura que el usuario ingresó en el arreglo
            temperaturas[i] = scanner.nextDouble();
        }
       // Inicializo una variable
        double suma = 0;
        // Recorro todas las temperaturas que me dieron
        for (double temp : temperaturas) {
            // Voy sumando cada temperatura 
            suma += temp;
        }
     // Calculo el promedio 
        double promedio = suma / temperaturas.length;
        // Imprimo el promedio
        System.out.println("Temperatura promedio: " + promedio);
        scanner.close();
    }
    }
    
