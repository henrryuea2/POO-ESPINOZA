/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_6;

/**
 *
 * @author User
 */
public class Perro  extends Animal {
      public Perro(String nombre) {
        super(nombre);
    }

    // Polimorfismo: sobrescribimos el método
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: Guau guau!");
    }
}
