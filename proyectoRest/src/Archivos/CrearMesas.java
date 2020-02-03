/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Actores.Administrador;
import Actores.Mesa;
import Actores.Mesero;
import Actores.Persona;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Eddy Santibañez J
 */
public class CrearMesas {

    /**
     * @param args the command line arguments
     */
    public static void cargarMesas(){
    
              ArrayList<Mesa> mes= new ArrayList<>();
             
              
              Mesa mesa1= new Mesa(10,"1",50.0,50.0,false);
              //Mesa mesa2= new Mesa(5,"2",70.0,30.0, "yellow");
              mes.add(mesa1);
              //mes.add(mesa2);
              System.out.println(mes);
              
              
            String filePath= "src/Archivos/archivoMesas";
            try (ObjectOutputStream objOutputStream =  new ObjectOutputStream(new FileOutputStream(filePath))){
                
            objOutputStream.writeObject(mes);             
            
        } catch (FileNotFoundException e1) {
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
                     
}    
    public static void main(String[] args) {
        // TODO code application logic here
        cargarMesas();
    }
    
}
