/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_2;
import java.util.Scanner; // Importo Scanner para poder leer lo que el usuario escriba
/**
 *
 * @author User
 */
public class Programacion_Objetos { // Declaro mi clase principal "Programacion_Objetos"
     public static void main(String[] args) {
        Semana semana = new Semana(); // Creo un nuevo objeto llamado "semana" que representa mi semana
        semana.pedirTemperaturas();// Le pido a ese objeto que me ayude a recoger las temperaturas del usuario
        semana.mostrarPromedio();// Luego le digo que me muestre el promedio de esas temperaturas
    }
}
class Semana { // Defino una clase llamada "Semana"
    // Aquí tengo guardados los nombres de los días de la semana
   
    private final String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    // Creo un arreglo para guardar las temperaturas, uno por cada día
    private final double[] temperaturas = new double[dias.length];

    public void pedirTemperaturas() { // Método que uso para pedirle al usuario las temperaturas
        Scanner scanner = new Scanner(System.in);  //Leo los datos
        // Recorro cada día de la semana y le pido al usuario su temperatura correspondiente
        for (int i = 0; i < dias.length; i++) {
            System.out.print("Temperatura del " + dias[i] + ": ");
            temperaturas[i] = scanner.nextDouble(); // Guardo la temperatura que el usuario me da
        }
        scanner.close();
    }

    public void mostrarPromedio() { // Método que uso para calcular y mostrar el promedio
        double suma = 0; // Inicio una suma en cero
        // Recorro todas las temperaturas que guardé
        for (double temp : temperaturas) {
            suma += temp; // Voy sumando
        }
        double promedio = suma / temperaturas.length; // Divido la suma por 7
        System.out.println("Temperatura promedio: " + promedio); 
    }
}
