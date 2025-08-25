/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_10;

/**
 *
 * @author User
 */
import java.util.Scanner; 

/**
 * Clase principal con interfaz de usuario para el sistema de inventarios
 */
public class SistemaInventario {

    private static Scanner scanner = new Scanner(System.in); // Creo un objeto Scanner para entrada de usuario
    private static Inventario inventario = new Inventario(); // Creo una instancia del inventario

    public static void main(String[] args) { // Método principal del programa
        System.out.println("=== SISTEMA DE GESTIÓN DE INVENTARIOS ==="); 

        boolean continuar = true; // Variable para controlar el ciclo del menú
        while (continuar) { // Bucle principal del sistema
            mostrarMenu(); // Muestra las opciones del menú
            int opcion = leerOpcion(); // Lee la opción seleccionada por el usuario

            switch (opcion) { 
                case 1:
                    agregarProducto(); 
                    break;
                case 2:
                    actualizarProducto(); 
                    break;
                case 3:
                    eliminarProducto(); 
                    break;
                case 4:
                    buscarProducto(); 
                    break;
                case 5:
                    inventario.mostrarInventario(); 
                    break;
                case 0:
                    continuar = false; 
                    System.out.println("¡Gracias por usar el sistema!"); // Mensaje de despedida
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente."); // Mensaje de error si la opción no es válida
            }

            if (continuar) { // Si el usuario no eligió salir
                System.out.println("\nPresione Enter para continuar..."); 
                scanner.nextLine(); 
            }
        }
    }

    private static void mostrarMenu() { // Método para mostrar el menú principal
        System.out.println("\nMENU PRINCIPAL ");
        System.out.println("1. Agregar producto");
        System.out.println("2. Actualizar producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Buscar producto");
        System.out.println("5. Mostrar inventario completo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: "); // Solicita al usuario que seleccione una opción
    }

    private static int leerOpcion() { // Método para leer la opción del usuario
        try {
            return Integer.parseInt(scanner.nextLine()); 
        } catch (NumberFormatException e) {
            return -1; // Retorna -1 si la entrada no es válida
        }
    }

    private static void agregarProducto() { // Método para agregar un nuevo producto
        System.out.println("\n=== AGREGAR PRODUCTO ===");

        try {
            System.out.print("Codigo: ");
            String codigo = scanner.nextLine(); 

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine(); 

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine()); // Lee y convierte la cantidad

            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine()); // Lee y convierte el precio

            Producto producto = new Producto(codigo, nombre, cantidad, precio); // Crea el objeto producto
            inventario.agregarProducto(producto); // Agrega el producto al inventario

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese números validos para cantidad y precio."); // Mensaje si hay error en conversión numérica
        } catch (Exception e) {
            System.out.println("Error al agregar producto: " + e.getMessage()); // Mensaje si ocurre otro tipo de error
        }
    }

    private static void actualizarProducto() { // Método para actualizar un producto existente
        System.out.println("\n ACTUALIZAR PRODUCTO ");

        try {
            System.out.print("Codigo del producto a actualizar: ");
            String codigo = scanner.nextLine(); // Lee el código del producto

            Producto producto = inventario.buscarProducto(codigo); // Busca el producto en el inventario
            if (producto == null) {
                System.out.println("Producto no encontrado."); // Mensaje si no se encuentra el producto
                return;
            }

            System.out.println("Producto actual: " + producto); // Muestra los datos actuales del producto

            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine(); // Lee el nuevo nombre

            System.out.print("Nueva cantidad: ");
            int nuevaCantidad = Integer.parseInt(scanner.nextLine()); // Lee la nueva cantidad

            System.out.print("Nuevo precio: ");
            double nuevoPrecio = Double.parseDouble(scanner.nextLine()); // Lee el nuevo precio

            inventario.actualizarProducto(codigo, nuevoNombre, nuevaCantidad, nuevoPrecio); // Actualiza el producto

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese números válidos para cantidad y precio."); // Mensaje si hay error en conversión numérica
        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e.getMessage()); // Mensaje si ocurre otro tipo de error
        }
    }

    private static void eliminarProducto() { // Método para eliminar un producto
        System.out.println("\nELIMINAR PRODUCTO ");

        try {
            System.out.print("Codigo del producto a eliminar: ");
            String codigo = scanner.nextLine(); // Lee el código del producto

            Producto producto = inventario.buscarProducto(codigo); // Busca el producto en el inventario
            if (producto == null) {
                System.out.println("Producto no encontrado."); // Mensaje si no se encuentra el producto
                return;
            }

            System.out.println("Producto a eliminar: " + producto); // Muestra el producto que se va a eliminar
            System.out.print("¿Confirma la eliminación? (s/n): ");
            String confirmacion = scanner.nextLine(); // Solicita confirmación

            if (confirmacion.equalsIgnoreCase("s")) {
                inventario.eliminarProducto(codigo); // Elimina el producto si se confirma
            } else {
                System.out.println("Eliminación cancelada."); // Mensaje si se cancela la eliminación
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage()); // Mensaje si ocurre un error
        }
    }

    private static void buscarProducto() { // Método para buscar un producto por código
        System.out.println("\nBUSCAR PRODUCTO ");

        try {
            System.out.print("Codigo del producto: ");
            String codigo = scanner.nextLine(); // Lee el código del producto

            Producto producto = inventario.buscarProducto(codigo); // Busca el producto en el inventario
            if (producto != null) {
                System.out.println("Producto encontrado: " + producto); // Muestra el producto si se encuentra
            } else {
                System.out.println("Producto no encontrado."); // Mensaje si no se encuentra
            }

        } catch (Exception e) {
            System.out.println("Error al buscar producto: " + e.getMessage()); // Mensaje si ocurre un error
        }
    }
}
