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
import javafx.scene.shape.Rectangle;
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
       Stage ventanaMesa;
       VBox rootMesa;
       Label _nuevaMesa;
        HBox _capacidad;
        HBox _numero;
        Label _capa;
        TextField _Tcapa;
        Label _num;
        TextField _Tnum;
        Button _aceptar;
        Scene sc2;
        Button borrarMesa;
     
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
             
               Label cocina= new Label("Cocina");
               Rectangle rect = new Rectangle(10, 200); 
               rect.setLayoutX(400);
               rect.setLayoutY(5);
               cocina.setLayoutX(410);
               cocina.setLayoutY(35);
               _seccionPlanos.getChildren().addAll(cocina, rect);
               _rootA.getChildren().add(_seccionPlanos);
                      
                   
        
              Programa.sc.setOnMouseClicked((MouseEvent e)->{     
                   crearVentana();//se inicializa la ventana
                    ventanaMesa.setScene(sc2);
                    _aceptar.setOnMouseClicked((MouseEvent e2)->{
                        //Programa.sc.
                        int mesa_capacidad=Integer.parseInt(_Tcapa.getText());
                        String mesa_numero= _Tnum.getText();
                        ventanaMesa.close(); //cierro la ventana
                        Mesa m= new Mesa(mesa_capacidad*2,e.getSceneX(),e.getSceneY());
                        Circle c=m.getCircle();
                        Label _numeMesa= new Label(mesa_numero);
                        System.out.println(e.getSceneX());
                        System.out.println(e.getSceneY());
                        
                        c.setCenterX(e.getSceneX());
                        c.setCenterY(e.getSceneY());
                      
                        _numeMesa.setLayoutX(e.getSceneX());
                        _numeMesa.setLayoutY(e.getSceneY());
                      
                        _seccionPlanos.getChildren().addAll(c,_numeMesa);
                        borrarMesa= new Button("Borrar Mesa"); 
                        
                        
                       
                        c.setOnMouseDragged((MouseEvent e3)->{
                            
                            c.setCenterX(e3.getSceneX());
                            c.setCenterY(e3.getSceneY());
                            _numeMesa.setLayoutX(e3.getSceneX());
                            _numeMesa.setLayoutY(e3.getSceneY());
                        });
                       c.setOnMouseClicked((MouseEvent e4)->{
                           _rootA.getChildren().add(borrarMesa);
                           borrarMesa.setOnMouseClicked((MouseEvent e5)->{
                           _seccionPlanos.getChildren().removeAll(c,_numeMesa);
                           _rootA.getChildren().remove(borrarMesa);
                               
                           });
                           
                       });
                    });
                    
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
           
           
          public void crearVentana(){
            ventanaMesa= new Stage();
            rootMesa= new VBox();
            _nuevaMesa= new Label("Nueva Mesa");
            _capacidad= new HBox();
            _numero= new HBox();
            _capa= new Label("Capacidad");
            _Tcapa= new TextField();
            _num= new Label("Numero");
            _Tnum= new TextField();
            _aceptar= new Button("Aceptar");
            sc2= new Scene(rootMesa, 300,300); 
          }
         
                  
                  
}

