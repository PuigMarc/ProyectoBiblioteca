/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author Ricard
 */
public class Libro {

    private final String titulo, autor;
    private final String[] genero;
    private int ISBN;
    private ArrayList<Ejemplar> ejemplares;

    public Libro(int ISBN, String titulo, String autor, String... genero) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        ejemplares = new ArrayList();
    }

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String[] getGenero() {
        return genero;
    }

    public int getISBN() {
        return ISBN;
    }

    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    //</editor-fold>
    
    /**
     * Añade un ejemplar a la lista
     *
     */
    public void addEjemplar(Ejemplar ejemplar) {
        ejemplares.add(ejemplar);
    }

}
