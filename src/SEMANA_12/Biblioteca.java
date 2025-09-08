/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_12;

/**
 *
 * @author User
 */
import java.util.*;

public class Biblioteca {
    // Decidí usar un Map para almacenar los libros por su ISBN
    private final Map<String, Libro> catalogoPorIsbn;

    // También utilicé un Map para registrar usuarios por su ID
    private final Map<String, Usuario> usuariosPorId;

    // Usé un Set para llevar el control de los libros prestados
    private final Set<String> isbnsPrestados;

    // En el constructor inicializo las estructuras de datos que gestionan el catálogo, los usuarios y los préstamos.
    public Biblioteca() {
        catalogoPorIsbn = new HashMap<>();
        usuariosPorId = new HashMap<>();
        isbnsPrestados = new HashSet<>();
    }

    // Este método permite añadir un libro al catálogo, verificando que no esté duplicado.
    public void añadirLibro(Libro libro) {
        if (catalogoPorIsbn.containsKey(libro.getIsbn())) {
            System.out.println("El libro ya existe en el catalogo.");
        } else {
            catalogoPorIsbn.put(libro.getIsbn(), libro);
            System.out.println("Libro añadido: " + libro);
        }
    }

    // Aquí implementé la lógica para quitar un libro del catálogo
    public void quitarLibro(String isbn) {
        if (!catalogoPorIsbn.containsKey(isbn)) {
            System.out.println("El libro no existe en el catalogo.");
        } else if (isbnsPrestados.contains(isbn)) {
            System.out.println("No se puede eliminar el libro porque esta prestado.");
        } else {
            Libro eliminado = catalogoPorIsbn.remove(isbn);
            System.out.println("Libro eliminado: " + eliminado);
        }
    }

    // Este método registra un nuevo usuario, asegurándome de que no esté ya en el sistema.
    public void registrarUsuario(Usuario usuario) {
        if (usuariosPorId.containsKey(usuario.getId())) {
            System.out.println("El usuario ya está registrado.");
        } else {
            usuariosPorId.put(usuario.getId(), usuario);
            System.out.println("Usuario registrado: " + usuario);
        }
    }

    // Aquí implementé la baja de un usuario, verificando que no tenga libros prestados antes de eliminarlo.
    public void darDeBajaUsuario(String idUsuario) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        if (usuario == null) {
            System.out.println("El usuario no está registrado.");
        } else if (!usuario.getIsbnsPrestados().isEmpty()) {
            System.out.println("El usuario tiene libros prestados y no puede ser dado de baja.");
        } else {
            usuariosPorId.remove(idUsuario);
            System.out.println("Usuario dado de baja: " + usuario.getNombre());
        }
    }

    // Este método permite prestar un libro a un usuario, validando que el libro esté disponible y que el usuario exista.
    public void prestarLibro(String isbn, String idUsuario) {
        Libro libro = catalogoPorIsbn.get(isbn);
        Usuario usuario = usuariosPorId.get(idUsuario);

        if (libro == null) {
            System.out.println("El libro no está en el catálogo.");
            return;
        }
        if (usuario == null) {
            System.out.println("El usuario no está registrado.");
            return;
        }
        if (isbnsPrestados.contains(isbn)) {
            System.out.println("El libro ya está prestado.");
            return;
        }

        usuario.prestarLibro(isbn);
        isbnsPrestados.add(isbn);
        System.out.println("Libro '" + libro.getTitulo() + "' prestado a " + usuario.getNombre());
    }

    // Aquí programé la devolución de un libro, asegurándome de que el usuario lo tenga registrado como prestado.
    public void devolverLibro(String isbn, String idUsuario) {
        Usuario usuario = usuariosPorId.get(idUsuario);

        if (usuario == null) {
            System.out.println("El usuario no está registrado.");
            return;
        }
        if (!usuario.getIsbnsPrestados().contains(isbn)) {
            System.out.println("El usuario no tiene ese libro prestado.");
            return;
        }

        usuario.devolverLibro(isbn);
        isbnsPrestados.remove(isbn);
        System.out.println("Libro con ISBN " + isbn + " devuelto por " + usuario.getNombre());
    }

    // Este método permite buscar libros por título, autor o categoría, ignorando mayúsculas/minúsculas.
    public List<Libro> buscarLibros(String criterio, String valor) {
        List<Libro> resultado = new ArrayList<>();
        String val = valor.toLowerCase();

        for (Libro libro : catalogoPorIsbn.values()) {
            switch (criterio.toLowerCase()) {
                case "titulo":
                    if (libro.getTitulo().toLowerCase().contains(val)) resultado.add(libro);
                    break;
                case "autor":
                    if (libro.getAutor().toLowerCase().contains(val)) resultado.add(libro);
                    break;
                case "categoria":
                    if (libro.getCategoria().toLowerCase().contains(val)) resultado.add(libro);
                    break;
                default:
                    System.out.println("Criterio de búsqueda no válido.");
                    return Collections.emptyList();
            }
        }
        return resultado;
    }

    // Finalmente, este método permite listar todos los libros que un usuario tiene prestados.
    public List<Libro> listarPrestados(String idUsuario) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no registrado.");
            return Collections.emptyList();
        }

        List<Libro> prestados = new ArrayList<>();
        for (String isbn : usuario.getIsbnsPrestados()) {
            Libro libro = catalogoPorIsbn.get(isbn);
            if (libro != null) {
                prestados.add(libro);
            }
        }
        return prestados;
    }
}