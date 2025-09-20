/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_13;

/**
 *
 * @author User
 */
public class Evento { // Defino la clase Evento para representar cada registro en la agenda
 // Atributos privados que almacenan la información básica de un evento
    private String fecha;
    private String hora;
    private String descripcion;
// Constructor que inicializa los atributos
    public Evento(String fecha, String hora, String descripcion) {
        this.fecha = fecha; // Asigno la fecha recibida
        this.hora = hora; // Asigno la hora recibida
        this.descripcion = descripcion; // Asigno la descripción recibida al atributo interno.
    }
    
// Métodos getter y setter para acceder y modificar los atributos.
    public String getFecha() {
        return fecha; // Devuelvo la fecha del evento
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora; // Devuelvo la hora del evento
    }

    public void setHora(String hora) { // Permito modificar la hora del evento
        this.hora = hora; 
    }

    public String getDescripcion() {
        return descripcion; // Devuelvo la descripción del evento
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
