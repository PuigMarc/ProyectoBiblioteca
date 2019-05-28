/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.Date;

/**
 *
 * @author Ricard
 */
public class Prestamo {

    private final Usuario USUARIO;
    private final Usuario EMPLEADO;
    private final Ejemplar EJEMPLAR;
    private Date fechaLimite;
    private int prorogasDisponibles;

    public Prestamo(Usuario USUARIO, Usuario EMPLEADO, Ejemplar EJEMPLAR, Date fechaLimite, int prorogasDisponibles) {
        this.USUARIO = USUARIO;
        this.EMPLEADO = EMPLEADO;
        this.EJEMPLAR = EJEMPLAR;
        this.fechaLimite = fechaLimite;
        this.prorogasDisponibles = prorogasDisponibles;
        USUARIO.addPrestamo(this);
        EJEMPLAR.setPrestamo(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Devuelve el usuario que realiza el prestamo
     *
     * @return usuario
     */
    public Usuario getUSUARIO() {
        return USUARIO;
    }

    /**
     * Devuelve el empleado que formaliza el prestamo
     *
     * @return empleado
     */
    public Usuario getEMPLEADO() {
        return EMPLEADO;
    }

    /**
     * Devuelve el ejemplar del prestamo
     *
     * @return ejemplar
     */
    public Ejemplar getEJEMPLAR() {
        return EJEMPLAR;
    }

    /**
     * Devuelve la fecha limite en la que se debe devolver el ejemplar
     *
     * @return fecha limite
     */
    public Date getFechaLimite() {
        return fechaLimite;
    }

    /**
     * Devuelve el número de prorogas disponible (en un principio son 3)
     *
     * @return numero de prórogas
     */
    public int getProrogasDisponibles() {
        return prorogasDisponibles;
    }

    // </editor-fold>
    
    /**
     * Define la fecha límite para devolver un préstamo
     *
     * @param fechaLimite
     */
    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     * Reduce en 1 la cantidad de prórogas disponibles
     */
    public void reducirProrogasDisponibles() {
        prorogasDisponibles--;
    }

}
