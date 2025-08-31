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

public class BuggyActividadMejorado {
    public static void main(String[] args) {
        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        //  CORREGIDO: Verifico que el tamaño sea correcto antes de acceder al índice
        // ORIGINAL: System.out.println("Elemento en posición 3: " + nombres.get(3));
        if (nombres.size() > 3) {
            System.out.println("Elemento en posición 3: " + nombres.get(3));
        } else {
            System.out.println("La lista solo tiene " + nombres.size() + " elementos");
            System.out.println("Último elemento (índice " + (nombres.size()-1) + "): " + nombres.get(nombres.size()-1));
        }

        //  CORREGIDO: Utilicé equals() en lugar de == (igual) para comparar contenido de cadenas
        // ORIGINAL: if (buscado == "Ana")
        String buscado = new String("Ana");
        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");
        telefonos.put("Ana", "0993333333"); // sobrescribe sin control

        //  CORREGIDO: Validé el valor antes de llamar métodos para evitar NullPointerException
        // ORIGINAL: System.out.println("Bea: " + telefonos.get("Bea").toString());
        String telefonoBea = telefonos.get("Bea");
        if (telefonoBea != null) {
            System.out.println("Bea: " + telefonoBea);
        } else {
            System.out.println("Bea no está en la agenda");
        }

        //  CORREGIDO: Implementé equals() y hashCode() para que el HashSet detecte duplicados lógicos
        // (gracias a los métodos que agregué en la clase Alumno)
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // Ahora será reconocido como duplicado

        System.out.println("Tamaño del Set: " + inscritos.size()); // Ahora muestra 2 en lugar de 3
        System.out.println(inscritos);
    }
}

//  CLASE CORREGIDA: Implementé equals() y hashCode() para comparación lógica correcta
class Alumno {
    int id;
    String nombre;
    
    Alumno(int id, String nombre) { 
        this.id = id; 
        this.nombre = nombre; 
    }
    
    //  CORREGIDO: Agrege equals() para que HashSet pueda comparar objetos por contenido
    // Permite detectar duplicados basados en id y nombre
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return id == alumno.id && Objects.equals(nombre, alumno.nombre);
    }

    //  CORREGIDO : AGREGUÉ hashCode() consistente con equals()
    // Esencial para que HashSet funcione correctamente con equals()
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
    
    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }
}

/* 
 RESUMEN DE MODIFICACIONES QUE REALICÉ:


PRIMERO:  Verifiqué que el tamaño sea correcto antes de acceder al índice

SEGUNDO: Utilicé equals() para comparar contenido de cadenas correctamente

TERCERO: Validé el valor antes de llamar métodos para evitar excepciones

CUARTO: Implementé equals() y hashCode() → Detecta duplicados correctamente (tamaño = 2)

QUINTO: Corregí todos los errores y ahora el código ejecuta sin problemas
*/


