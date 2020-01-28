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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedMap;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 *
 * @author Eddy Santibañez J
 */
public class InterfazAdministrador {
       private ArrayList<Mesa> mesas= new ArrayList<>();
       //private ArrayList<Mesa> mesas2;
       VBox _rootA;
       HBox _menu; 
       Pane _seccionPlanos= new Pane();
       Pane _planos;
       Pane _seccionMonitoreo= new Pane();
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
        Button borrarMesa=  new Button("Borrar Mesa"); 
        VBox _infoMesa= new VBox();
        Label cocina;
        Label cocina2;
        Rectangle rect = new Rectangle(10, 250); 
        Rectangle rect2= new Rectangle(10, 250);
        Label estadoMesa= new Label();
          boolean continuar= true;
        VBox infoMesa;
        String estado= " ";
         String mesero=" ";
         String valorfac;
         
        
     
       public InterfazAdministrador(){
           crearMenu();
           crearSeccionPlanosyMonitoreo();
          
           manejoMonitoreo();
           manejoDisenoPlano();
           //MonitoreoPlano monitoreoPlano= new MonitoreoPlano();
           //Thread t1= new Thread(monitoreoPlano);
           //t1.start();
           
          
          
       }

         public VBox getRootA() {
            return _rootA;
        }

    
       
       
       public void crearMenu(){
           _rootA= new VBox();
           _menu= new HBox(); 
           _monitoreo= new Button("Monitoreo");
           _disenoPlano= new Button("Diseño Plano");
           _gestionMenu= new Button("Gestión Menú");
           _reporteVentas= new Button("ReporteVentas");
           _adminSalir= new Button("Salir"); 
           _planos= new Pane();
           
           _menu.getChildren().addAll(_monitoreo,_disenoPlano,_gestionMenu,_reporteVentas,_adminSalir);
           _rootA.getChildren().addAll(_menu,_planos);
          
           
           EventHandler<MouseEvent> ev= new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent ev) {
    
               if(ev.getSource()==_monitoreo){
                    _planos.getChildren().clear();
                    _planos.getChildren().add(_seccionMonitoreo);
                    _planos.getChildren().add(infoMesa);
                    //_rootA.getChildren().add(infoMesa);
                    
                    
               }
                if(ev.getSource()==_disenoPlano){
                    _planos.getChildren().clear();///
                    _planos.getChildren().add(_seccionPlanos);
       
               }
                if(ev.getSource()==_gestionMenu){
                     _planos.getChildren().clear();
                     manejoGestionMenu();
               }
                if(ev.getSource()==_reporteVentas){
                     _planos.getChildren().clear();
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
       
       
  
         public void manejoMonitoreo(){
         
             infoMesa= new VBox(); 
             Label l_valor= new Label("Valor facturado"+valorfac);
             Label l_estado= new Label("Estado: "+estado);
             Label MeseroMesa= new Label("Mesero: "+mesero);        
             infoMesa.getChildren().addAll(l_estado,MeseroMesa,l_valor);
             
         
         }       
       
          public void manejoDisenoPlano(){
                   
            _seccionPlanos.setOnMouseClicked((MouseEvent e)->{  
                crearVentana();
                //se inicializa la ventana
                
                 
                ventanaMesa.setScene(sc2);
                _aceptar.setOnMouseClicked((MouseEvent e2)->{
                     
                        //Programa.sc.
                    int mesa_capacidad=Integer.parseInt(_Tcapa.getText());
                    String mesa_numero= _Tnum.getText();
                    ventanaMesa.close(); //cierro la ventana
                    double posx= e.getSceneX();
                    double posy= e.getSceneY();
                    Mesa m= new Mesa(mesa_capacidad,mesa_numero,posx,posy);
                    Mesa m2= new Mesa(mesa_capacidad,mesa_numero,posx,posy);
                    mesas.add(m);//agregp cada mesa a mesas 
                    System.out.println("se agregó");
                    Circle c=m.getCircle();
                    Circle c2= m2.getCircle();
                    Label _numeMesa= new Label(mesa_numero);
                    Label _numeMesa2= new Label(mesa_numero);
                    c.setCenterX(posx);
                    c.setCenterY(posy);
                    c2.setCenterX(posx);
                    c2.setCenterY(posy);
                    _numeMesa.setLayoutX(posx);
                    _numeMesa.setLayoutY(posy);
                    _numeMesa2.setLayoutX(posx);
                    _numeMesa2.setLayoutY(posy);

                    _seccionPlanos.getChildren().addAll(c,_numeMesa);
                    _seccionMonitoreo.getChildren().addAll(c2,_numeMesa2);
                    c.setOnMouseDragged((MouseEvent e3)->{
                        double posx2=e3.getSceneX();
                        double posy2=e3.getSceneY();
                        
                        c.setCenterX(posx2);
                        c.setCenterY(posy2);
                        m.setCentrox(posx2);
                        m.setCentroy(posy2);
                        _numeMesa.setLayoutX(posx2);
                        _numeMesa.setLayoutY(posy2);
                        c2.setCenterX(posx2);
                        c2.setCenterY(posy2);
                        m2.setCentrox(posx2);
                        m2.setCentroy(posy2);
                        _numeMesa2.setLayoutX(posx2);
                        _numeMesa2.setLayoutY(posy2);
                        
                
                
                    });
                        
                    c.setOnMouseClicked((MouseEvent e4)->{
                    //_planos.getChildren().add(borrarMesa);
                        //borrarMesa.setOnMouseClicked((MouseEvent e5)->{

                    _seccionPlanos.getChildren().remove(_numeMesa);
                    _seccionPlanos.getChildren().remove(c);
                    mesas.remove(m);
                    _seccionMonitoreo.getChildren().remove(_numeMesa2);
                    _seccionMonitoreo.getChildren().remove(c2);
                    

                    //_planos.getChildren().remove(borrarMesa);


                    //});
                           
                    });
                     c2.setOnMouseMoved((MouseEvent e6)->{
                               System.out.println("ooo");
                              
                               
                           
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
           _planos.getChildren().add(l);
           //_rootA.getChildren().add(_seccionPlanos);  
               
         }
          public void manejoReporteVentas(){
           Label l= new Label("manejar el evento en el flowPane");
           _planos.getChildren().add(l);
           //_rootA.getChildren().add(_seccionPlanos);
              
         }
          public void manejoAdminSalir(){
              
           Label l= new Label("manejar el evento en el flowPane");
           _planos.getChildren().add(l);
           //_rootA.getChildren().add(_seccionPlanos);
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
         
          public void crearSeccionPlanosyMonitoreo(){
            cocina= new Label("Cocina");
            cocina2= new Label("Cocina");
            rect.setLayoutX(400);
            rect.setLayoutY(5);
            cocina.setLayoutX(410);
            cocina.setLayoutY(35);
            
            rect2.setLayoutX(400);
            rect2.setLayoutY(5);
            cocina2.setLayoutX(410);
            cocina2.setLayoutY(35);
            
            Mesa m= new Mesa(10,"1",50.0,50.0);
            Mesa m2= new Mesa(10,"1",50.0,50.0);
            Circle c= m.getCircle();
            Circle c2= m2.getCircle();
            c.setCenterX(50.0);
            c.setCenterY(50.0);
            Label _numeMesa= new Label("1");
            _numeMesa.setLayoutX(50.0);
            _numeMesa.setLayoutY(50.0);
            c2.setCenterX(50.0);
            c2.setCenterY(50.0);
            Label _numeMesa2= new Label("1");
            _numeMesa2.setLayoutX(50.0);
            _numeMesa2.setLayoutY(50.0);
            _seccionPlanos.getChildren().addAll(cocina, rect,c,_numeMesa);
            _seccionMonitoreo.getChildren().addAll(cocina2, rect2,c2,_numeMesa2);
            mesas.add(m);
            c.setOnMouseDragged((MouseEvent e3)->{
                c.setCenterX(e3.getSceneX());
                c.setCenterY(e3.getSceneY());
                _numeMesa.setLayoutX(e3.getSceneX());
                _numeMesa.setLayoutY(e3.getSceneY());
                m.setCentrox(e3.getSceneX());
                m.setCentroy(e3.getSceneY());
                c2.setCenterX(e3.getSceneX());
                c2.setCenterY(e3.getSceneY());
                _numeMesa2.setLayoutX(e3.getSceneX());
                _numeMesa2.setLayoutY(e3.getSceneY());
                m2.setCentrox(e3.getSceneX());
                m2.setCentroy(e3.getSceneY());
            });
                        
            c.setOnMouseClicked((MouseEvent e4)->{
                //_planos.getChildren().add(borrarMesa);
                //borrarMesa.setOnMouseClicked((MouseEvent e5)->{
                _seccionPlanos.getChildren().remove(_numeMesa);
                _seccionPlanos.getChildren().remove(c);
               // _planos.getChildren().remove(borrarMesa);


             // });

            });
             c2.setOnMouseMoved((MouseEvent e6)->{
                System.out.println("ooo");
          
            });
         
}
             
          /*private class MonitoreoPlano implements Runnable{
            
          
            private MonitoreoPlano() {

            }

            @Override
            public void run() {
                continuar= true;
                try{
                    while(continuar==true){
                        System.out.println("hilloo");
                        mesas2=(ArrayList<Mesa>) mesas.clone();
                        
                        Platform.runLater(()->{
                               _seccionMonitoreo.getChildren().clear();
                               _seccionMonitoreo.getChildren().addAll(rect2,cocina2);});
                               //_seccionMonitoreo.getChildren().addAll(_seccionPlanos.getChildren());});
                               
                        
                    
                  for (Mesa m: mesas2){
                      
                      Mesa m2= new Mesa(m.getRadio(),m.getNumero(),m.getCentrox(),m.getCentroy());   
                      Label nume_mesa=  new Label(m.getNumero());
                      Circle c1= m2.getCircle();  
                       c1.setOnMouseMoved((MouseEvent e)->{
                               System.out.println("ooo");
                               _rootA.getChildren().add(new Label("AAA"));
                               
                           
                           });
                       //if(_seccionMonitoreo.getChildren().contains(c1)==false){
                           Platform.runLater(()->{
                               _seccionMonitoreo.getChildren().addAll(c1,nume_mesa);
                               double posx3=m.getCentrox();
                               double posy3=m.getCentroy();
                               c1.setCenterX(posx3);
                               c1.setCenterY(posy3);
                               //c1.setLayoutX(m.getCentrox());
                               //c1.setLayoutY(m.getCentroy());
                               nume_mesa.setLayoutX(m.getCentrox());
                               nume_mesa.setLayoutY(m.getCentroy());
                            });
                          
                           
                       //}
                  }
                }Thread.sleep(700000000);
 
                }catch(InterruptedException ex){
                    System.out.println("aaa");
                    System.out.println(ex.getMessage());
                    
                }
                  
                //definir condicion de terminar
                 

            }}*/}



