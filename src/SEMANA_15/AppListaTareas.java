/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_15;

/**
 *
 * @author User
 */
import javax.swing.*; // Importo los componentes básicos de Swing
import javax.swing.border.EmptyBorder; // Me permite agregar márgenes 
import java.awt.*; 
import java.awt.event.*; 

public class AppListaTareas extends JFrame { // Creo la clase principal que extiende JFrame

    // Declaro los componentes principales de la interfaz
    private final DefaultListModel<Tarea> modeloLista; // Modelo que contiene las tareas
    private final JList<Tarea> listaTareas; // Lista visual que muestra las tareas
    private final JTextField campoNuevaTarea; // Campo de texto para escribir una nueva tarea
    private final JButton botonAnadir; // Botón para añadir tareas
    private final JButton botonCompletar; // Botón para marcar tareas como completadas
    private final JButton botonEliminar; // Botón para eliminar tareas

   
    public AppListaTareas() {
        super("Aplicación GUI de Lista de Tareas (Java Swing)"); // Le doy título a la ventana.

        // Inicializo los componentes de la interfaz.
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);
        campoNuevaTarea = new JTextField(20);
        botonAnadir = new JButton("Añadir Tarea");
        botonCompletar = new JButton("Marcar como Completada");
        botonEliminar = new JButton("Eliminar Tarea");

        //  Configuro la lista para que se vea bien y permita seleccionar una sola tarea.
        listaTareas.setCellRenderer(new TareaCellRenderer()); // Personalizo cómo se ve cada tarea.
        listaTareas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar una tarea a la vez.
        listaTareas.setVisibleRowCount(10); // Muestro hasta 10 tareas visibles.

        // Diseño la ventana usando BorderLayout y agrego márgenes.
        setLayout(new BorderLayout(10, 10)); // Espacio entre los paneles principales.
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10)); // Margen interno de la ventana.

        // Creo el panel de entrada con FlowLayout (horizontal).
        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelEntrada.add(new JLabel("Nueva Tarea:")); // Etiqueta para el campo de texto.
        panelEntrada.add(campoNuevaTarea); // Campo para escribir la tarea.
        panelEntrada.add(botonAnadir); // Botón para añadir la tarea.

        // Creo el panel de botones con GridLayout (una fila, dos columnas).
        JPanel panelAcciones = new JPanel(new GridLayout(1, 2, 10, 0));
        panelAcciones.add(botonCompletar); // Botón para marcar como completada.
        panelAcciones.add(botonEliminar); // Botón para eliminar.

        // Combino los paneles de entrada y botones en uno solo.
        JPanel panelControl = new JPanel(new BorderLayout(0, 10));
        panelControl.add(panelEntrada, BorderLayout.NORTH); // Entrada arriba.
        panelControl.add(panelAcciones, BorderLayout.CENTER); // Botones en el centro.

        // Agrego los paneles a la ventana principal.
        add(panelControl, BorderLayout.NORTH); // Panel de control arriba.
        add(new JScrollPane(listaTareas), BorderLayout.CENTER); // Lista de tareas con scroll en el centro.

        // Configuro la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierro la app al cerrar la ventana.
        pack(); // Ajusto el tamaño automáticamente.
        setLocationRelativeTo(null); // Centro la ventana en la pantalla.

        // Configuro los eventos (acciones de los botones).
        configurarManejadoresDeEventos();
    }

    // Método para conectar los botones con sus acciones.
    private void configurarManejadoresDeEventos() {
        // Acción para añadir tarea (botón y tecla Enter).
        ActionListener anadirTareaAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anadirTarea(); // Llamo al método que añade la tarea.
            }
        };

        botonAnadir.addActionListener(anadirTareaAction); // Clic en el botón.
        campoNuevaTarea.addActionListener(anadirTareaAction); // Presionar Enter en el campo.

        // Acción para marcar como completada.
        botonCompletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarComoCompletada(); // Llamo al método que cambia el estado.
            }
        });

        // Acción para eliminar tarea.
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTarea(); // Llamo al método que elimina la tarea.
            }
        });

        // Doble clic en la lista para marcar como completada.
        listaTareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    marcarComoCompletada(); // Si hay doble clic, cambio el estado.
                }
            }
        });
    }

    // Método para añadir una nueva tarea.
    private void anadirTarea() {
        String texto = campoNuevaTarea.getText().trim(); // Obtengo el texto y elimino espacios.
        if (!texto.isEmpty()) { // Verifico que no esté vacío.
            modeloLista.addElement(new Tarea(texto)); // Creo una nueva tarea y la añado al modelo.
            campoNuevaTarea.setText(""); // Limpio el campo de texto.
        }
    }

    // Método para marcar una tarea como completada.
    private void marcarComoCompletada() {
        int indiceSeleccionado = listaTareas.getSelectedIndex(); // Obtengo el índice seleccionado.
        if (indiceSeleccionado != -1) { // Verifico que haya una selección.
            Tarea tarea = modeloLista.getElementAt(indiceSeleccionado); // Obtengo la tarea.
            tarea.toggleCompletada(); // Cambio su estado.
            modeloLista.set(indiceSeleccionado, tarea); // Actualizo el modelo.
            listaTareas.repaint(); // Redibujo la lista.
        } else {
            // Si no hay selección, muestro un mensaje de advertencia.
            JOptionPane.showMessageDialog(this, "Selecciona una tarea para marcar/desmarcar.",
                                          "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para eliminar una tarea.
    private void eliminarTarea() {
        int indiceSeleccionado = listaTareas.getSelectedIndex(); // Obtengo el índice seleccionado.
        if (indiceSeleccionado != -1) { // Verifico que haya una selección.
            modeloLista.remove(indiceSeleccionado); // Elimino la tarea del modelo.
        } else {
            // Si no hay selección, muestro un mensaje de advertencia.
            JOptionPane.showMessageDialog(this, "Selecciona una tarea para eliminar.",
                                          "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Clase interna para personalizar cómo se ve cada tarea en la lista.
    private class TareaCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof Tarea) { // Verifico que el objeto sea una tarea.
                Tarea tarea = (Tarea) value;
                label.setText(tarea.getDescripcion()); // Muestro la descripción.

                if (tarea.isCompletada()) { // Si está completada, aplico estilo tachado y gris.
                    label.setText("<html><strike>" + tarea.getDescripcion() + "</strike></html>");
                    label.setForeground(Color.GRAY.darker());
                } else {
                    label.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
                }

                label.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            }

            return label; // Devuelvo el componente personalizado.
        }
    }

    // Método principal para ejecutar la aplicación.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AppListaTareas().setVisible(true); // Creo y muestro la ventana.
            }
        });
    }  //Fin
}