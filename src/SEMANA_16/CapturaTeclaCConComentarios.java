/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_16;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CapturaTeclaCConComentarios extends JFrame {

    private JList<String> lista;
    private JButton boton;

    public CapturaTeclaCConComentarios() {
        super("Captura tecla 'C'");

        // Aquí creo el modelo de la lista y agrego algunos elementos iniciales
        DefaultListModel<String> modelo = new DefaultListModel<>();
        modelo.addElement("Elemento 1");
        modelo.addElement("Elemento 2");
        modelo.addElement("Elemento 3");
        lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        boton = new JButton("Botón");

        // Configuro el layout principal y agrego la lista con scroll y el botón
        setLayout(new BorderLayout());
        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

        // Aquí registro el Key Binding para la tecla 'C' en la lista
        // Esto hace que la acción solo se active cuando la lista tiene el foco
        InputMap im = lista.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap am = lista.getActionMap();

        // Asocio la tecla 'C' con la acción llamada "accionC"
        im.put(KeyStroke.getKeyStroke('C'), "accionC");
        am.put("accionC", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtengo el índice del elemento seleccionado en la lista
                int idx = lista.getSelectedIndex();
                if (idx != -1) {
                    // Si hay un elemento seleccionado, alterno su texto para marcarlo o desmarcarlo
                    String valor = modelo.getElementAt(idx);
                    if (valor.endsWith(" (seleccionado)")) {
                        modelo.setElementAt(valor.replace(" (seleccionado)", ""), idx);
                        System.out.println("Elemento desmarcado: " + valor);
                    } else {
                        modelo.setElementAt(valor + " (seleccionado)", idx);
                        System.out.println("Elemento marcado: " + valor);
                    }
                } else {
                    // Si no hay selección, solo imprimo un mensaje en consola
                    System.out.println("Presionaste 'C' pero no hay elemento seleccionado.");
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        // Pido que la lista tenga foco para que pueda capturar la tecla 'C' al iniciar
        lista.requestFocusInWindow();
    }

    public static void main(String[] args) {
        // Inicio la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(CapturaTeclaCConComentarios::new);
    }
}

