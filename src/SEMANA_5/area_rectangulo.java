/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_5;  // Agrupo mi clase dentro del paquete llamado SEMANA_5

/**
 *
 * @author User
 */
public class area_rectangulo {

    // Método principal: aquí empieza mi programa
    public static void main(String[] args) {

        // Primero, defino las dimensiones del rectángulo
        int base = 6;                      // número entero
        float altura = 4.2f;               // número decimal (flotante)

        // Creo un mensaje para indicar que comienza el proceso
        String mensaje = "Iniciando el calculo del area...";

        // Valido que los datos sean positivos
        boolean esValido = base > 0 && altura > 0;

        // Imprimo el mensaje de inicio
        System.out.println(mensaje);

        // Verifico si los valores son correctos
        if (esValido) {
            // Calculo el área multiplicando base por altura
            float area = base * altura;

            // Muestro los resultados en consola
            System.out.println("Base: " + base);
            System.out.println("Altura: " + altura);
            System.out.println("Area del rectangulo: " + area);
        } else {
            // Si los datos no son válidos, doy un mensaje de error
            System.out.println("Error: La base y la altura deben ser mayores que cero.");
        }
    }
}