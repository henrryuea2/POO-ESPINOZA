/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Importo todos los componentes 
package SEMANA_13;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.event.*; 

public class VentanaPrincipal extends JFrame { // creo una clase que extiende JFrame para crear la ventana principal
    private JTextField campoTexto; // declaro un campo de texto para que el usuario ingrese datos
    private JButton botonAgregar; // declaro un botón para agregar datos a la lista
    private JButton botonLimpiar; // declaro un botón para limpiar el campo y la lista
    private DefaultListModel<String> modeloLista; 
    private JList<String> listaDatos; 
    private JLabel etiqueta; // declaro una etiqueta para indicar qué debe ingresar el usuario

    public VentanaPrincipal() { // creo el constructor donde configuro la ventana y sus componentes
        setTitle("Gestor de Datos"); // le pongo un título descriptivo a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(400, 300); // defino el tamaño inicial de la ventana
        setLocationRelativeTo(null); 

        // Layout principal
        setLayout(new BorderLayout()); 

        // Panel superior con etiqueta y campo de texto
        JPanel panelSuperior = new JPanel(new FlowLayout()); 
        etiqueta = new JLabel("Ingrese un dato:"); // creo la etiqueta que indica al usuario qué hacer
        campoTexto = new JTextField(15); // creo el campo de texto con un ancho de 15 columnas
        panelSuperior.add(etiqueta); // agrego la etiqueta al panel superior
        panelSuperior.add(campoTexto); // agrego el campo de texto al panel superior

        // Panel central con la lista
        modeloLista = new DefaultListModel<>(); // inicializo el modelo que contendrá los datos de la lista
        listaDatos = new JList<>(modeloLista); 
        JScrollPane scrollLista = new JScrollPane(listaDatos); 

        // Panel inferior con botones
        JPanel panelInferior = new JPanel(new FlowLayout()); // creo un panel con  para los botones
        botonAgregar = new JButton("Agregar"); // creo el botón para agregar datos
        botonLimpiar = new JButton("Limpiar"); // creo el botón para limpiar datos
        panelInferior.add(botonAgregar); // agrego el botón agregar 
        panelInferior.add(botonLimpiar); // agrego el botón limpiar 

        // Agregar paneles al frame
        add(panelSuperior, BorderLayout.NORTH); 
        add(scrollLista, BorderLayout.CENTER); 
        add(panelInferior, BorderLayout.SOUTH); 
        // Eventos
        botonAgregar.addActionListener(new ActionListener() { // agrego un listener para el botón agregar
            public void actionPerformed(ActionEvent e) {
                agregarDato(); 
            }
        });

        botonLimpiar.addActionListener(new ActionListener() { // agrego un listener para el botón limpiar
            public void actionPerformed(ActionEvent e) {
                limpiar(); 
            }
        });

      
        listaDatos.addListSelectionListener(new ListSelectionListener() { // agrego un listener para detectar selección en la lista
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // me aseguro que el evento no esté en proceso de ajuste
                    String seleccionado = listaDatos.getSelectedValue(); 
                    if (seleccionado != null) { // si hay un valor seleccionado
                        campoTexto.setText(seleccionado); // ño pongo en el campo de texto para editar o ver
                    }
                }
            }
        });
    }

    private void agregarDato() { // creo un metodo para agregar un dato a la lista
        String texto = campoTexto.getText().trim(); 
        if (!texto.isEmpty()) { // vrifico que el texto no esté vacío
            modeloLista.addElement(texto); // agrego el texto al modelo de la lista
            campoTexto.setText(""); // limpio el campo de texto 
        } else {
            JOptionPane.showMessageDialog(this, "No se puede agregar un campo vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            // muestro un mensaje de advertencia 
        }
    }

    private void limpiar() { // creo un metodo para limpiar campo
        campoTexto.setText(""); // limpio el campo de texto
        listaDatos.clearSelection(); 
        modeloLista.clear(); 
    }

    public static void main(String[] args) { // creo el metodo principal para iniciar la aplicación
        SwingUtilities.invokeLater(new Runnable() { // Uso invokeLater para asegurar que la GUI se cree en el hilo correcto
            public void run() {
                new VentanaPrincipal().setVisible(true); // Creo la ventana principal y la hago visible
            }
        });
    }
}
