/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;


/**
 *
 * @author Ricard
 */
public class LectorDeTarjetas {
    
    /**
     * DNI de pruebas para el lector
     */
    public final static String DNI_DEFAULT = "C02138364";

    /**
     * Codigo en uso en el lector de tajetas.
     */
    private static String codigo = null;

    /**
     * Hace que el lector lea el codigo de la tarjeta dentro de la máquina.
     */
    public static void leerCodigo() {
        //codigo = codigo devuelto por el componente lector (aun no dispoible);
        codigo = DNI_DEFAULT;
        if (codigo == null){
            System.err.println("Targeta inválida!");
            System.exit(0);
        }
    }

    /**
     * Devuelve el codigo leído por el lector
     *
     * @return codigo
     */
    public static String getCodigo(){
        return codigo;
    }

}
