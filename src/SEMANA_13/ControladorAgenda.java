/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_13;

/**
 *
 * @author User
 */
// Importo las librerias que necesito
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat; // Me permite dar formato a fechas y horas
import java.util.Date; // Uso Date para capturar los valores de los spinners
import java.util.Locale;

public class ControladorAgenda { //creo la clase 

    private VistaAgenda vista;

    public ControladorAgenda(VistaAgenda vista) { // Constructor que recibe la vista como parámetro
        this.vista = vista; // Guardo la vista para usarla en los métodos del controlador
        this.vista.getBtnAgregar().addActionListener(this::agregarEvento); // Cuando se presiona "Agregar", llamo a agregarEvento
        this.vista.getBtnEliminar().addActionListener(this::eliminarEvento); // Cuando se presiona "Eliminar", llamo a eliminarEvento
        this.vista.getBtnSalir().addActionListener(e -> this.vista.dispose()); // Cuando se presiona "Salir", cierro la ventana
    }

    private void agregarEvento(ActionEvent e) { // Método que se ejecuta al presionar "Agregar"
        String descripcion = vista.getTxtDescripcion().getText().trim(); // Obtengo y limpio el texto de la descripción
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "La descripción no puede estar vacía", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
 // Defino los formatos para mostrar fecha y hora como texto
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm", Locale.getDefault());
        // Obtengo los valores seleccionados en los spinners
        Date fecha = (Date) vista.getSpinnerFecha().getValue();
        Date hora = (Date) vista.getSpinnerHora().getValue();
// Convierto los valores a cadenas con formato
        String fechaStr = formatoFecha.format(fecha);
        String horaStr = formatoHora.format(hora);

        // Se crea un objeto Evento (aunque no se usa directamente en la tabla, es un buen patrón)
        Evento nuevoEvento = new Evento(fechaStr, horaStr, descripcion);
        // Agrego los datos del evento como una nueva fila en la tabla
        vista.getModeloTabla().addRow(new Object[]{nuevoEvento.getFecha(), nuevoEvento.getHora(), nuevoEvento.getDescripcion()});

        vista.getTxtDescripcion().setText("");
        vista.getTxtDescripcion().requestFocusInWindow();
    }

    private void eliminarEvento(ActionEvent e) { // Método que se ejecuta al presionar "Eliminar"
        int filaSeleccionada = vista.getTablaEventos().getSelectedRow(); // Verifico si hay una fila seleccionada
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona un evento primero", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(vista, "¿Eliminar el evento seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        
        if (respuesta == JOptionPane.YES_OPTION) {
            vista.getModeloTabla().removeRow(filaSeleccionada);
        }
    }

    public static void main(String[] args) { // Método principal para iniciar la aplicación
        SwingUtilities.invokeLater(() -> {
            VistaAgenda vista = new VistaAgenda(); // Creo la vista
            new ControladorAgenda(vista); // Creo el controlador y asocio la vista
            vista.setVisible(true); // Muestro la ventana
        });
    }
}
