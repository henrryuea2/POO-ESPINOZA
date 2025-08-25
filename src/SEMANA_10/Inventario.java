/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_10;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
/**
 * Clase principal para gestionar el inventario con persistencia en archivos
 */
public class Inventario {

    private List<Producto> productos; // Lista que almacena los productos del inventario
    private final String ARCHIVO_INVENTARIO = "inventario.txt"; // Nombre del archivo donde se guarda el inventario

    public Inventario() {
        this.productos = new ArrayList<>(); // Inicializa la lista de productos vacía
        cargarInventario(); // Carga los productos desde el archivo al iniciar la clase
    }

    /**
     * Carga el inventario desde el archivo al iniciar el programa
     */
    private void cargarInventario() {
        File archivo = new File(ARCHIVO_INVENTARIO); // Crea un objeto File con el nombre del archivo

        try {
            // Si el archivo no existe, lo crea vacío
            if (!archivo.exists()) {
                System.out.println("Archivo de inventario no encontrado. Creando nuevo archivo...");
                archivo.createNewFile(); // Crea el archivo vacío
                System.out.println("Archivo '" + ARCHIVO_INVENTARIO + "' creado exitosamente.");
                return; // Finaliza el método si el archivo fue recién creado
            }

            // Si el archivo existe, lo lee línea por línea
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) { // Lee cada línea del archivo
                    if (!linea.trim().isEmpty()) { 
                        String[] datos = linea.split(","); 
                        if (datos.length == 4) { // Verifica que haya 4 datos por línea
                            String codigo = datos[0]; // Extrae el código del producto
                            String nombre = datos[1]; // Extrae el nombre del producto
                            int cantidad = Integer.parseInt(datos[2]); // Convierte la cantidad a entero
                            double precio = Double.parseDouble(datos[3]); // Convierte el precio a decimal
                            productos.add(new Producto(codigo, nombre, cantidad, precio)); // Crea y agrega el producto a la lista
                        }
                    }
                }
            }

            System.out.println("Inventario cargado exitosamente. Productos: " + productos.size()); // Muestra cuántos productos se cargaron

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage()); // Muestra error si falla la lectura
            System.out.println("Iniciando con inventario vacío..."); 
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato de datos del archivo: " + e.getMessage()); // Error si los datos no son numéricos
            System.out.println("Iniciando con inventario vacío..."); // Continúa con inventario vacío
        }
    }

    /**
     * Guarda el inventario en el archivo
     */
    private void guardarInventario() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_INVENTARIO))) {
            for (Producto producto : productos) { // Recorre todos los productos
                writer.write(producto.getCodigo() + "," + 
                             producto.getNombre() + "," + 
                             producto.getCantidad() + "," + 
                             producto.getPrecio()); 
                writer.newLine(); // Agrega una nueva línea después de cada producto
            }
            System.out.println("Inventario guardado exitosamente en '" + ARCHIVO_INVENTARIO + "'"); // Confirma que se guardó correctamente

        } catch (IOException e) {
            System.err.println("Error al guardar el inventario: " + e.getMessage()); // Muestra error si falla la escritura
        }
    }

    /**
     * Añade un nuevo producto al inventario
     */
    public void agregarProducto(Producto producto) {
        // Verifica si ya existe un producto con el mismo código
        for (Producto p : productos) {
            if (p.getCodigo().equals(producto.getCodigo())) {
                System.out.println("Error: Ya existe un producto con el código " + producto.getCodigo()); // Muestra error si el código ya existe
                return; // Sale del método sin agregar
            }
        }

        try {
            productos.add(producto); // Agrega el nuevo producto a la lista
            guardarInventario(); // Guarda el inventario actualizado en el archivo
            System.out.println("Producto agregado exitosamente: " + producto.getNombre()); // Confirma que se agregó

        } catch (Exception e) {
            System.err.println("Error al agregar producto: " + e.getMessage()); // Muestra error si algo falla
            productos.remove(producto); // Elimina el producto si hubo error
        }
    }

    /**
     * Actualiza un producto existente
     */
    public void actualizarProducto(String codigo, String nuevoNombre, int nuevaCantidad, double nuevoPrecio) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) { // Busca el producto por código
                try {
                    producto.setNombre(nuevoNombre); // Actualiza el nombre
                    producto.setCantidad(nuevaCantidad); // Actualiza la cantidad
                    producto.setPrecio(nuevoPrecio); // Actualiza el precio

                    guardarInventario(); // Guarda los cambios en el archivo
                    System.out.println("Producto actualizado exitosamente: " + codigo); // Confirma la actualización
                    return;

                } catch (Exception e) {
                    System.err.println("Error al actualizar producto: " + e.getMessage()); // Muestra error si algo falla
                    return;
                }
            }
        }
        System.out.println("Error: Producto con código " + codigo + " no encontrado."); // Muestra error si no se encuentra el producto
    }

    /**
     * Elimina un producto del inventario
     */
    public void eliminarProducto(String codigo) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) { // Busca el producto por código
                try {
                    Producto productoEliminado = productos.remove(i); // Elimina el producto de la lista
                    guardarInventario(); // Guarda los cambios en el archivo
                    System.out.println("Producto eliminado exitosamente: " + productoEliminado.getNombre()); // Confirma la eliminación
                    return;

                } catch (Exception e) {
                    System.err.println("Error al eliminar producto: " + e.getMessage()); // Muestra error si algo falla
                    return;
                }
            }
        }
        System.out.println("Error: Producto con código " + codigo + " no encontrado."); // Muestra error si no se encuentra el producto
    }

    /**
     * Busca un producto por código
     */
    public Producto buscarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto; // Devuelve el producto si lo encuentra
            }
        }
        return null; // Devuelve null si no lo encuentra
    }

    /**
     * Muestra todos los productos del inventario
     */
    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío."); // Muestra mensaje si no hay productos
            return;
        }

        System.out.println("\n=== INVENTARIO COMPLETO ==="); // Encabezado de la lista
        for (Producto producto : productos) {
            System.out.println(producto); // Muestra cada producto (se asume que tiene un método toString)
        }
        System.out.println("Total de productos: " + productos.size()); // Muestra el total de productos
    }
}