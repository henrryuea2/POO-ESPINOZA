/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// EjemplosMundoReal_POO/TiendaSimple.java

package SEMANA_4;
/**
 *
 * @author User
 */

// Clase Producto  creo una clase para representar los productos de mi tienda
class Producto {
    // defino los atributos privados de mi producto
    private String nombre;
    private double precio;
    private int codigo;
    
    //  creo el constructor para inicializar mi producto
    public Producto(int codigo, String nombre, double precio) {
        //asigno los valores a los atributos de mi producto
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    //creo métodos getter para acceder a los datos de mi producto
    public String getNombre() {
        return nombre; 
    }
    
    public double getPrecio() {
        return precio; 
    }
    
    public int getCodigo() {
        return codigo; 
    }
    
    //  creo un método para mostrar la información de mi producto
    public void mostrarInfo() {
        System.out.printf(" ", codigo, nombre, precio);
    }
}

//  creo una clase para representar a mis clientes
class Cliente {
    //  defino los atributos privados de mi cliente
    private String nombre;
    private double dinero;
    
    //  creo el constructor para inicializar mi cliente
    public Cliente(String nombre, double dinero) {
        // asigno los valores a los atributos de mi cliente
        this.nombre = nombre;
        this.dinero = dinero;
    }
    
    
    public String getNombre() {
        return nombre; 
    }
    
    public double getDinero() {
        return dinero; 
    }
    
    
    public void gastarDinero(double monto) {
        dinero -= monto; 
    }
    
    // creo un método para mostrar la información de mi cliente
    public void mostrarInfo() {
        System.out.printf("Cliente: %s | Dinero: $%.2f%n", nombre, dinero);
    }
}

// Clase principal Tienda  creo la clase principal que gestiona mi tienda
class Tienda {
    // defino los atributos privados de mi tienda
    private String nombre;
    private Producto[] productos;
    private int cantidadProductos;
    private double totalVentas;
    private static final int MAX_PRODUCTOS = 20; 
    
    // creo el constructor para inicializar mi tienda
    public Tienda(String nombre) {
        //  inicializo todos los atributos de mi tienda
        this.nombre = nombre;
        this.productos = new Producto[MAX_PRODUCTOS]; // creo el arreglo de productos
        this.cantidadProductos = 0; // inicializo el contador en cero
        this.totalVentas = 0.0; //  inicializo las ventas en cero
    }
    
    // creo un método para agregar productos a mi tienda
    public void agregarProducto(Producto producto) {
        productos[cantidadProductos] = producto; // Yagrego el producto al arreglo
        cantidadProductos++; // 
        System.out.println(" Producto agregado: " + producto.getNombre()); 
    }
    
    //  creo un método para buscar productos por código en mi tienda
    public Producto buscarProducto(int codigo) {
        // recorro todos mis productos para encontrar el que busco
        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getCodigo() == codigo) { 
                return productos[i]; // 
            }
        }
        return null; // 
    }
    
    // creo un método para mostrar todos los productos de mi tienda
    public void mostrarProductos() {
        System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
        // recorro e imprimo cada producto de mi tienda
        for (int i = 0; i < cantidadProductos; i++) {
            productos[i].mostrarInfo(); //  muestro la información de cada producto
        }
    }
    
    // creo un método para procesar las compras en mi tienda
    public void comprar(Cliente cliente, int codigoProducto, int cantidad) {
        Producto producto = buscarProducto(codigoProducto); 
        double total = producto.getPrecio() * cantidad; // calculo el total de la compra
        
        
        cliente.gastarDinero(total); 
        totalVentas += total;
        
        // genero y muestro el recibo de compra
        System.out.println("\n RECIBO DE COMPRA");
        System.out.println("===================");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.printf("Total: $%.2f%n", total);
    }
    
    // creo un método para mostrar mis ventas totales
    public void mostrarVentas() {
        System.out.printf("\n Total ventas de %s: $%.2f%n", nombre, totalVentas);
    }
}

// Clase principal para ejecutar el programa 
public class Vida_real {
    public static void main(String[] args) {
        //  muestro el título de mi aplicación
        System.out.println(" TIENDA SIMPLE ");
        System.out.println("====================\n");
        
        // Yo creo mi tienda
        Tienda tienda = new Tienda("Mi Tienda");
        
        // Yo agrego productos a mi tienda
        System.out.println("AGREGANDO PRODUCTOS:");
        Producto producto1 = new Producto(1, "Coca Cola", 2.50); 
        Producto producto2 = new Producto(2, "Pan", 0.20); 
        Producto producto3 = new Producto(3, "Leche", 1.00); 
        
        tienda.agregarProducto(producto1); 
        tienda.agregarProducto(producto2); 
        tienda.agregarProducto(producto3);
        
        // muestro todos los productos
        tienda.mostrarProductos();
        
        //  creo un cliente para mi tienda
        Cliente cliente = new Cliente("Juan", 50.00);
        System.out.println("\n CLIENTE:");
        cliente.mostrarInfo(); //  muestro la información de mi cliente
        
        // proceso las compras de mi cliente
        System.out.println("\n REALIZANDO COMPRAS:");
        tienda.comprar(cliente, 1, 2); 
        tienda.comprar(cliente, 2, 3); 
        tienda.comprar(cliente, 3, 1); 
        
        //  muestro el estado final de mi negocio
        System.out.println("\nESTADO FINAL:");
        cliente.mostrarInfo(); 
        tienda.mostrarVentas(); 
        
       
        System.out.println("\n Compras completadas");
    }
}
