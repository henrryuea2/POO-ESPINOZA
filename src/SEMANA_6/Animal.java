/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_6;

/**
 *
 * @author User
 */
public class Animal {
    // Encapsulación: atributo privado
    private String nombre;

    // Constructor
    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método que puede ser sobrescrito (polimorfismo)
    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido diferente.");
    }
}