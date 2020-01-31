/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Actores.Administrador;
import Actores.Mesero;
import Actores.Producto;
import Actores.Restaurante;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eddy Santibañez J
 */
public class Programa extends Application {
    static  ArrayList<Producto> productos;
    static Restaurante restaurante;
    static Scene sc;
   @Override
    public void init(){
        //lo de los meseros usuarios tambien es en un archivo
        restaurante= new Restaurante(); 
        Mesero m1= new Mesero("mesero1@gmail.com","mesero1");
        Administrador a1= new Administrador("admin","admin");
        Administrador test = new Administrador("t","t");
        restaurante.getPersonas().add(test);
        restaurante.getPersonas().add(a1);
        restaurante.getPersonas().add(m1);
        
        String filePath= "src/Archivos/archivoProdcutos";
         try(ObjectInputStream objInputStream = new ObjectInputStream(
                    new FileInputStream(filePath))) {
            
            productos = (ArrayList<Producto>)objInputStream.readObject();
            System.out.println(productos);
            
        } catch (FileNotFoundException e1) {
            System.out.println("Error no enotrado");
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.err.println("Error al desrializar");
        } catch (ClassNotFoundException ex){
            System.err.println("Error al desrializar");
        }
    }

    @Override
    public void stop(){
        System.out.println("fin");
    }
    @Override
    public void start(Stage primaryStage)  {
       VistaPrograma p = new VistaPrograma();
        sc = new Scene(p.getRoot(),675,600);
       primaryStage.setScene(sc);
       primaryStage.show();
    }
       public static void main(String[] args) {
            launch(args);
    }
}