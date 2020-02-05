/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *Clase cliente para manejo de informacion en ordenes
 * @author user
 */


public class Cliente implements Serializable{
    String info;
    //ArrayList<Producto> pedidos;
    
    public Cliente(String info){
        this.info = info;
        
    }

    public String getInfo(){
        return info;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.info);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "info=" + info + '}';
    }
    
    
    
}
