/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.io.Serializable;

/**
 *
 * @author Eddy Santibañez J
 */

// Creacion de clase serializable persona, que va a contener usuarios del programa.

public class Persona implements Serializable{
    private String correo; 
    private String contrasena;

    
    //Constructor, getters y setters.
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Persona(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    
}
