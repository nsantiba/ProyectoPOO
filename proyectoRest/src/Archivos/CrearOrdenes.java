/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Actores.Cliente;
import Actores.Mesa;
import Actores.Mesero;
import Actores.Orden;
import Actores.Producto;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Creacion de archivo de ordenes inicial.
 * @author Eddy Santibañez J
 */
public class CrearOrdenes {
     /** 
     * @param args the command line arguments
     */
        public static void CrearOrden(){
    
              ArrayList<Orden> ord= new ArrayList<Orden>();

              Orden o= new Orden(new Cliente("Juan Perez"),new ArrayList<Producto>(),LocalDate.now(),new Mesa(5,"1",0.50,0.50,true),0,0,new Mesero("Jesu","Cristo"));
            
              ord.add(o);
             
              System.out.println(ord);
              
              
            String filePath= "src/Archivos/archivoOrdenes";
            try (ObjectOutputStream objOutputStream =  new ObjectOutputStream(new FileOutputStream(filePath))){
                
            objOutputStream.writeObject(ord);             
            
        } catch (FileNotFoundException e1) {
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
                     
}  
    public static void main(String[] args) {
        // TODO code application logic here
        CrearOrden();
    }
    
}
