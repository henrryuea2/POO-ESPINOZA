/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_12;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Definí los atributos 'id' y 'nombre' como constantes
    private final String id;
    private final String nombre;

    // Declaré una lista para almacenar los ISBN de los libros que el usuario ha prestado.
    
    private final List<String> isbnsPrestados;

    // Implementé el constructor para inicializar el usuario con su ID y nombre
    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.isbnsPrestados = new ArrayList<>();
    }

    // Agregué métodos getter para acceder al ID del usuario.
    public String getId() {
        return id;
    }

    // También incluí un getter para obtener el nombre del usuario.
    public String getNombre() {
        return nombre;
    }

    // Este método permite acceder a la lista de ISBNs que el usuario ha prestado.
    public List<String> getIsbnsPrestados() {
        return isbnsPrestados;
    }

    // Implementé el método 'prestarLibro' para agregar un ISBN a la lista cuando el usuario toma prestado un libro.
    public void prestarLibro(String isbn) {
        isbnsPrestados.add(isbn);
    }

    // Este método permite eliminar un ISBN de la lista cuando el usuario devuelve un libro.
    public void devolverLibro(String isbn) {
        isbnsPrestados.remove(isbn);
    }

    // Sobrescribí el método toString 
    @Override
    public String toString() {
        return "Usuario: " + nombre + " (ID: " + id + ")";
    }
}