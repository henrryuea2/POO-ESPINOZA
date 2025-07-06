/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_6;

public class Main {
    public static void main(String[] args) {
        // Crear instancias
        Animal generico = new Animal("Criatura");
        Perro perro = new Perro("Firulais");
        Gato gato = new Gato("Michi");

        // Encapsulación: acceder al atributo privado mediante métodos públicos
        System.out.println("Nombre original: " + generico.getNombre());
        generico.setNombre("Bestia");
        System.out.println("Nombre modificado: " + generico.getNombre());

        // Polimorfismo: mismo método, diferentes comportamientos
        generico.hacerSonido();
        perro.hacerSonido();
        gato.hacerSonido();

        // Polimorfismo con arreglo
        System.out.println("\n Polimorfismo con arreglo ");
        Animal[] animales = {generico, perro, gato};
        for (Animal a : animales) {
            a.hacerSonido();
        }
    }
}