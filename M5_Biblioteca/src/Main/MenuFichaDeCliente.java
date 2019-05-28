/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import BaseDeDatos.BaseDeDatos;
import Objetos.Prestamo;
import Objetos.Usuario;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ricard
 */
public class MenuFichaDeCliente extends JFrame {

    public final Usuario CONEXION;

    public MenuFichaDeCliente() {
        super();
        CONEXION = BaseDeDatos.getConexion();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Ficha de usuario");
        setSize(500, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        //JPanel Superior
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2));
        //JPanel Superior -> PanelInfo    
        JPanel panelInfo = new JPanel(new GridLayout(8, 1));
        panelInfo.setBorder(BorderFactory.createTitledBorder("Información del Usuario"));
        panelInfo.add(new JLabel("Nombre: " + CONEXION.getNombre()));
        panelInfo.add(new JLabel("Apellido: " + CONEXION.getApellido()));
        panelInfo.add( new JLabel("Apellido2: " + CONEXION.getApellido2()));
        panelSuperior.add(panelInfo);
        //JPanel Superior -> panelOpciones
        JPanel panelOpciones = new JPanel(new GridLayout(5, 1));
        panelOpciones.setBorder(BorderFactory.createTitledBorder("Opciones"));
        panelOpciones.add(new JButton("Buscar libros"));
        panelOpciones.add(new JButton("Cambiar contraseña"));
        panelOpciones.add(new JButton("Salir\n y expulsar targeta"));
        panelSuperior.add(panelOpciones);
        //JPanel PanelLibros
        JPanel panelLibros = panelLibros();
        //JPanel PanelGlobal
        JPanel panelGlobal = new JPanel(new GridLayout(2, 1));
        panelGlobal.add(panelSuperior);
        panelGlobal.add(panelLibros);
        //JFrame
        add(panelGlobal);
    }

    private JPanel panelLibros() {
        JPanel panelLibros = new JPanel(new GridLayout(3, 1));
        panelLibros.setBorder(BorderFactory.createTitledBorder("Libros"));
        ArrayList<Prestamo> prestamos = CONEXION.getPrestamos();
        for (int i = 0; i < prestamos.size(); i++) {
            JPanel panelLibro = new JPanel(new GridLayout(2, 2));
            panelLibro.setBorder(BorderFactory.createTitledBorder("Libro " + (i + 1)));
            panelLibro.add(new JLabel("Titulo: " + prestamos.get(i).getEJEMPLAR().getLIBRO().getTitulo()));
            panelLibro.add(new JButton("Devolver"));
            panelLibro.add(new JLabel("Autor: " + prestamos.get(i).getEJEMPLAR().getLIBRO().getAutor()));
            panelLibro.add(new JButton("Proroga"));
            panelLibros.add(panelLibro);
        }
        return panelLibros;
    }
}
