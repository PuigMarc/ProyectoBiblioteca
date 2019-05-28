/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestYPruebas;

import BaseDeDatos.BaseDeDatos;
import Componentes.LectorDeTarjetas;
import Main.MenuDeUsuario;

/**
 * Test de terminal, haz una prueba con contraseña=C02138364
 *
 * @author Ricard
 */
public class TestDeTerminal {

    public static void main(String[] args) {
        LectorDeTarjetas.leerCodigo();
        BaseDeDatos.setConexion();
        MenuDeUsuario menu = new MenuDeUsuario();
        menu.setVisible(true);
    }
}
