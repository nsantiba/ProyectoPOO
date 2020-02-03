/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Actores.Cliente;
import Actores.Mesa;
import Actores.Mesero;
import Actores.Producto;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;

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
      Stage nuevaVentanaOrden;
      VBox rootVentanaOrden;
      Label _labelOrdenHeader;
      Scene sc3;
      Button _finalizarOrden;
      HBox _ventanaSig;
      Button _regresar;
      VBox _seccionMenu;
      VBox _menu;
      VBox _seccionOrdenes;
      VBox ordenes; 
      FlowPane productosMenu;
      Button infoProducto;
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
                            System.out.println("Amarillo");
                            crearVentana();
                            _aceptar.setOnMouseClicked((MouseEvent ev5)->{
                            String infocliente = _nombreCliente.getText();
                            nuevaVentana.close();
                            Cliente infocliente2 = new Cliente(infocliente);
                            Programa.clientes.add(infocliente2);
                            m.setCliente(infocliente2);
                            m.setOcupado(true);
                            //m.setColor("green");
                            c.setFill(Color.GREEN);
                            mesero.getMesas().add(m);
                            System.out.println(m.getCliente().getInfo());
                        
                    });}
                        if((m.getOcupado()==true)&& (mesero.getMesas().contains(m)==false)){
                        System.out.println("Esta ocupada (Rojo)");
                    }
                        
                        if((m.getOcupado()==true) && (mesero.getMesas().contains(m)==true)){
                            System.out.println("Verde");
                            
                            _labelOrdenHeader= new Label("Mesa: "+m.getNumero()+" - Cliente: "+m.getCliente().getInfo());
                            
                            crearVentanaOrden(_labelOrdenHeader);
                            try {
                                manejoMenuMesero();
                            } catch (FileNotFoundException ex) {
                                System.out.println("No se encontro archivo");
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

    public void crearVentanaOrden(Label l){
          nuevaVentanaOrden= new Stage();
          rootVentanaOrden= new VBox();
          
          _ventanaSig= new HBox();
          
          Rectangle rect= new Rectangle(3, 250);
            //rect.setLayoutX(285);
            //rect.setLayoutY(5);
            
          _seccionOrdenes = new VBox();
           ordenes = new VBox();
          _finalizarOrden= new Button("Finalizar Orden");
          _regresar = new Button("Regresar");
          
          _seccionMenu = new VBox();
          _menu = new VBox();
          
          sc3= new Scene(rootVentanaOrden, 600,600); 
          
          _seccionOrdenes.getChildren().addAll(ordenes,_finalizarOrden,_regresar);
          _seccionMenu.getChildren().addAll(_menu);
          _ventanaSig.getChildren().addAll(_seccionOrdenes,rect,_seccionMenu);
          rootVentanaOrden.getChildren().addAll(l,_ventanaSig);
          
          nuevaVentanaOrden.setScene(sc3);
          nuevaVentanaOrden.show();

        }    

    public void manejoMenuMesero() throws FileNotFoundException{
        ComboBox<String> ctipo= new ComboBox (FXCollections.observableArrayList("Salado","Bebida","Postre"));
        Button postres = new Button ( "Postres ", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/postres.png" ) ) ) );
          Button bebidas = new Button ( "Bebidas", new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/bebidas.png" ) ) ) );
          Button salados = new Button ( "Salados",  new ImageView ( new Image ( new FileInputStream ( "src/recursos/botones/salados.png" ) ) ) );
          HBox opcionesMenu = new HBox();
          productosMenu = new FlowPane();
        opcionesMenu.getChildren ( ).addAll ( postres, bebidas, salados ) ;
        _menu.getChildren ( ).addAll ( opcionesMenu, productosMenu );
        
        
            EventHandler < MouseEvent > ev2 = (MouseEvent ev1) -> {
                try{
                    productosMenu.getChildren ( ).clear ( );
                    if (ev1.getSource() == postres) {
                        System.out.println("Dentro");
                        mostrarPorductos("Postre");
                    }
                    if (ev1.getSource() == bebidas) {
                        System.out.println("Dentro1");
                        mostrarPorductos("Bebida");
                    }
                    if (ev1.getSource() == salados) {
                        System.out.println ( "Dentro3" );
                        mostrarPorductos ( "Salado" );
                    }
                    }catch ( FileNotFoundException ex )
                            {
                                System.out.println(ex.getMessage());
                            }
               }; 
            postres.setOnMouseClicked ( ev2 );
            bebidas.setOnMouseClicked ( ev2 );
            salados.setOnMouseClicked ( ev2 );
    }
    
    public void mostrarPorductos ( String tipo ) throws FileNotFoundException
    {
        for ( Producto p: Programa.productos )
        {
            if ( p.getTipo ( ).equals ( tipo ) )
            {
                
                String s = p.getN_imagen();
                FileInputStream inputstream = new FileInputStream(s); 
                Image img = new Image(inputstream);
                ImageView imgview = new ImageView(img);
                imgview.setFitHeight(50);
                imgview.setFitWidth(50);
                String l1= p.getNombreProducto();
                String l2= String.valueOf(p.getPrecio());
                String l3 = ("Nombre: "+l1+"\n"+"Precio: "+l2);
                infoProducto = new Button(l3,imgview);
                productosMenu.getChildren().add(infoProducto);
            }
        }
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
