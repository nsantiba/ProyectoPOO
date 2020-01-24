/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Actores.Administrador;
import Actores.Mesa;
import Actores.Mesero;
import Actores.Persona;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import Interfaz.VistaPrograma;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import Interfaz.Programa;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author Eddy Santibañez J
 */
public class InterfazAdministrador {
       VBox _rootA;
       HBox _menu; 
       Pane _seccionPlanos; 
       Button _monitoreo; 
       Button _disenoPlano;
       Button _gestionMenu;
       Button _reporteVentas;
       Button _adminSalir; 
       
       public InterfazAdministrador(){
           crearMenu();
       }

         public VBox getRootA() {
            return _rootA;
        }

    public Pane getSeccionPlanos() {
        return _seccionPlanos;
    }
       
       
       public void crearMenu(){
           _rootA= new VBox();
           _menu= new HBox(); 
           _monitoreo= new Button("Monitoreo");
           _disenoPlano= new Button("Diseño Plano");
           _gestionMenu= new Button("Gestión Menú");
           _reporteVentas= new Button("ReporteVentas");
           _adminSalir= new Button("Salir"); 
           
           _menu.getChildren().addAll(_monitoreo,_disenoPlano,_gestionMenu,_reporteVentas,_adminSalir);
           _rootA.getChildren().add(_menu);
          
           
           EventHandler<MouseEvent> ev= new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent ev) {
               _seccionPlanos= new Pane();

               if(ev.getSource()==_monitoreo){
                manejoMonitoreo();
               }
                if(ev.getSource()==_disenoPlano){
                manejoDisenoPlano();
                
               }
                if(ev.getSource()==_gestionMenu){
               manejoGestionMenu();
               }
                if(ev.getSource()==_reporteVentas){
                manejoReporteVentas();
               }
                if(ev.getSource()==_adminSalir){
                manejoAdminSalir();
               }
               
          }};
          _monitoreo.setOnMouseClicked(ev);
          _disenoPlano.setOnMouseClicked(ev);
          _gestionMenu.setOnMouseClicked(ev);
          _reporteVentas.setOnMouseClicked(ev);
          _adminSalir.setOnMouseClicked(ev);

          }
       
       
        //DEBO CAMBIAR ESTO CON COMO MANEJARE LOS EVENTOS****
         public void manejoMonitoreo(){
           ///aqui ni idea que va pero va el plano
           Label l= new Label("manejar el evento en el flowPane");
           _seccionPlanos.getChildren().add(l);
          // _seccionPlanos.SetOnAction((AcitonEvent e))
           _rootA.getChildren().add(_seccionPlanos);
           
         
         }       
       
          public void manejoDisenoPlano(){
             
               
               //Scene sc2= new Scene();
               _rootA.getChildren().add(_seccionPlanos);
                      //helppppp;
                   
        
              Programa.sc.setOnMouseClicked((MouseEvent e)->{
                  
                    Stage ventanaMesa= new Stage();
                    VBox rootMesa= new VBox();
                    Label _nuevaMesa= new Label("Nueva Mesa");
                    HBox _capacidad= new HBox();
                    HBox _numero= new HBox();
                    Label _capa= new Label("Capacidad");
                    TextField _Tcapa= new TextField();
                    Label _num= new Label("Numero");
                    TextField _Tnum= new TextField();
                    Button _aceptar= new Button("Aceptar");
                    Scene sc2= new Scene(rootMesa, 300,300);
                    ventanaMesa.setScene(sc2);

                     _capacidad.getChildren().addAll(_capa,_Tcapa);
                     _numero.getChildren().addAll(_num,_Tnum);
                     rootMesa.getChildren().addAll(_nuevaMesa,_capacidad,_numero,_aceptar);
                     ventanaMesa.show();

               }) ;     
              
           
          }
          
           public void manejoGestionMenu(){
            Label l= new Label("manejar el evento en el flowPane");
           _seccionPlanos.getChildren().add(l);
           _rootA.getChildren().add(_seccionPlanos);  
               
         }
          public void manejoReporteVentas(){
           Label l= new Label("manejar el evento en el flowPane");
           _seccionPlanos.getChildren().add(l);
           _rootA.getChildren().add(_seccionPlanos);
              
         }
          public void manejoAdminSalir(){
              
           Label l= new Label("manejar el evento en el flowPane");
           _seccionPlanos.getChildren().add(l);
           _rootA.getChildren().add(_seccionPlanos);
         }
           
           
          
}

