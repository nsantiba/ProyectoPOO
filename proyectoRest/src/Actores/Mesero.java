/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.util.List;

/**
 *
 * @author Eddy Santibañez J
 */
public class Mesero extends Persona{
    List<Mesa> mesas; 
    
    public Mesero(String correo, String contrasena) {
        super(correo, contrasena);
    }
    
}
