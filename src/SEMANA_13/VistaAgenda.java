/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_13;

/**
 *
 * @author User
 */
// Importo las librerias 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VistaAgenda extends JFrame {  // Extiendo JFrame para que esta clase sea una ventana principal
// Declaro los componentes principales de la interfaz
    private JTable tablaEventos;
    private DefaultTableModel modeloTabla;
    private JSpinner spinnerFecha;
    private JSpinner spinnerHora;
    private JTextField txtDescripcion;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnSalir;

    public VistaAgenda() { // Constructor de la clase
        // Establezco el título de la ventana y configuro su cierre
        super("Gestor de Eventos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400); // Establezco el tamaño de la ventana
        setLocationRelativeTo(null);
// Llamo a métodos separados para mantener el código organizado
        inicializarComponentes();
        organizarLayout();
    }

    private void inicializarComponentes() { // Método para crear y configurar cada componente
        modeloTabla = new DefaultTableModel(new Object[]{"Fecha", "Hora", "Descripción"}, 0); // Defino las columnas de la tabla
        tablaEventos = new JTable(modeloTabla); // Creo la tabla con el modelo definido

        SpinnerDateModel fechaModel = new SpinnerDateModel(); //Modelo para el spinner de fecha
        spinnerFecha = new JSpinner(fechaModel);
        JSpinner.DateEditor fechaEditor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
        spinnerFecha.setEditor(fechaEditor);

        SpinnerDateModel horaModel = new SpinnerDateModel();  // Modelo para el spinner de hora
        spinnerHora = new JSpinner(horaModel);
        JSpinner.DateEditor horaEditor = new JSpinner.DateEditor(spinnerHora, "HH:mm");
        spinnerHora.setEditor(horaEditor);

        txtDescripcion = new JTextField(20);
        btnAgregar = new JButton("Agregar"); // Botón para agregar eventos
        btnEliminar = new JButton("Eliminar Seleccionado"); // Botón para eliminar el evento seleccionado
        btnSalir = new JButton("Salir");  // Botón para cerrar la aplicación
    }

    private void organizarLayout() { // Método para organizar los componentes en la ventana
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 10, 5));
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Nuevo Evento")); // Le pongo un borde con título 
        panelEntrada.add(new JLabel("Fecha (dd/MM/yyyy):")); // Etiqueta para la fecha
        panelEntrada.add(spinnerFecha); // Agrego el spinner de fecha
        panelEntrada.add(new JLabel("Hora (HH:mm):")); // Etiqueta para la hora
        panelEntrada.add(spinnerHora); // Agrego el spinner de hora
        panelEntrada.add(new JLabel("Descripción:")); // Etiqueta para la descripción
        panelEntrada.add(txtDescripcion); // Agrego el campo de texto

        JPanel panelBotones = new JPanel(); // Panel para los botones
        panelBotones.add(btnAgregar); // Agrego el botón de agregar
        panelBotones.add(btnEliminar);  // Agrego el botón de eliminar
        panelBotones.add(btnSalir); // Agrego el botón de salir

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10)); // Panel principal con diseño de bordes
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(panelEntrada, BorderLayout.NORTH); // Coloco el panel de entrada arriba
        panelPrincipal.add(new JScrollPane(tablaEventos), BorderLayout.CENTER); // Coloco la tabla en el centro
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    // Métodos para que el controlador acceda a los componentes
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
    public JTable getTablaEventos() { return tablaEventos; }
    public JSpinner getSpinnerFecha() { return spinnerFecha; }
    public JSpinner getSpinnerHora() { return spinnerHora; }
    public JTextField getTxtDescripcion() { return txtDescripcion; }
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnSalir() { return btnSalir; }
}
