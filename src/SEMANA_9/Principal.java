/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_9;

/**
 *
 * @author User
 */
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        ControladorArchivos controlador = new ControladorArchivos();
        String archivoTexto = "mi_documento.txt";
        String archivoVacio = "documento_vacio.txt";

        // Caso 1: Escribir, leer y validar un archivo con contenido
        System.out.println("--- PRUEBA CON ARCHIVO CON CONTENIDO ---");
        try {
            controlador.escribirEnArchivo(archivoTexto, "Este es el contenido de prueba.");
            String contenidoLeido = controlador.leerDeArchivo(archivoTexto);
            System.out.println("Contenido leido:\n" + contenidoLeido);
            controlador.validarNoVacio(archivoTexto);
        } catch (ArchivoVacioExcepcion e) {
            System.err.println("Excepcion capturada: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }

        System.out.println("\n-----------------------------------------");

        // Caso 2: Crear un archivo vacío y validar (caso de error)
        System.out.println("--- PRUEBA CON ARCHIVO VACIO ---");
        try {
            controlador.escribirEnArchivo(archivoVacio, "");
            controlador.validarNoVacio(archivoVacio);
        } catch (ArchivoVacioExcepcion e) {
            System.err.println("Excepcion capturada: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S al crear o validar: " + e.getMessage());
        }
    }
}