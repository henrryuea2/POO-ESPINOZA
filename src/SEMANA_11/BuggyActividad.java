/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_11;

/**
 *
 * @author User
 */
import java.util.*;

public class BuggyActividad {
    public static void main(String[] args) {
        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // ERROR 1: Índice fuera de rango
        // PROBLEMA: La lista tiene 3 elementos (índices 0, 1, 2) pero en el codigo se intenta acceder al índice 3
        
 

        System.out.println("Elemento en posición 3: " + nombres.get(3));
        // ERROR 2: Comparación de cadenas con == en lugar de equals()
        // PROBLEMA: == compara referencias de objeto, no contenido
        
        String buscado = new String("Ana");

        if (buscado == "Ana") {

            System.out.println("Encontrado");

        }

        Map<String, String> telefonos = new HashMap<>();

        telefonos.put("Ana", "0991111111");

        telefonos.put("Luis", "0992222222");

        telefonos.put("Ana", "0993333333"); // sobrescribe sin control

        // ERROR 3: NullPointerException al obtener clave inexistente
        // PROBLEMA: get() devuelve null si la clave no existe, y luego se llama toString()
       
        System.out.println("Bea: " + telefonos.get("Bea").toString());

        // ERROR 4: Set no previene duplicados lógicos
        // PROBLEMA:  La clase Alumno no implementa equals() y hashCode(), por lo que HashSet no puede determinar cuándo dos objetos son lógicamente iguales
        
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // Ya no será duplicado lógico

        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}


class Alumno {

    int id;

    String nombre;

    Alumno(int id, String nombre) { this.id = id; this.nombre = nombre; }

    public String toString() {

        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";

   }

}

/* 
RESUMEN DE ERRORES DETECTADOS:

1. Intentar acceder al índice 3 en una lista de 3 elementos
   -  Los índices van de 0 a 2, no existe el índice 3

2. Comparación incorrecta de strings: Usar == en lugar de equals()
   -  == compara referencias de memoria, no el contenido de las cadenas

3. NullPointerException: Llamar toString() en un valor null
   -   get() devuelve null cuando la clave no existe en el HashMap

4. Duplicados no detectados en HashSet: Falta implementar equals() y hashCode()
   - Sin estos métodos, HashSet no puede detectar objetos lógicamente iguales
   - Cada objeto Alumno es considerado único aunque tenga los mismos datos
*/