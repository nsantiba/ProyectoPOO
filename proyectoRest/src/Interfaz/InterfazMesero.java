/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Actores.Cliente;
import Actores.Mesa;
import Actores.Mesero;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Eddy Santibañez J
 */
public class InterfazMesero  {
    
      VBox _rootM;
      Label _nombre; 
      Pane _seccionPlanoM = new Pane();
      Mesero meseroprin;
      Scene sc2;
      Button _aceptar;
      Label _nuevaCuenta;
      VBox rootVentana;
      Stage nuevaVentana;
      Button salir;
      Circle c;
      TextField _nombreCliente;
      
      ArrayList<Mesa> mesas;
      
      public InterfazMesero () throws FileNotFoundException{
          crearMenu();
          _seccionPlanoM();
      }
      
      public Mesero getMeseroPrincipal(){
          return meseroprin;
      }
      
      public VBox getRootM(){
          return _rootM;
      }
          
      
      public void crearMenu() throws FileNotFoundException{ 
          
          meseroprin = VistaPrograma.meseroprin;
          System.out.println("Check:" +meseroprin);
          _rootM = new VBox();
          _nombre = new Label(meseroprin.toString());
          salir = new Button ( "Salir", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/salir.png" ) ) ) );
          EventHandler<MouseEvent> ev = (MouseEvent ev1) -> {
              if(ev1.getSource()==salir){
                  manejoMeseroSalir();
              }
          };
          salir.setOnMouseClicked(ev);
          
          _rootM.getChildren().addAll(_nombre, _seccionPlanoM,salir);
          
          
      }
    
    public void _seccionPlanoM(){
        Label cocina= new Label("Cocina");
        Rectangle rect= new Rectangle(10, 250);
            rect.setLayoutX(400);
            rect.setLayoutY(5);        
            cocina.setLayoutX(410);
            cocina.setLayoutY(35);
        _seccionPlanoM.getChildren().addAll(cocina, rect);
        
        
        mesas = InterfazAdministrador.mesas;
        System.out.println("Check mesas: " +mesas);
        
            for (Mesa m: mesas){
                c = m.getCircle();
                Label _numero = new Label(m.getNumero());
                c.setCenterX(m.getCentrox());
                c.setCenterY(m.getCentroy());
                _numero.setLayoutX(m.getCentrox());
                _numero.setLayoutY(m.getCentroy());
                _seccionPlanoM.getChildren().addAll(c, _numero);
         
                
         //Tira nullpointer       
        _seccionPlanoM.setOnMouseClicked((MouseEvent ev)->{
                c.setOnMouseClicked((MouseEvent e4)->{
                if(m.getOcupado()==false){
                    crearVentana();
                    nuevaVentana.setScene(sc2);
                    _aceptar.setOnMouseClicked((MouseEvent ev5)->{
                        String infocliente = _nombreCliente.getText();
                        nuevaVentana.close();
                        Cliente infocliente2 = new Cliente(infocliente);
                        Programa.clientes.add(infocliente2);
                        m.setOcupado(true);
                    });
                    
                if(m.getOcupado()==true){
                    System.out.println("Esta ocupada");
                }    
             }
        });
            
        });
        
        
        /*c.setOnMouseClicked((MouseEvent e4)->{
            if(m.get)
        });*/
        
        
        /*EventHandler<MouseEvent> ev = (MouseEvent ev1) -> {
              if(ev1.getSceneX()==radio){
              }
          };    */
    }}
    
    
    public void crearVentana(){
      nuevaVentana= new Stage();
      rootVentana= new VBox();
      _nuevaCuenta= new Label("Abrir Cuenta");
      _nombreCliente = new TextField();
      _aceptar= new Button("Aceptar");
      sc2= new Scene(rootVentana, 300,300); 
    }    

    private void manejoMeseroSalir() {
        VistaPrograma p = new VistaPrograma();
            StackPane regreso = p.getRoot();
            _rootM.getChildren().clear();
            _rootM.getChildren().add(regreso);
    }
}
