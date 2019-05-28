/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Ricard
 */
public class Ejemplar {

    private final String CODIGO;
    private final Libro LIBRO;
    private Prestamo prestamo;
    private boolean defectuoso;

    public Ejemplar(String CODIGO, Libro LIBRO, Prestamo prestamo, boolean defectuoso) {
        this.CODIGO = CODIGO;
        this.LIBRO = LIBRO;
        LIBRO.addEjemplar(this);
        this.prestamo = prestamo;
        this.defectuoso = defectuoso;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Devuelve el codigo del ejemplar
     *
     * @return codigo
     */
    public String getCODIGO() {
        return CODIGO;
    }

    /**
     * Devuelve el libro al que referencia el ejemplar
     *
     * @return libro
     */
    public Libro getLIBRO() {
        return LIBRO;
    }

    /**
     * Devuelve el prestamo ligado al ejemplar
     *
     * @return prestamo
     */
    public Prestamo getPrestamo() {
        return prestamo;
    }

    /**
     * Devuelve cierto si el ejemplar es defectuosos
     *
     * @return <code>true</code> si es defectuoso, <code>false</code> en caso
     * contrario
     */
    public boolean isDefectuoso() {
        return defectuoso;
    }

    /**
     *
     * @return
     */
    // </editor-fold>
    
    /**
     * Liga un prestamo con el ejemplar
     *
     * @param prestamo
     */
    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    /**
     * Define si el ejemplar está defectuoso
     *
     * @param defectuoso
     */
    public void setDefectuoso(boolean defectuoso) {
        this.defectuoso = defectuoso;
    }

}
