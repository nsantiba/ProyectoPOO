/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actores;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Eddy Santibañez J
 */
public class Mesa implements Observable{
    Color color;
    private int radio;
    private double centrox;
    private double centroy; 
    private int numero;
    private Circle circle;
        
    
    public Mesa(int radio, double centrox, double centroy){
   
     this.radio= radio;
     this.centrox= centrox;
     this.centroy= centroy;
     
     this.circle = new Circle(radio);
  
     circle.setFill(Color.YELLOW);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
    
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public void addListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
