/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.util.Objects;

/**
 *
 * @author Eddy Santibañez J
 */
public class Producto {
    private String NombreProducto; 
    private double precio; 
    private String n_imagen;
    private String Tipo;

    public Producto(String NombreProducto, double precio, String n_imagen, String Tipo) {
        this.NombreProducto = NombreProducto;
        this.precio = precio;
        this.n_imagen = n_imagen;
        this.Tipo = Tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.NombreProducto);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.n_imagen);
        hash = 23 * hash + Objects.hashCode(this.Tipo);
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
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "NombreProducto=" + NombreProducto + ", Tipo=" + Tipo + '}';
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
    
}
