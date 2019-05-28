/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import BaseDeDatos.BaseDeDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Ricard
 */
public class MenuDeUsuario extends JFrame {
    
    private int intentos = 3;
    private final JButton botonCancelar = new JButton(), botonValidar = new JButton();
    private final JPasswordField campoContrasena = new JPasswordField();
    private final JLabel textoContrasena = new JLabel();

    public MenuDeUsuario() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Menu de usuario");
        setSize(440, 220);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        textoContrasena.setText("Introduce tu contraseña:");
        botonCancelar.setText("Cancelar");
        botonValidar.setText("Validar");
        botonValidar.addActionListener(actionListenerValidar());
        botonCancelar.addActionListener(actionListenerCancelar());
        textoContrasena.setBounds(20, 20, 300, 25);
        campoContrasena.setBounds(20, 50, 300, 25);
        botonValidar.setBounds(320, 50, 100, 25);
        botonCancelar.setBounds(320, 120, 100, 25);
        add(textoContrasena);
        add(campoContrasena);
        add(botonCancelar);
        add(botonValidar);
    }

    private ActionListener actionListenerValidar() {
        return (ActionEvent evt) -> {
            System.out.println("Validar...");
            String contrasena = new String(campoContrasena.getPassword());
            if (intentos > 0) {
                if (BaseDeDatos.getConexion().getContrasena().equalsIgnoreCase(contrasena)) {
                    System.out.println("Contraseña validada!");
                    setVisible(false);
                    MenuFichaDeCliente menuFichaDeCliente = new MenuFichaDeCliente();
                    menuFichaDeCliente.setVisible(true);
                } else {
                    intentos--;
                    String mensajeIntentos = (intentos > 0) ? "Intentos = " + intentos : "Sin intentos, se cierra el programa",
                            mensajeFinal = "Contraseña invalida! " + mensajeIntentos;
                    JOptionPane.showMessageDialog(null, mensajeFinal, "ERROR AL VALIDAR", JOptionPane.ERROR_MESSAGE);
                    if (intentos == 0) {
                        System.exit(0);
                    }
                }
            }
        };
    }

    private ActionListener actionListenerCancelar() {
        return (ActionEvent evt) -> {
            System.out.println("Saliendo...");
            System.exit(0);
        };
    }

    
}
