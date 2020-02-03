/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Actores.Mesa;
import Actores.Mesero;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Eddy Santibañez J
 */
public class InterfazMesero  {
    
      VBox _rootM;
      Label _nombre; 
      Pane _seccionPlanoM;
      Mesero meseroprin;
      
      private ArrayList<Mesa> mesas= new ArrayList<>();
      
      public InterfazMesero (){
          crearMenu();
      }
      
      public Mesero getMeseroPrincipal(){
          return meseroprin;
      }
      
      public VBox getRootM(){
          return _rootM;
      }
          
      
      public void crearMenu(){ 
          meseroprin = VistaPrograma.meseroprin;
          System.out.println("Check:" +meseroprin);
          _rootM = new VBox();
          _nombre = new Label(meseroprin.toString());
          
          //String nombresito = Programa.meseromain.toString();
          //_nombre = new Label(nombresito);
          
          _seccionPlanoM = new Pane();
          _rootM.getChildren().addAll(_nombre, _seccionPlanoM);
          
          
      }
}
