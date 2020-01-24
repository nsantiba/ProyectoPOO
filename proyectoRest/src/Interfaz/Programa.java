/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Actores.Administrador;
import Actores.Mesero;
import Actores.Restaurante;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eddy Santibañez J
 */
public class Programa extends Application {
    static Restaurante restaurante;
    static Scene sc;
   @Override
    public void init(){
        
        restaurante= new Restaurante(); 
        Mesero m1= new Mesero("mesero1@gmail.com","mesero1");
        Administrador a1= new Administrador("admin1@gmail.com","admin1");
        restaurante.getPersonas().add(a1);
        restaurante.getPersonas().add(m1);
    }

    @Override
    public void stop(){
        System.out.println("fin");
    }
    @Override
    public void start(Stage primaryStage)  {
       VistaPrograma p= new VistaPrograma();
        sc = new Scene(p.getRoot(),600,600);
       primaryStage.setScene(sc);
       primaryStage.show();
    }
       public static void main(String[] args) {
            launch(args);
    }

}
    

