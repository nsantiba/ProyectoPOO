/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Actores.Producto;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import recursos.CONSTANTES;
/**
 *
 * @author Eddy Santibañez J
 */
public class CrearArchivoInicalProductos {
    
    
      public static void cargarProductos(){
              //este metodo no iría aqui si no en aplicacion ??. si no leer un archivo Corregir....
              ArrayList<Producto> pp= new ArrayList<>();
              String r= "src/recursos/";
              Producto agua= new Producto("Agua",0.5,r+"agua.jpg","Bebida");
              Producto cola= new Producto("CocaCola",1,r+"coca_cola.png","Bebida");
              Producto jugo_manzana= new Producto("Jugo de manzana",1,r+"jugo-manzana.jpg","Bebida");
              Producto hamburguesa= new Producto("Hamburguesa",2.50,r+"hamburguesa.jpg","Salado");
              Producto hotDog = new Producto("Hot Dog",2.00,r+"hot_dog.jPg","Salado");
              Producto cakeChoco= new Producto("Torta de Chocolate",1.5,r+"cake_chocolate.jpg","Postre");
              Producto gelatina= new Producto("Gelatina",0.75,r+"gelatina.jpg","Postre");
              pp.add(agua);
              pp.add(cola);
              pp.add(jugo_manzana);
              pp.add(hamburguesa);
              pp.add(hotDog);
              pp.add(cakeChoco);
              pp.add(gelatina);

              
            String filePath= "src/Archivos/archivoProdcutos";
            try (ObjectOutputStream objOutputStream =  new ObjectOutputStream(new FileOutputStream(filePath))){
                
            objOutputStream.writeObject(pp);
           
            
           
            
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
        cargarProductos();
    }
    
}
