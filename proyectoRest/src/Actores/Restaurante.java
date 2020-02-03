/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.util.ArrayList;

/**
 *
 * @author Eddy Santibañez J
 */
public class Restaurante {
    private ArrayList<Persona> personas; 
    private ArrayList<Mesero> meseros; 
    //private Mesero meseromain;

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public ArrayList<Mesero> getMeseros(){
        return meseros;
    }
 

    public Restaurante() {
        personas = new ArrayList<Persona>();
        meseros = new ArrayList<Mesero>();
    }
    
    
    
}
