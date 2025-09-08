/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_12;

/**
 *
 * @author User
 */
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Primero creé una instancia de la clase Biblioteca para gestionar libros y usuarios.
        Biblioteca biblioteca = new Biblioteca();

        // Luego añadí dos libros al catálogo, creando objetos Libro con sus respectivos datos.
        Libro libro1 = new Libro("111", "Sombras del Horizonte", "Karen Velastegui", "Literatura");
        Libro libro2 = new Libro("222", "El Misterio del Bosque Azul", "Laura Méndez", "Literatura Infantil");

        // Usé el método añadirLibro para registrar estos libros en la biblioteca.
        biblioteca.añadirLibro(libro1);
        biblioteca.añadirLibro(libro2);

        // Después registré dos usuarios creando objetos Usuario con su ID y nombre.
        Usuario usuario1 = new Usuario("U01", "Henry Espinoza");
        Usuario usuario2 = new Usuario("U02", "Juan Bravo");

        // Utilicé el método registrarUsuario para agregarlos al sistema.
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        // Presté el libro con ISBN "111" a Henry (ID: U01), usando el método prestarLibro.
        biblioteca.prestarLibro("111", "U01");

        // Consulté qué libros tiene prestados Henry, y los imprimí en consola.
        List<Libro> prestados = biblioteca.listarPrestados("U01");
        System.out.println("Libros prestados a Henry:");
        for (Libro libro : prestados) {
            System.out.println(libro);
        }

        // Busqué libros por autor usando el criterio "karen", y mostré los resultados.
        List<Libro> encontrados = biblioteca.buscarLibros("autor", "karen");
        System.out.println("Libros encontrados por autor 'karen':");
        for (Libro libro : encontrados) {
            System.out.println(libro);
        }

        // Henry devolvió el libro que tenía prestado, así que llamé al método devolverLibro.
        biblioteca.devolverLibro("111", "U01");

        // Finalmente, como Henry ya no tiene libros prestados, lo di de baja del sistema.
        biblioteca.darDeBajaUsuario("U01");
    }
}


