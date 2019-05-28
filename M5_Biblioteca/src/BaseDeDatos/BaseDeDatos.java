/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import Componentes.LectorDeTarjetas;
import Objetos.Ejemplar;
import Objetos.Libro;
import Objetos.Prestamo;
import Objetos.Usuario;
import java.util.ArrayList;

/**
 * Primera versión de la base de datos, no disponemos de la base de datos. De
 * momento trabajamos con una simulación que contiene los mismos objetos
 *
 * @author Ricard
 */
public class BaseDeDatos {

    private static Usuario conexion;
    private static ArrayList<Usuario> usuarios = cargarUsuarios();
    private static ArrayList<Libro> libros = cargarLibros();
    private static ArrayList<Ejemplar> ejemplares = cargarEjemplares();
    private static ArrayList<Prestamo> prestamos = cargarPrestamos();

    // <editor-fold defaultstate="collapsed" desc="Carga de datos">
    private static ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList();
        System.out.print("Cargando usuarios... ");
        //
        usuarios.add(new Usuario("Ricard", "Romani", "Pérez", "47599847N", true));
        usuarios.add(new Usuario("Marc", "Puig", "Burgués", "46994803J", true));
        usuarios.add(new Usuario("Marcelo", "Aguilar", "Soto", "X5791566P", true));
        usuarios.add(new Usuario("Mouse", "Mice", "Xia", "X8758774R", false));
        usuarios.add(new Usuario("Sukhchsin", "Singh", "X", "Y2530046M", false));
        usuarios.add(new Usuario("Roberth", "Eliut", "Gonzalez", "C02138364", false));
        //
        System.out.println("usuarios cargados.");
        return usuarios;
    }

    private static ArrayList<Libro> cargarLibros() {
        ArrayList<Libro> libros = new ArrayList();
        System.out.print("Cargando libros... ");
        //
        libros.add(new Libro(3333333, "Yo Julia", "Santiago Posteguillo", new String[]{"Aventura", "Sexo"}));
        libros.add(new Libro(4444444, "Come comida real", "Carlos Rios", new String[]{"Autoayuda", "Dieta"}));
        libros.add(new Libro(5555555, "La risa asesina", "Alan Mur", "Superheroes"));
        libros.add(new Libro(6666666, "El fuego invicible", "Javier Sierra", new String[]{"Novel conterporánea", "Amor", "Comedia"}));
        libros.add(new Libro(7777777, "La polla en vinagre", "Marceloide", "Aventura"));
        //
        System.out.println("libros cargados.");
        return libros;
    }

    private static ArrayList<Ejemplar> cargarEjemplares() {
        ArrayList<Ejemplar> ejemplares = new ArrayList();
        System.out.print("Cargando ejemplares... ");
        //
        ejemplares.add(new Ejemplar("000AA", libros.get(0), null, true));
        ejemplares.add(new Ejemplar("001AA", libros.get(0), null, false));
        ejemplares.add(new Ejemplar("000BB", libros.get(1), null, false));
        ejemplares.add(new Ejemplar("000CC", libros.get(2), null, false));
        ejemplares.add(new Ejemplar("000DD", libros.get(3), null, false));
        ejemplares.add(new Ejemplar("000EE", libros.get(4), null, false));
        //
        System.out.println("ejemplares cargados.");
        return ejemplares;
    }

    private static ArrayList<Prestamo> cargarPrestamos() {
        ArrayList<Prestamo> prestamos = new ArrayList();
        System.out.print("Cargando prestamos... ");
        //
        prestamos.add(new Prestamo(usuarios.get(5), usuarios.get(2), ejemplares.get(1), null, 3));
        prestamos.add(new Prestamo(usuarios.get(5), usuarios.get(3), ejemplares.get(2), null, 3));
        prestamos.add(new Prestamo(usuarios.get(5), usuarios.get(3), ejemplares.get(3), null, 3));
        //
        System.out.println("prestamos cargados.");
        return prestamos;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Devuelve los usuarios de la base de datos
     *
     * @return usuarios
     */
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Devuelve los prestamos de la base de datos
     *
     * @return prestamos
     */
    public static ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Devuelve los libros de la base de datos
     *
     * @return libros
     */
    public static ArrayList<Libro> getLibros() {
        return libros;
    }

    /**
     * Devuelve los ejemplares de la base de datos
     *
     * @return ejemplares
     */
    public static ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    /**
     * Devuelve el usuario que realiza la conexión
     *
     * @return usuario conectado
     */
    public static Usuario getConexion() {
        return conexion;
    }
    // </editor-fold>

    /**
     * Define el usuario conectado a partir de a lectura de la targeta
     */
    public static void setConexion() {
        try {
            BaseDeDatos.conexion = getUsuario(LectorDeTarjetas.getCodigo());
            System.out.println("Targeta validada, estableciendo conexión...");
        } catch (NullPointerException e) {
            System.err.println("Codigo fuera del sistema!");
            System.exit(0);
        }
    }

    /**
     * Devuelve un usuario de la base de datos a partir del DNI
     *
     * @param DNI
     * @return usuario
     */
    public static Usuario getUsuario(String DNI) throws NullPointerException {
        for (Usuario usuario : usuarios) {
            if (usuario.getContrasena().equals(DNI)) {
                return usuario;
            }
        }
        return null;
    }

}
