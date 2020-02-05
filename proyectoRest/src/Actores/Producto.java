/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase para manejo en ambos interfaces, objetos producto a ser usados en menu
 * @author Eddy Santibañez J
 */
public class Producto implements Serializable  {
    private String NombreProducto; 
    private double precio; 
    private String n_imagen;
    private String tipo;
    

    public Producto(String NombreProducto, double precio, String n_imagen,String tipo) {
        this.NombreProducto = NombreProducto;
        this.precio = precio;
        this.n_imagen = n_imagen;
        this.tipo = tipo;

        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.NombreProducto);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.n_imagen);
    
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
        final Producto other = (Producto) obj;
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.NombreProducto, other.NombreProducto)) {
            return false;
        }
        if (!Objects.equals(this.n_imagen, other.n_imagen)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return NombreProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getN_imagen() {
        return n_imagen;
    }

    public void setN_imagen(String n_imagen) {
        this.n_imagen = n_imagen;
    }
    
     
 
    
}
  