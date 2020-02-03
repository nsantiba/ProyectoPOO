/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eddy Santibañez J
 */
public class Mesero extends Persona{
    private List<Mesa> mesas= new ArrayList<Mesa>();
    private String nombre;
    private String apellido;
    
    
    public Mesero(String correo, String contrasena) {
        
        super(correo, contrasena);
        
    }
    
    public Mesero(String correo, String contrasena, String nombre, String apellido) {
        super(correo, contrasena);
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public Mesero(String correo, String contrasena, String nombre, String apellido, List<Mesa> mesas) {
        super(correo, contrasena);
        this.nombre = nombre;
        this.apellido = apellido;
    }


    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    @Override
    public String toString(){
        return ("Mesero "+nombre+" "+apellido);
    }  

    public List<Mesa> getMesas() {
        return mesas;
    }
    
}
