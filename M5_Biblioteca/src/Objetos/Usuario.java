/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ricard
 */
public class Usuario {

    private final String NOMBRE, APELLIDO, APELLIDO2, DNI, CONTRASENA;
    private final boolean ADMINISTRADOR;

    private ArrayList<Prestamo> prestamos;
    private Date tiempoPenalizado;

    public Usuario(String NOMBRE, String APELLIDO, String APELLIDO2, String DNI, boolean ADMINISTRADOR) {
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.APELLIDO2 = APELLIDO2;
        this.DNI = DNI;
        CONTRASENA = DNI;
        this.ADMINISTRADOR = ADMINISTRADOR;
        prestamos = new ArrayList();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Devuelve el nombre del usuario
     *
     * @return nombre
     */
    public String getNombre() {
        return NOMBRE;
    }

    /**
     * Devuelve el primer apellido del usuario
     *
     * @return primer apellido
     */
    public String getApellido() {
        return APELLIDO;
    }

    /**
     * Devuelve el segundo apellido del usuario
     *
     * @return segundo apellido
     */
    public String getApellido2() {
        return APELLIDO2;
    }

    /**
     * Devuelve el DNI del usuario
     *
     * @return DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Devuelve la contraseña del usuario
     *
     * @return contraseña
     */
    public String getContrasena() {
        return CONTRASENA;
    }

    /**
     * Devuelve si el usuario es admnistrador o no
     *
     * @return <code>true</code> si el usuario es un administrador y
     * <code>false</code> en caso contrario
     */
    public boolean isAdministrador() {
        return ADMINISTRADOR;
    }

    /**
     * Devuelve los prestamos del usuario
     *
     * @return prestamos
     */
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Devuelve el tiempo penalizado
     *
     * @return
     */
    public Date getTiempoPenalizado() {
        return tiempoPenalizado;
    }
    
    //</editor-fold>

    /**
     * Define el tiempo penalizado
     *
     * @param tiempoPenalizado
     */
    public void setTiempoPenalizado(Date tiempoPenalizado) {
        this.tiempoPenalizado = tiempoPenalizado;
    }

    /**
     * Añade un prestamo
     *
     * @param prestamo
     */
    public void addPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
}
