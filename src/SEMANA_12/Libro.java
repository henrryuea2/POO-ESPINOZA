/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_12;

/**
 *
 * @author User
 */
public class Libro {
    // Definí los atributos del libro como constantes (final) porque no quiero que cambien una vez creado el objeto.
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String categoria;

    // Implementé el constructor para inicializar todos los atributos del libro al momento de su creación.
    public Libro(String isbn, String titulo, String autor, String categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Agregué métodos getter para permitir el acceso controlado a cada atributo del libro.
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    // Sobrescribí el método toString para mostrar la información del libro de forma legible y personalizada.
    @Override
    public String toString() {
        return "'" + titulo + "' de " + autor + " (Categoría: " + categoria + ", ISBN: " + isbn + ")";
    }
}
