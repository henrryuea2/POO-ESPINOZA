/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_9;

/**
 *
 * @author User
 */

  //  estoy declarando mi clase. La llamo ArchivoVacioExcepcion para que su nombre me diga exactamente lo que hace:
// representa un error cuando un archivo está vacío. 
public class ArchivoVacioExcepcion extends Exception {
    
    //  estoy definiendo el constructor de mi clase. Cuando alguien quiera crear una instancia de ArchivoVacioExcepcion,

    public ArchivoVacioExcepcion(String mensaje) {
      
     
        super(mensaje);
    }
}

