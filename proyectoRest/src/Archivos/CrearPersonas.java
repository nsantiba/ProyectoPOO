/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Actores.Administrador;
import Actores.Mesero;
import Actores.Persona;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class CrearPersonas {

      public static void cargarPersonal(){
          
              ArrayList<Persona> per= new ArrayList<>();
              //Persona p1 = new Persona("persona1","persona1");
              
              //Se agrega bien el siguiente codigo:
              
              Persona admin1= new Administrador("admin1@gmail.com", "admin1");
              Persona admin2= new Administrador("a", "a");
              Persona mesero1= new Mesero("mesero1@gmail.com", "mesero1", "Gabriel", "Ruiz");
              Persona mesero2= new Mesero("mesero2@gmail.com", "mesero2", "Hector", "Lavoe");
              Persona mesero3= new Mesero("m", "m", "Jesu", "Cristo");
              per.add(admin1);
              per.add(admin2);
              per.add(mesero1);
              per.add(mesero2);
              per.add(mesero3);

              //per.add(p1);
              System.out.println("A ver si sirve");
              System.out.println(per);
              
              
            String filePath= "src/Archivos/archivoPersonas";
            try (ObjectOutputStream objOutputStream =  new ObjectOutputStream(new FileOutputStream(filePath))){
                
            objOutputStream.writeObject(per);             
            
        } catch (FileNotFoundException e1) {
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
                     
}    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cargarPersonal();
    }
    
}
