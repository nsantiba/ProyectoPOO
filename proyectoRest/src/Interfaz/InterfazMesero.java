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
import Interfaz.Programa;
import extras.CuadroDialogo;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Eddy Santibañez J
 */
public class InterfazMesero  {
    
      VBox _rootM;
      Label _nombre; 
      Pane _seccionPlanoM = new Pane();
      //Mesero meseroprin;
      Scene sc2;
      Button _aceptar;
      Label _nuevaCuenta;
      VBox rootVentana;
      Stage nuevaVentana;
      Button salir;
      Circle c;
      TextField _nombreCliente;
      
      //ArrayList<Mesa> mesas;
      
      public InterfazMesero (Mesero mesero) throws FileNotFoundException{
          crearMenu(mesero);
          _seccionPlanoM(mesero);
      }
      
      /*public Mesero getMeseroPrincipal(){
          return meseroprin;
      }*/
      
      public VBox getRootM(){
          return _rootM;
      }
          
      
      public void crearMenu(Mesero mesero) throws FileNotFoundException{ 
          
          //meseroprin = VistaPrograma.meseroprin;
          System.out.println("Check:" +mesero);
          _rootM = new VBox();
          _nombre = new Label(mesero.toString());
          salir = new Button ( "Salir", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/salir.png" ) ) ) );
          EventHandler<MouseEvent> ev = (MouseEvent ev1) -> {
              if(ev1.getSource()==salir){
                  manejoMeseroSalir();
              }
          };
          salir.setOnMouseClicked(ev);
          
          _rootM.getChildren().addAll(_nombre, _seccionPlanoM,salir);
          
          
      }
    
    public void _seccionPlanoM(Mesero mesero){
        Label cocina= new Label("Cocina");
        Rectangle rect= new Rectangle(10, 250);
            rect.setLayoutX(400);
            rect.setLayoutY(5);        
            cocina.setLayoutX(410);
            cocina.setLayoutY(35);
        _seccionPlanoM.getChildren().addAll(cocina, rect);
        
        
        //mesas = InterfazAdministrador.mesas;
        //System.out.println("Check mesas: " +mesas);
        
            for (Mesa m: Programa.mesas){
                //c = m.getCircle();
                c= new Circle(m.getRadio()*4);//*4 para aumentar tamaño
                Label _numero = new Label(m.getNumero());
                c.setCenterX(m.getCentrox());
                c.setCenterY(m.getCentroy());
                //c.setFill(Color.web(m.getColor()));
                _numero.setLayoutX(m.getCentrox());
                _numero.setLayoutY(m.getCentroy());
                if((m.getOcupado()==true)&& (mesero.getMesas().contains(m)==false)){
                    System.out.println("no es mia");
                    c.setFill(Color.RED);
                    System.out.println(mesero.getMesas().contains(m));
                    //m.setColor("red");
                }
                if((m.getOcupado()==true) &&(mesero.getMesas().contains(m)==true)){
                     System.out.println("es mia");
                     c.setFill(Color.GREEN);
                     //m.setColor("green");
                }if(m.getOcupado()==false){
                    c.setFill(Color.YELLOW);
                    //m.setColor("yellow");
                }
                c.setOnMouseClicked((MouseEvent e4)->{
                        System.out.println("dentro");
                        if(m.getOcupado()==false){
                        crearVentana();
                        _aceptar.setOnMouseClicked((MouseEvent ev5)->{
                        String infocliente = _nombreCliente.getText();
                        nuevaVentana.close();
                        Cliente infocliente2 = new Cliente(infocliente);
                        Programa.clientes.add(infocliente2);
                        m.setOcupado(true);
                        //m.setColor("green");
                        c.setFill(Color.GREEN);
                        mesero.getMesas().add(m);
                        
                    });
                        if(m.getOcupado()==true){
                        System.out.println("Esta ocupada");
                    }    
                    }
                    });
                _seccionPlanoM.getChildren().addAll(c, _numero);
            
       
        
        
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
      Label l= new Label("Ingrese Nombre del Cliente"); 
      _nombreCliente = new TextField();
      _aceptar= new Button("Aceptar");
      sc2= new Scene(rootVentana, 300,300); 
      rootVentana.getChildren().addAll(_nuevaCuenta,l,_nombreCliente,_aceptar);
      nuevaVentana.setScene(sc2);
      nuevaVentana.show();

    }    

    private void manejoMeseroSalir ( )
    {
        if ( CuadroDialogo.confirmacion ( "CONFIRMACIÓN", "¿Está seguro que desea cerrar sesión?", null ).get ( ) == ButtonType.OK )
        {
            VistaPrograma p = new VistaPrograma();
            StackPane regreso = p.getRoot();
            _rootM.getChildren().clear();
            _rootM.getChildren().add(regreso);
        }
    }
}
