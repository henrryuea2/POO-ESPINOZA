/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author User
 */
// estoy definiendo mi clase principal para manejar archivos.
public class ControladorArchivos {
     public void escribirEnArchivo(String rutaArchivo, String contenido) throws IOException {
        // Uso un 'try-with-resources' para asegurar que el escritor se cierre automáticamente.
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
             // Escribo la cadena de texto en el archivo.
             writer.write(contenido);
             // Muestro un mensaje de confirmación al usuario.
            System.out.println("Contenido escrito en '" + rutaArchivo + "' exitosamente.");
        }
    }

    public String leerDeArchivo(String rutaArchivo) throws IOException {
        // Uso un StringBuilder para construir el contenido leído de manera eficiente
        StringBuilder contenido = new StringBuilder();
        // Utilizo 'try-with-resources' para garantizar que el lector de archivo se cierre.
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea; // Declaro una variable para almacenar cada línea leída.
            // Leo línea por línea hasta que no haya más contenido.
            while ((linea = reader.readLine()) != null) {
                // Añado la línea leída y un salto de línea al StringBuilder.
                contenido.append(linea).append("\n");
            }
            // Convierto el StringBuilder a un String y lo devuelvo.
            return contenido.toString();
        }
    }
// Verifico si un archivo no está vacío.
    public void validarNoVacio(String rutaArchivo) throws ArchivoVacioExcepcion, IOException {
        // Creo un objeto File para acceder a las propiedades del archivo.
        File archivo = new File(rutaArchivo);
        // Si el archivo no existe o su tamaño es cero, considero que está vacío.
        if (!archivo.exists() || archivo.length() == 0) {
            // Lanzo mi excepción personalizada indicando que el archivo no tiene contenido.
            throw new ArchivoVacioExcepcion("El archivo '" + rutaArchivo + "' esta vacio o no existe.");
        }
        // Muestro un mensaje si el archivo tiene contenido.
        System.out.println("El archivo '" + rutaArchivo + "' no esta vacio.");
    }
}
