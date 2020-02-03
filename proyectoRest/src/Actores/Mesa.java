/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import java.io.Serializable;
import java.util.Objects;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Eddy Santibañez J
 */
public class Mesa implements Serializable {
   
    private int radio;
    private double centrox;
    private double centroy; 
    private String numero;
    //transient private  Circle circle;
    private boolean ocupado;
    private Mesero mesero;
    private Cliente cliente;
        
    
    public Mesa(int radio, String numero, double centrox, double centroy, boolean ocupado){
     
     this.numero= numero;
     this.radio= radio;
     this.centrox= centrox;
     this.centroy= centroy;
     this.ocupado = ocupado;
     
     /*this.circle = new Circle(radio);
     circle.setCenterX(centroy);
     circle.setCenterY(centroy);*/
  

    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public double getCentrox() {
        return centrox;
    }

    public void setCentrox(double centrox) {
        this.centrox = centrox;
    }

    public double getCentroy() {
        return centroy;
    }

    public void setCentroy(double centroy) {
        this.centroy = centroy;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente c){
        this.cliente = c;
    }
   
    
    
    //public Circle getCircle() {
       // return ;
    //}

   /* public void setCircle(Circle circle) {
        this.circle = circle;
    }*/
    
    
  

    @Override
    public String toString() {
        return ""+numero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Mesa other = (Mesa) obj;
        if (Double.doubleToLongBits(this.centrox) != Double.doubleToLongBits(other.centrox)) {
            return false;
        }
        if (Double.doubleToLongBits(this.centroy) != Double.doubleToLongBits(other.centroy)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    public Mesero getMesero() {
        return mesero;
    }
    
    public boolean getOcupado(){
        return ocupado;
    }
    
    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }
    
}
