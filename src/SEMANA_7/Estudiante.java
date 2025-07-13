/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_7; // Declaro el package donde se encuentra mi clase

/**
 *
 * @author User
 */
public class Estudiante { // Defino mi clase pública llamada Estudiante
    
    // Declaro los atributos privados de mi clase para aplicar encapsulamiento
    private String nombre; 
    private String carrera; 
    private int edad;
    
    // Constructor por defecto (sin parámetros)
    public Estudiante() { // Defino mi constructor por defecto que no recibe parámetros
        this.nombre = "Sin nombre"; // Inicializo el atributo nombre con un valor por defecto
        this.carrera = "Sin carrera"; // Inicializo el atributo carrera con un valor por defecto
        this.edad = 18; // Inicializo el atributo edad con un valor por defecto
        System.out.println("Estudiante creado con constructor por defecto"); // Imprimo un mensaje para confirmar la creación
    }
    
    // Constructor parametrizado con nombre solamente
    public Estudiante(String nombre) { // Defino mi constructor que recibe solo el nombre como parámetro
        this.nombre = nombre; // Asigno el parámetro nombre al atributo nombre de mi objeto
        this.carrera = "Sin carrera"; // Asigno un valor por defecto a carrera
        this.edad = 18; // Asigno un valor por defecto a edad
        System.out.println("Estudiante creado: " + this.nombre); // Imprimo un mensaje con el nombre del estudiante creado
    }
    
    // Constructor parametrizado con nombre y carrera (sobrecarga)
    public Estudiante(String nombre, String carrera) { // Defino mi constructor que recibe nombre y carrera como parámetros
        this.nombre = nombre; // Asigno el parámetro nombre al atributo nombre de mi objeto
        this.carrera = carrera; // Asigno el parámetro carrera al atributo carrera de mi objeto
        this.edad = 18; // Asigno un valor por defecto a edad
        System.out.println("Estudiante creado: " + this.nombre + " - " + this.carrera); // Imprimo un mensaje con nombre y carrera
    }
    
    // Constructor parametrizado completo (sobrecarga)
    public Estudiante(String nombre, String carrera, int edad) { // Defino mi constructor completo que recibe todos los parámetros
        this.nombre = nombre; // Asigno el parámetro nombre al atributo nombre de mi objeto
        this.carrera = carrera; // Asigno el parámetro carrera al atributo carrera de mi objeto
        this.edad = edad; // Asigno el parámetro edad al atributo edad de mi objeto
        System.out.println("Estudiante completo: " + this.nombre + " - " + this.carrera + " - " + this.edad + " años"); // Imprimo mensaje con todos los datos
    }
    
    // Método para mostrar información del estudiante
    public void mostrarInfo() { // Defino mi método público para mostrar la información del estudiante
        System.out.println("Nombre: " + this.nombre + "     Carrera: " + this.carrera + "     Edad: " + this.edad); // Imprimo todos los atributos del objeto
    }
}
