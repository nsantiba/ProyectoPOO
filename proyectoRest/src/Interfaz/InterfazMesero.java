/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Actores.Mesa;
import Actores.Mesero;
import static Interfaz.Programa.meseromain;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Eddy Santibañez J
 */
public class InterfazMesero {
    
      VBox _rootM;
      Label _nombre; 
      Pane _seccionPlanoM;
      
      private ArrayList<Mesa> mesas= new ArrayList<>();
      
      public InterfazMesero(){
          crearMenu();
      }
      
      public VBox getRootM(){
          return _rootM;
      }
          
      
      public void crearMenu(){
          _rootM = new VBox();
          //_nombre = new Label("Aqui iria el nombre del mesero si tuviera uno");
          _nombre = new Label(Programa.meseromain.toString());
          
          _seccionPlanoM = new Pane();
          _rootM.getChildren().addAll(_nombre, _seccionPlanoM);
          
          
      }
}
